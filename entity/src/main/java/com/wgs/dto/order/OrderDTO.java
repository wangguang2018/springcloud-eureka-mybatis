package com.wgs.dto.order;

import com.wgs.entity.Order;

import java.util.List;

public class OrderDTO extends Order {

    private List<OrderGoodsInfoDTO> goodsList;

    public List<OrderGoodsInfoDTO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoodsInfoDTO> goodsList) {
        this.goodsList = goodsList;
    }
}
