package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

/**
 * Entity - 用户优惠券
 *
 * @author zhaoziyu
 * @since 2018-06-08
 */
public class MemberCoupon implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer memberId;

    /**
     * 优惠券名称
     */
    private String name;

    /**
     * 优惠券类型
     */
    private Integer type;

    /**
     * 商品分类
     */
    private Integer categoryId;

    /**
     * 使用范围
     */
    private Integer scope;

    /**
     * 过期类型
     */
    private Integer expireType;

    /**
     * 开始日期
     */
    private Date startTime;

    /**
     * 结束日期
     */
    private Date emdTime;

    /**
     * 使用优惠券的最低限制金额
     */
    private BigDecimal leastPrice;

    /**
     * 优惠券折扣金额
     */
    private BigDecimal discountPrice;

    /**
     * 状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     */
    private Integer status;

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
     * 设置优惠券名称
     *
     * @param name 优惠券名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取优惠券名称
     *
     * @return 优惠券名称
     */
    public String getName(){
        return name;
    }


    /**
     * 设置优惠券类型
     *
     * @param type 优惠券类型
     */
    public void setType(Integer type){
        this.type = type;
    }

    /**
     * 获取优惠券类型
     *
     * @return 优惠券类型
     */
    public Integer getType(){
        return type;
    }


    /**
     * 设置商品分类
     *
     * @param categoryId 商品分类
     */
    public void setCategoryId(Integer categoryId){
        this.categoryId = categoryId;
    }

    /**
     * 获取商品分类
     *
     * @return 商品分类
     */
    public Integer getCategoryId(){
        return categoryId;
    }


    /**
     * 设置使用范围
     *
     * @param scope 使用范围
     */
    public void setScope(Integer scope){
        this.scope = scope;
    }

    /**
     * 获取使用范围
     *
     * @return 使用范围
     */
    public Integer getScope(){
        return scope;
    }


    /**
     * 设置过期类型
     *
     * @param expireType 过期类型
     */
    public void setExpireType(Integer expireType){
        this.expireType = expireType;
    }

    /**
     * 获取过期类型
     *
     * @return 过期类型
     */
    public Integer getExpireType(){
        return expireType;
    }


    /**
     * 设置开始日期
     *
     * @param startTime 开始日期
     */
    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }

    /**
     * 获取开始日期
     *
     * @return 开始日期
     */
    public Date getStartTime(){
        return startTime;
    }


    /**
     * 设置结束日期
     *
     * @param emdTime 结束日期
     */
    public void setEmdTime(Date emdTime){
        this.emdTime = emdTime;
    }

    /**
     * 获取结束日期
     *
     * @return 结束日期
     */
    public Date getEmdTime(){
        return emdTime;
    }


    /**
     * 设置使用优惠券的最低限制金额
     *
     * @param leastPrice 使用优惠券的最低限制金额
     */
    public void setLeastPrice(BigDecimal leastPrice){
        this.leastPrice = leastPrice;
    }

    /**
     * 获取使用优惠券的最低限制金额
     *
     * @return 使用优惠券的最低限制金额
     */
    public BigDecimal getLeastPrice(){
        return leastPrice;
    }


    /**
     * 设置优惠券折扣金额
     *
     * @param discountPrice 优惠券折扣金额
     */
    public void setDiscountPrice(BigDecimal discountPrice){
        this.discountPrice = discountPrice;
    }

    /**
     * 获取优惠券折扣金额
     *
     * @return 优惠券折扣金额
     */
    public BigDecimal getDiscountPrice(){
        return discountPrice;
    }


    /**
     * 设置状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     * @param status 状态
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * 获取状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     * @return 状态
     */
    public Integer getStatus(){
        return status;
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