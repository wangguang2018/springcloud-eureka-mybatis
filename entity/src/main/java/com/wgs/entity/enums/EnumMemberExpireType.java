package com.wgs.entity.enums;

public enum EnumMemberCouponStatus {

    overdue("已过期",(byte)-1),
    no_yet("未使用",(byte)0),
    userd("已使用",(byte)1);

    public String name;
    public Byte value;

    EnumMemberCouponStatus(String name, Byte value){
        this.name = name;
        this.value = value;
    }
}
