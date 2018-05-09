package com.wgs.dto.order;

import com.wgs.entity.OrderGoods;
import com.wgs.entity.OrderGoodsInfo;

public class OrderGoodsInfoDTO extends OrderGoodsInfo {

    private OrderGoods orderGoods;

    public OrderGoods getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(OrderGoods orderGoods) {
        this.orderGoods = orderGoods;
    }
}
