package com.wgs.eurekaprovider.service.order;

import com.github.pagehelper.PageHelper;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.dto.order.OrderDTO;
import com.wgs.dto.order.OrderGoodsInfoDTO;
import com.wgs.dto.wechat.OrderPaySignResponse;
import com.wgs.entity.*;
import com.wgs.entity.enums.OrderStatusEnum;
import com.wgs.entity.exception.ExceptionCodeTemplate;
import com.wgs.eurekaprovider.service.goods.GoodsCarService;
import com.wgs.eurekaprovider.service.goods.GoodsService;
import com.wgs.eurekaprovider.service.member.MemberAddressService;
import com.wgs.eurekaprovider.service.wechat.WechatService;
import com.wgs.mapper.OrderAddressMapper;
import com.wgs.mapper.OrderGoodsInfoMapper;
import com.wgs.mapper.OrderGoodsMapper;
import com.wgs.mapper.OrderMapper;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.exception.ServiceException;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.wgs.entity.exception.ExceptionCodeTemplate.ORDER_ERROR;

/**
 * 订单
 */
@Service
public class OrderService extends BaseServiceImpl {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderGoodsMapper orderGoodsMapper;

    @Resource
    private OrderGoodsInfoMapper orderGoodsInfoMapper;

    @Resource
    private OrderAddressMapper orderAddressMapper;

    @Resource
    private GoodsService goodsService;

    @Resource
    private MemberAddressService memberAddressService;

    @Resource
    private GoodsCarService goodsCarService;

    @Resource
    private WechatService wechatService;

    /**
     * 下单
     *
     * @param memberId
     * @param memberAddress
     * @param goodsCarDTOS
     */
    @Transactional
    public String order(Integer memberId, MemberAddress memberAddress, List<GoodsCarDTO> goodsCarDTOS) {
        if (goodsCarDTOS != null && goodsCarDTOS.size() > 0) {
            //总价
            BigDecimal totalPrice = new BigDecimal(0);
            //订单商品价格信息
            List<OrderGoods> orderGoodsList = new ArrayList<>();
            //订单商品文本信息
            List<OrderGoodsInfoDTO> orderGoodsInfoList = new ArrayList<>();
            for (GoodsCarDTO g : goodsCarDTOS) {
                GoodsSkuGroup skuGroup = goodsService.findSkuGroupById(g.getSkuGroupId());
                if (skuGroup == null)
                    continue;
                Goods goods = goodsService.findById(skuGroup.getGoodsId());
                if (goods == null)
                    continue;
                if(g.getNum() <= 0)
                    continue;
                GoodsSkuGroupInfo goodsSkuGroupInfo = goodsService.findSkuGroupInfoByGroupId(skuGroup.getId());
                //商品总价
                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setGoodsPrice(skuGroup.getPrice());
                orderGoods.setTotalPrice(skuGroup.getPrice().multiply(new BigDecimal(g.getNum())));
                orderGoods.setGoodsId(goods.getId());
                orderGoods.setNum(g.getNum());
                orderGoods.setSkuGroupId(skuGroup.getId());
                //总计累加价格
                totalPrice = totalPrice.add(orderGoods.getTotalPrice());
                orderGoodsList.add(orderGoods);

                //商品详细文本信息
                OrderGoodsInfoDTO orderGoodsInfo = new OrderGoodsInfoDTO();
                orderGoodsInfo.setOrderGoods(orderGoods);
                orderGoodsInfo.setGoodsImg(goods.getCover());
                orderGoodsInfo.setGoodsSn(goods.getGoodsSn());
                orderGoodsInfo.setGoodsName(goods.getGoodsName());
                orderGoodsInfo.setSkuName(goodsService.getSkuInfoNameBySkuIds(skuGroup.getGoodsSkuInfoIds()));
                orderGoodsInfo.setLensColor(goodsSkuGroupInfo.getLensColor());
                orderGoodsInfo.setSpectaclesFrameMaterial(goodsSkuGroupInfo.getSpectaclesFrameMaterial());
                orderGoodsInfoList.add(orderGoodsInfo);
            }
            if(orderGoodsList.size() <= 0)
                return "";
            // 生成订单并且保存
            Order order = new Order();
            order.setMemberId(memberId);
            order.setOrderSn(createSn());
            order.setPayPrice(totalPrice);
            order.setTotalPrice(totalPrice);
            //待付款状态
            order.setStatus(OrderStatusEnum.NO_PAY.value.intValue());
            orderMapper.insert(order);
            //保存订单商品信息
            saveOrderInfo(orderGoodsList,orderGoodsInfoList,order);
            //保存订单收货地址信息
            saveOrderAddress(memberId,order,memberAddress);
            return order.getOrderSn();
        }
        return "";
    }


