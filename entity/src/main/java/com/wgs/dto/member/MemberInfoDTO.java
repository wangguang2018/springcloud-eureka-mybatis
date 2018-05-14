package com.wgs.dto.member;

import java.io.Serializable;

public class MemberInfoDTO implements Serializable {

    private String nickname;
    private String avatar;

    /**
     * 未支付订单数
     */
    private Integer noPayOrderNum;
    /**
     * 待发货订单数
     */
    private Integer pendingDeliveryOrderNum;
    /**
     * 待收货订单数
     */
    private Integer pendingReceivedOrderNum;

    /**
     * 总订单数
     */
    private Integer allOrderNum;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getNoPayOrderNum() {
        return noPayOrderNum;
    }

    public void setNoPayOrderNum(Integer noPayOrderNum) {
        this.noPayOrderNum = noPayOrderNum;
    }

    public Integer getPendingDeliveryOrderNum() {
        return pendingDeliveryOrderNum;
    }

    public void setPendingDeliveryOrderNum(Integer pendingDeliveryOrderNum) {
        this.pendingDeliveryOrderNum = pendingDeliveryOrderNum;
    }

    public Integer getPendingReceivedOrderNum() {
        return pendingReceivedOrderNum;
    }

    public void setPendingReceivedOrderNum(Integer pendingReceivedOrderNum) {
        this.pendingReceivedOrderNum = pendingReceivedOrderNum;
    }

    public Integer getAllOrderNum() {
        return allOrderNum;
    }

    public void setAllOrderNum(Integer allOrderNum) {
        this.allOrderNum = allOrderNum;
    }
}
