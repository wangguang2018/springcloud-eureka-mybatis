package com.wgs.entity.enums;

public enum EnumMemberExpireType {

    days("有效天数",(byte)1),
    period("优惠券时间",(byte)2);

    public String name;
    public Byte value;

    EnumMemberExpireType(String name, Byte value){
        this.name = name;
        this.value = value;
    }
}