    @Transactional
    public String order(Integer memberId,Integer addressId, List<GoodsCarDTO> goodsCarDTOS){
        MemberAddress address = memberAddressService.findById(memberId,addressId);
        if (address == null)
            throw new ServiceException(ORDER_ERROR);
        return order(memberId,address,goodsCarDTOS);
    }

    /**
     * 购物车结算
     * @param memberId
     * @param addressId
     */
    @Transactional
    public String orderWithGoodsCar(Integer memberId,Integer addressId){
        List<GoodsCarDTO> goodsCarDTOS = goodsCarService.findGoodsCarByMember(memberId);
        if(goodsCarDTOS == null || goodsCarDTOS.size() <= 0)
            throw new ServiceException(ORDER_ERROR);
        String orderSn = order(memberId,addressId,goodsCarDTOS);
        goodsCarService.clearGoodsCar(memberId);
        return orderSn;
    }

    /**
     * 购物车结算
     * @param memberId
     * @param memberAddress
     */
    @Transactional
    public String orderWithGoodsCar(Integer memberId,MemberAddress memberAddress){
        List<GoodsCarDTO> goodsCarDTOS = goodsCarService.findGoodsCarByMember(memberId);
        if(goodsCarDTOS == null || goodsCarDTOS.size() <= 0)
            throw new ServiceException(ORDER_ERROR);
        String orderSn = order(memberId,memberAddress,goodsCarDTOS);
        goodsCarService.clearGoodsCar(memberId);
        return orderSn;
    }

    /**
     * 单个商品下单
     * @param memberId
     * @param addressId 收货地址ID
     * @param skuGroupId 商品sku组合ID
     * @param num 数量
     */
    @Transactional
    public String orderWithGoods(Integer memberId,Integer addressId,Integer skuGroupId,Integer num){
        List<GoodsCarDTO> goodsCarDTOS = getGoodsCarDTOS(skuGroupId, num);
        return order(memberId,addressId,goodsCarDTOS);
    }

    /**
     * 单个商品下单
     * @param memberId
     * @param memberAddress  收货地址（微信）
     * @param skuGroupId 商品sku组合ID
     * @param num 数量
     */
    @Transactional
    public String orderWithGoods(Integer memberId,MemberAddress memberAddress,Integer skuGroupId,Integer num) {
        List<GoodsCarDTO> goodsCarDTOS = getGoodsCarDTOS(skuGroupId, num);
        return order(memberId,memberAddress,goodsCarDTOS);
    }


    private List<GoodsCarDTO> getGoodsCarDTOS(Integer skuGroupId, Integer num) {
        GoodsCarDTO goodsCarDTO = new GoodsCarDTO();
        goodsCarDTO.setSkuGroupId(skuGroupId);
        goodsCarDTO.setNum(num);
        List<GoodsCarDTO> goodsCarDTOS = new ArrayList<>();
        goodsCarDTOS.add(goodsCarDTO);
        return goodsCarDTOS;
    }
    /**
     * 保存订单商品信息
     * @param orderGoodsList 订单商品价格信息
     * @param orderGoodsInfoList 订单商品详细文本信息
     */
    private void saveOrderInfo(List<OrderGoods> orderGoodsList, List<OrderGoodsInfoDTO> orderGoodsInfoList,Order order) {
        orderGoodsMapper.save(orderGoodsList,order);
        orderGoodsInfoMapper.save(orderGoodsInfoList);
    }

