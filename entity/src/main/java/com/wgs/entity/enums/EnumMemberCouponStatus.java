package com.wgs.entity.enums;

public enum OrderStatusEnum {

    CLOSED("交易关闭",(byte)-1),NO_PAY("待付款",(byte)1),PENDING_DELIVERY("待发货",(byte)2),
    PENDING_RECEIVED("待收货",(byte)3),DONE("已完成",(byte)4);

    public String name;
    public Byte value;

    OrderStatusEnum(String name,Byte value){
        this.name = name;
        this.value = value;
    }
}
