package com.wgs.dto.order;

import com.wgs.entity.OrderGoods;
import com.wgs.entity.OrderGoodsInfo;

public class OrderGoodsDTO extends OrderGoods {


    private OrderGoodsInfo info;

    public OrderGoodsInfo getInfo() {
        return info;
    }

    public void setInfo(OrderGoodsInfo info) {
        this.info = info;
    }
}
