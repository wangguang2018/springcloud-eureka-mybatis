package com.wgs.dto.coupon;

import com.wgs.entity.MemberCoupon;

import java.io.Serializable;

public class MemberCouponDto extends MemberCoupon {


    /**
     * 有效期的开始时间
     */
    private String startDateStr;

    /**
     * 有效期的结束时间
     */
    private String endDateStr;

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }
}
