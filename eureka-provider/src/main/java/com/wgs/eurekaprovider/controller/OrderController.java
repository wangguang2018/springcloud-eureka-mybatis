package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.dto.order.OrderDTO;
import com.wgs.entity.MemberAddress;
import com.wgs.eurekaprovider.service.order.OrderService;
import com.ydd.framework.core.common.Pagination;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    public OrderService orderService;

    /**
     * 购物车下单
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/orderWithGoodsCar")
    public BaseResult orderWithGoodsCar(@RequestParam("memberId") Integer memberId, @RequestParam("addressId") Integer addressId){
        orderService.orderWithGoodsCar(memberId,addressId);
        return new BaseResult();
    }

    /**
     * 购物车下单（微信收货地址）
     * @param memberId
     * @param memberAddress
     */
    @RequestMapping("/orderWithGoodsCar/wechat/address")
    public BaseResult orderWithGoodsCar(@RequestParam("memberId") Integer memberId, MemberAddress memberAddress){
        orderService.orderWithGoodsCar(memberId,memberAddress);
        return new BaseResult();
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
        orderService.orderWithGoods(memberId,addressId,skuGroupId,num);
        return new BaseResult();
    }

    /**
     * 单个商品下单 （使用微信收货地址）
     * @param memberId
     * @param memberAddress
     * @param skuGroupId
     * @param num
     */
    @RequestMapping("/orderWithGoods/wechat/address")
    public BaseResult orderWithGoods(@RequestParam("memberId") Integer memberId,MemberAddress memberAddress,
                               @RequestParam("skuGroupId") Integer skuGroupId,@RequestParam("num") Integer num){
        orderService.orderWithGoods(memberId,memberAddress,skuGroupId,num);
        return new BaseResult();
    }

    /**
     * 订单列表
     * @param memberId
     * @param pagination
     * @return
     */
    @RequestMapping("/findMemberOrderList")
    public BaseResult<Pagination> findMemberOrderList(@RequestParam("memberId") Integer memberId,Pagination pagination){
        pagination = orderService.orderList(memberId,pagination);
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
}
