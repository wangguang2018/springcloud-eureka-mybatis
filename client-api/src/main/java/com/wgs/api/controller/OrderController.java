package com.wgs.api.controller;

import com.wgs.api.service.OrderService;
import com.wgs.dto.BaseResult;
import com.wgs.entity.MemberAddress;
import com.ydd.framework.core.annotation.AccessToken;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseApiController {

    @Resource
    private OrderService orderService;


    /**
     * 购物车下单
     * @param addressId
     * @return
     */
    @AccessToken
    @RequestMapping(value = "/goods/car",method = RequestMethod.POST)
    public ResponseDTO orderWithGoodsCar(@RequestParam("addressId") Integer addressId){
        orderService.orderWithGoodsCar(getLoginMemberId(),addressId);
        return ResponseDTO.ok();
    }

    /**
     * 商品下单
     * @param addressId
     * @param skuGroupId
     * @param num
     * @return
     */
    @AccessToken
    @RequestMapping(value = "/goods",method = RequestMethod.POST)
    public ResponseDTO orderWithGoods( @RequestParam("addressId") Integer addressId,
                                       @RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("num") Integer num){
        orderService.orderWithGoods(getLoginMemberId(),addressId,skuGroupId,num);
        return ResponseDTO.ok();
    }

    /**
     * 商品下单 使用微信收货地址
     * @param memberAddress
     * @param skuGroupId
     * @param num
     * @return
     */
    @AccessToken
    @RequestMapping("/goods/wechat")
    public ResponseDTO orderWithGoodsWechatAddr(MemberAddress memberAddress,
                                       @RequestParam("skuGroupId") Integer skuGroupId, @RequestParam("num") Integer num){
        orderService.orderWithGoods(getLoginMemberId(),memberAddress,skuGroupId,num);
        return ResponseDTO.ok();
    }

    /**
     * 购物车下单 使用微信收货地址
     * @param memberAddress
     * @return
     */
    @AccessToken
    @RequestMapping("/goods/car/wechat")
    public ResponseDTO orderWithGoodsCarWechatAddr(MemberAddress memberAddress){
        orderService.orderWithGoodsCar(getLoginMemberId(),memberAddress);
        return ResponseDTO.ok();
    }

    /**
     * 用户的订单列表
     * @param pagination
     * @return
     */
    @AccessToken
    @RequestMapping("/list")
    public ResponseDTO orderList(Pagination pagination){
        BaseResult<Pagination> baseResult = orderService.findOrderListByMember(getLoginMemberId(),pagination);
        return ResponseDTO.ok().addAttribute("data",baseResult.getContent());
    }

    /**
     * 订单详细
     * @param orderSn
     * @return
     */
    @RequestMapping("/info")
    @AccessToken
    public ResponseDTO findOrderInfo(@RequestParam("orderSn") String orderSn){
        BaseResult result = orderService.findOrderInfo(getLoginMemberId(),orderSn);
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }
}
