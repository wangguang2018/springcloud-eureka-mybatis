package com.wgs.entity;

import java.io.Serializable;

/**
 * Entity - 订单收货地址
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class OrderAddress implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 用户ID
     */
    private Integer memberId;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系方式
     */
    private String phone;



    /**
     * 设置
     *
     * @param id 
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getId(){
        return id;
    }


    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(Integer orderId){
        this.orderId = orderId;
    }

    /**
     * 获取订单ID
     *
     * @return 订单ID
     */
    public Integer getOrderId(){
        return orderId;
    }


    /**
     * 设置订单号
     *
     * @param orderSn 订单号
     */
    public void setOrderSn(String orderSn){
        this.orderSn = orderSn;
    }

    /**
     * 获取订单号
     *
     * @return 订单号
     */
    public String getOrderSn(){
        return orderSn;
    }


    /**
     * 设置用户ID
     *
     * @param memberId 用户ID
     */
    public void setMemberId(Integer memberId){
        this.memberId = memberId;
    }

    /**
     * 获取用户ID
     *
     * @return 用户ID
     */
    public Integer getMemberId(){
        return memberId;
    }


    /**
     * 设置收货地址
     *
     * @param address 收货地址
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * 获取收货地址
     *
     * @return 收货地址
     */
    public String getAddress(){
        return address;
    }


    /**
     * 设置联系人
     *
     * @param contact 联系人
     */
    public void setContact(String contact){
        this.contact = contact;
    }

    /**
     * 获取联系人
     *
     * @return 联系人
     */
    public String getContact(){
        return contact;
    }


    /**
     * 设置联系方式
     *
     * @param phone 联系方式
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * 获取联系方式
     *
     * @return 联系方式
     */
    public String getPhone(){
        return phone;
    }

}