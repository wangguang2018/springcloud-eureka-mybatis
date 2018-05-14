package com.wgs.dto.order;

import com.wgs.entity.Order;
import com.wgs.entity.OrderAddress;

import javax.annotation.Resource;
import java.util.List;

public class OrderDTO extends Order {

    private List<OrderGoodsDTO> goodsList;

    private OrderAddress orderAddress;

    public List<OrderGoodsDTO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoodsDTO> goodsList) {
        this.goodsList = goodsList;
    }

    public OrderAddress getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(OrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }
}