    /**
     * 保存订单收货地址
     * @param memberId
     * @param order
     * @param memberAddress
     */
    private void saveOrderAddress(Integer memberId, Order order, MemberAddress memberAddress) {
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setContact(memberAddress.getContact());
        orderAddress.setPhone(memberAddress.getPhone());
        orderAddress.setMemberId(memberId);
        orderAddress.setOrderId(order.getId());
        orderAddress.setOrderSn(order.getOrderSn());
        orderAddress.setAddress(memberAddress.getAddress());
        orderAddressMapper.insert(orderAddress);
    }

    /**
     * 获取订单列表
     * @param memberId
     * @param pagination
     * @return
     */
    public Pagination orderList(Integer memberId, Integer status,Pagination pagination){
        PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
        pagination.setQueryResult(orderMapper.findOrderList(memberId,status));
        return pagination;
    }

    /**
     * 获取订单详细
     * @param memberId
     * @param orderSn
     * @return
     */
    public OrderDTO findOrderInfo(Integer memberId,String orderSn){
        return orderMapper.findOrderInfo(orderSn,memberId);
    }

    /**
     * 取消订单（只能取消未支付的）
     * @param orderSn
     * @param memberId
     */
    @Transactional
    public void cancelOrder(String orderSn,Integer memberId){
        Order order = orderMapper.findOrderSn(orderSn,memberId);
        if(order == null)
            return;
        if(order.getStatus().intValue() != OrderStatusEnum.NO_PAY.value.intValue()){
            return;
        }
        orderMapper.updateOrderStatus(memberId,orderSn,OrderStatusEnum.CLOSED.value);
    }

    /**
     * 删除订单（只能删除交易关闭的）
     * @param orderSn
     * @param memberId
     */
    @Transactional
    public void deleteOrder(String orderSn,Integer memberId){
        Order order = orderMapper.findOrderSn(orderSn,memberId);
        if(order == null)
            return;
        if(order.getStatus().intValue() != OrderStatusEnum.CLOSED.value.intValue()){
            return;
        }
        orderMapper.delete(order.getId());
    }

    /**
     * 确认收货 只能确认待收货的
     * @param orderSn
     * @param memberId
     */
    @Transactional
    public void confirmOrder(String orderSn,Integer memberId){
        Order order = orderMapper.findOrderSn(orderSn,memberId);
        if(order == null)
            return;
        if(order.getStatus().intValue() != OrderStatusEnum.PENDING_RECEIVED.value.intValue()){
            return;
        }
        orderMapper.updateOrderStatus(memberId,orderSn,OrderStatusEnum.DONE.value);
    }

    /**
     * 微信下单
     * @param orderSn
     * @param memberId
     * @return
     */
    public OrderPaySignResponse.WechatPayParam createUnifiedOrder(String orderSn,Integer memberId, String ip){
        Order order = orderMapper.findOrderSn(orderSn,memberId);
        if(order == null)
            throw new ServiceException(ExceptionCodeTemplate.ORDER_ERROR);
        return wechatService.createUnifiedOrder(orderSn,order.getPayPrice(),ip,"JSAPI",memberId);
    }

    /**
     * 支付成功
     * @param orderId
     */
    @Transactional
    public void paySuccess(Integer orderId,String tradeSn){
        Order order = new Order();
        order.setId(orderId);
        order.setStatus(OrderStatusEnum.PENDING_DELIVERY.value.intValue());
        order.setTransactionSn(tradeSn);
        order.setPayTime(new Date());
        orderMapper.update(order);
    }

    public Order findByOrderSn(String orderSn,Integer memberId){
        return orderMapper.findOrderSn(orderSn,memberId);
    }

    /**
     * 生成订单号
     *
     * @return
     */
    private String createSn() {
        return DateFormatUtils.format(getCurrentTime(), "yyMMddHHmmss") + RandomStringUtils.randomNumeric(6);
    }
}
