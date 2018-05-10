package com.wgs.eurekaprovider.controller;

import com.wgs.entity.MemberAddress;
import com.wgs.eurekaprovider.service.order.OrderService;
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
    public void orderWithGoodsCar(@RequestParam("memberId") Integer memberId, @RequestParam("addressId") Integer addressId){
        orderService.orderWithGoodsCar(memberId,addressId);
    }

    /**
     * 购物车下单（微信收货地址）
     * @param memberId
     * @param memberAddress
     */
    @RequestMapping("/orderWithGoodsCar/wechat/address")
    public void orderWithGoodsCar(@RequestParam("memberId") Integer memberId, MemberAddress memberAddress){
        orderService.orderWithGoodsCar(memberId,memberAddress);
    }

    /**
     * 单个商品下单
     * @param memberId
     * @param addressId
     * @param skuGroupId
     */
    @RequestMapping("/orderWithGoods")
    public void orderWithGoods(@RequestParam("memberId") Integer memberId,@RequestParam("addressId") Integer addressId,
                               @RequestParam("skuGroupId") Integer skuGroupId,@RequestParam("num") Integer num){
        orderService.orderWithGoods(memberId,addressId,skuGroupId,num);
    }

    /**
     * 单个商品下单 （使用微信收货地址）
     * @param memberId
     * @param memberAddress
     * @param skuGroupId
     * @param num
     */
    @RequestMapping("/orderWithGoods/wechat/address")
    public void orderWithGoods(@RequestParam("memberId") Integer memberId,MemberAddress memberAddress,
                               @RequestParam("skuGroupId") Integer skuGroupId,@RequestParam("num") Integer num){
        orderService.orderWithGoods(memberId,memberAddress,skuGroupId,num);
    }

}
