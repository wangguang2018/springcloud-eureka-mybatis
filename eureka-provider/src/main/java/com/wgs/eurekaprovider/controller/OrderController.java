package com.wgs.eurekaprovider.controller;

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

}
