package com.wgs.eurekaprovider.service.order;

import com.github.pagehelper.PageHelper;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.dto.order.OrderDTO;
import com.wgs.dto.order.OrderGoodsInfoDTO;
import com.wgs.entity.*;
import com.wgs.entity.enums.OrderStatusEnum;
import com.wgs.eurekaprovider.service.goods.GoodsCarService;
import com.wgs.eurekaprovider.service.goods.GoodsService;
import com.wgs.eurekaprovider.service.member.MemberAddressService;
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

    /**
     * 下单
     *
     * @param memberId
     * @param memberAddress
     * @param goodsCarDTOS
     */
    @Transactional
    public void order(Integer memberId, MemberAddress memberAddress, List<GoodsCarDTO> goodsCarDTOS) {
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
                return;
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
        }
    }


    @Transactional
    public void order(Integer memberId,Integer addressId, List<GoodsCarDTO> goodsCarDTOS){
        MemberAddress address = memberAddressService.findById(memberId,addressId);
        if (address == null)
            throw new ServiceException(ORDER_ERROR);
        order(memberId,address,goodsCarDTOS);
    }

    /**
     * 购物车结算
     * @param memberId
     * @param addressId
     */
    @Transactional
    public void orderWithGoodsCar(Integer memberId,Integer addressId){
        List<GoodsCarDTO> goodsCarDTOS = goodsCarService.findGoodsCarByMember(memberId);
        if(goodsCarDTOS == null || goodsCarDTOS.size() <= 0)
            throw new ServiceException(ORDER_ERROR);
        order(memberId,addressId,goodsCarDTOS);
    }

    /**
     * 购物车结算
     * @param memberId
     * @param memberAddress
     */
    @Transactional
    public void orderWithGoodsCar(Integer memberId,MemberAddress memberAddress){
        List<GoodsCarDTO> goodsCarDTOS = goodsCarService.findGoodsCarByMember(memberId);
        if(goodsCarDTOS == null || goodsCarDTOS.size() <= 0)
            throw new ServiceException(ORDER_ERROR);
        order(memberId,memberAddress,goodsCarDTOS);
    }

    /**
     * 单个商品下单
     * @param memberId
     * @param addressId 收货地址ID
     * @param skuGroupId 商品sku组合ID
     * @param num 数量
     */
    public void orderWithGoods(Integer memberId,Integer addressId,Integer skuGroupId,Integer num){
        List<GoodsCarDTO> goodsCarDTOS = getGoodsCarDTOS(skuGroupId, num);
        order(memberId,addressId,goodsCarDTOS);
    }

    /**
     * 单个商品下单
     * @param memberId
     * @param memberAddress  收货地址（微信）
     * @param skuGroupId 商品sku组合ID
     * @param num 数量
     */
    public void orderWithGoods(Integer memberId,MemberAddress memberAddress,Integer skuGroupId,Integer num) {
        List<GoodsCarDTO> goodsCarDTOS = getGoodsCarDTOS(skuGroupId, num);
        order(memberId,memberAddress,goodsCarDTOS);
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
    public Pagination orderList(Integer memberId, Pagination pagination){
        PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
        pagination.setQueryResult(orderMapper.findOrderList(memberId));
        return pagination;
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
