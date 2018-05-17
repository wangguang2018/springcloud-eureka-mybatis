package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.dto.order.OrderDTO;
import com.wgs.dto.wechat.OrderPaySignResponse;
import com.wgs.entity.MemberAddress;
import com.wgs.entity.Order;
import com.wgs.entity.exception.ExceptionCodeTemplate;
import com.wgs.eurekaprovider.service.order.OrderService;
import com.wgs.eurekaprovider.service.wechat.WechatService;
import com.wgs.eurekaprovider.util.StringHelper;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.exception.ServiceException;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private WechatService wechatService;

    /**
     * 购物车下单
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/orderWithGoodsCar")
    public BaseResult orderWithGoodsCar(@RequestParam("memberId") Integer memberId, @RequestParam("addressId") Integer addressId){
        String orderSn = orderService.orderWithGoodsCar(memberId,addressId);
        return new BaseResult(orderSn);
    }

    /**
     * 购物车下单（微信收货地址）
     * @param memberId
     * @param memberAddress
     */
    @RequestMapping("/orderWithGoodsCar/wechat/address")
    public BaseResult orderWithGoodsCar(@RequestParam("memberId") Integer memberId, @RequestBody MemberAddress memberAddress){
        String orderSn = orderService.orderWithGoodsCar(memberId,memberAddress);
        return new BaseResult(orderSn);
    }

    /**
     * 单个商品下单
     * @param memberId
     * @param addressId
     * @param skuGroupId
     */
    @RequestMapping("/orderWithGoods")
    public BaseResult orderWithGoods(@RequestParam("memberId") Integer memberId,@RequestParam("addressId") Integer addressId,
                               @RequestParam("skuGroupId") Integer skuGroupId,@RequestParam("num") Integer num){
        String orderSn = orderService.orderWithGoods(memberId,addressId,skuGroupId,num);
        return new BaseResult(orderSn);
    }

    /**
     * 单个商品下单 （使用微信收货地址）
     * @param memberId
     * @param memberAddress
     * @param skuGroupId
     * @param num
     */
    @RequestMapping("/orderWithGoods/wechat/address")
    public BaseResult orderWithGoods(@RequestParam("memberId") Integer memberId,@RequestBody MemberAddress memberAddress,
                               @RequestParam("skuGroupId") Integer skuGroupId,@RequestParam("num") Integer num){
        String orderSn = orderService.orderWithGoods(memberId,memberAddress,skuGroupId,num);
        return new BaseResult(orderSn);
    }

    /**
     * 订单列表
     * @param memberId
     * @param pagination
     * @return
     */
    @RequestMapping("/findMemberOrderList")
    public BaseResult<Pagination> findMemberOrderList(@RequestParam("memberId") Integer memberId, @RequestParam(value = "status",required = false) Integer status, @RequestBody Pagination pagination){
        pagination = orderService.orderList(memberId,status,pagination);
        return new BaseResult<>(pagination);
    }

    /**
     * 获取订单信息
     * @param memberId
     * @param orderSn
     * @return
     */
    @RequestMapping("/findOrderInfo")
    public BaseResult<OrderDTO> findOrderInfo(@RequestParam("memberId")Integer memberId,@RequestParam("orderSn") String orderSn){
        return new BaseResult<>(orderService.findOrderInfo(memberId,orderSn));
    }

    /**
     * 取消订单
     * @param memberId
     * @param orderSn
     * @return
     */
    @RequestMapping("/cancelOrder")
    public BaseResult cancelOrder(@RequestParam("memberId")Integer memberId,@RequestParam("orderSn") String orderSn){
        orderService.cancelOrder(orderSn,memberId);
        return new BaseResult();
    }

    /**
     * 删除订单
     * @param memberId
     * @param orderSn
     * @return
     */
    @RequestMapping("/deleteOrder")
    public BaseResult deleteOrder(@RequestParam("memberId")Integer memberId,@RequestParam("orderSn") String orderSn){
        orderService.deleteOrder(orderSn,memberId);
        return new BaseResult();
    }

    /**
     * 确认收货
     * @param memberId
     * @param orderSn
     * @return
     */
    @RequestMapping("/confirmOrder")
    public BaseResult confirmOrder(@RequestParam("memberId")Integer memberId,@RequestParam("orderSn") String orderSn){
        orderService.confirmOrder(orderSn,memberId);
        return new BaseResult();
    }

    /**
     * 微信下单
     * @param orderSn
     * @param memberId
     * @param ip
     * @return
     */
    @RequestMapping("/createUnifiedOrder")
    public BaseResult<OrderPaySignResponse.WechatPayParam> createUnifiedOrder(@RequestParam("orderSn") String orderSn, @RequestParam("memberId") Integer memberId,@RequestParam("ip") String ip){
        return new BaseResult<>(orderService.createUnifiedOrder(orderSn,memberId,ip));
    }

    /**
     * 微信回调
     * @return
     * @throws IOException
     */
    @RequestMapping("/wechatNotify")
    public BaseResult notify(@RequestBody Map<String,String> params) throws IOException {
        wechatService.notify(params);
        return new BaseResult();
    }

}
