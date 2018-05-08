package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

/**
 * Entity - 订单
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class Order implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 外部订单号
     */
    private String transactionSn;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 用户ID
     */
    private Integer memberId;

    /**
     * 订单状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     */
    private Integer status;

    /**
     * 订单总金额
     */
    private BigDecimal totalPrice;

    /**
     * 实际支付金额
     */
    private BigDecimal payPrice;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 创建者编号
     */
    private Integer createdId;

    /**
     * 更新者编号
     */
    private Integer modifiedId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date modifiedTime;

    /**
     * 删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     */
    private Integer deleted;



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
     * 设置外部订单号
     *
     * @param transactionSn 外部订单号
     */
    public void setTransactionSn(String transactionSn){
        this.transactionSn = transactionSn;
    }

    /**
     * 获取外部订单号
     *
     * @return 外部订单号
     */
    public String getTransactionSn(){
        return transactionSn;
    }


    /**
     * 设置支付方式
     *
     * @param payType 支付方式
     */
    public void setPayType(Integer payType){
        this.payType = payType;
    }

    /**
     * 获取支付方式
     *
     * @return 支付方式
     */
    public Integer getPayType(){
        return payType;
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
     * 设置订单状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     * @param status 订单状态
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * 获取订单状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     * @return 订单状态
     */
    public Integer getStatus(){
        return status;
    }


    /**
     * 设置订单总金额
     *
     * @param totalPrice 订单总金额
     */
    public void setTotalPrice(BigDecimal totalPrice){
        this.totalPrice = totalPrice;
    }

    /**
     * 获取订单总金额
     *
     * @return 订单总金额
     */
    public BigDecimal getTotalPrice(){
        return totalPrice;
    }


    /**
     * 设置实际支付金额
     *
     * @param payPrice 实际支付金额
     */
    public void setPayPrice(BigDecimal payPrice){
        this.payPrice = payPrice;
    }

    /**
     * 获取实际支付金额
     *
     * @return 实际支付金额
     */
    public BigDecimal getPayPrice(){
        return payPrice;
    }


    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime){
        this.payTime = payTime;
    }

    /**
     * 获取支付时间
     *
     * @return 支付时间
     */
    public Date getPayTime(){
        return payTime;
    }


    /**
     * 设置创建者编号
     *
     * @param createdId 创建者编号
     */
    public void setCreatedId(Integer createdId){
        this.createdId = createdId;
    }

    /**
     * 获取创建者编号
     *
     * @return 创建者编号
     */
    public Integer getCreatedId(){
        return createdId;
    }


    /**
     * 设置更新者编号
     *
     * @param modifiedId 更新者编号
     */
    public void setModifiedId(Integer modifiedId){
        this.modifiedId = modifiedId;
    }

    /**
     * 获取更新者编号
     *
     * @return 更新者编号
     */
    public Integer getModifiedId(){
        return modifiedId;
    }


    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }

    /**
     * 获取创建时间
     *
     * @return 创建时间
     */
    public Date getCreatedTime(){
        return createdTime;
    }


    /**
     * 设置更新时间
     *
     * @param modifiedTime 更新时间
     */
    public void setModifiedTime(Date modifiedTime){
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取更新时间
     *
     * @return 更新时间
     */
    public Date getModifiedTime(){
        return modifiedTime;
    }


    /**
     * 设置删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     * @param deleted 删除标识位
     */
    public void setDeleted(Integer deleted){
        this.deleted = deleted;
    }

    /**
     * 获取删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     * @return 删除标识位
     */
    public Integer getDeleted(){
        return deleted;
    }

}