package com.wgs.api.service;

import com.wgs.dto.BaseResult;
import com.wgs.dto.order.OrderDTO;
import com.wgs.entity.MemberAddress;
import com.ydd.framework.core.common.Pagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-api")
public interface OrderService {

    /**
     * 购物车下单
     *
     * @param memberId
     * @param addressId
     */
    @RequestMapping("/orderWithGoodsCar")
    BaseResult orderWithGoodsCar(@RequestParam("memberId") Integer memberId, @RequestParam("addressId") Integer addressId);

    /**
     * 购物车下单（微信收货地址）
     *
     * @param memberId
     * @param memberAddress
     */
    @RequestMapping("/orderWithGoodsCar/wechat/address")
    BaseResult orderWithGoodsCar(@RequestParam("memberId") Integer memberId, MemberAddress memberAddress);

    /**
     * 单个商品下单
     *
     * @param memberId
     * @param addressId
     * @param skuGroupId
     */
    @RequestMapping("/orderWithGoods")
    BaseResult orderWithGoods(@RequestParam("memberId") Integer memberId, @RequestParam("addressId") Integer addressId,
                              @RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("num") Integer num);

    /**
     * 单个商品下单 （使用微信收货地址）
     *
     * @param memberId
     * @param memberAddress
     * @param skuGroupId
     * @param num
     */
    @RequestMapping("/orderWithGoods/wechat/address")
    BaseResult orderWithGoods(@RequestParam("memberId") Integer memberId, MemberAddress memberAddress,
                              @RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("num") Integer num);

    /**
     * 用户订单列表
     * @param memberId
     * @param pagination
     * @return
     */
    @RequestMapping("/findMemberOrderList")
    BaseResult<Pagination> findOrderListByMember(@RequestParam("memberId") Integer memberId,Pagination pagination);

    @RequestMapping("/findOrderInfo")
    BaseResult<OrderDTO> findOrderInfo(@RequestParam("memberId") Integer memberId, @RequestParam("orderSn") String orderSn);


    /**
     * 取消订单
     * @param memberId
     * @param orderSn
     * @return
     */
    @RequestMapping("/cancelOrder")
    BaseResult cancelOrder(@RequestParam("memberId")Integer memberId,@RequestParam("orderSn") String orderSn);

    /**
     * 删除订单
     * @param memberId
     * @param orderSn
     * @return
     */
    @RequestMapping("/deleteOrder")
    BaseResult deleteOrder(@RequestParam("memberId")Integer memberId,@RequestParam("orderSn") String orderSn);

    /**
     * 确认收货
     * @param memberId
     * @param orderSn
     * @return
     */
    @RequestMapping("/confirmOrder")
    BaseResult confirmOrder(@RequestParam("memberId")Integer memberId,@RequestParam("orderSn") String orderSn);
}
