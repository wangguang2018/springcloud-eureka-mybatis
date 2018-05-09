package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 购物车
 *
 * @author zhaoziyu
 * @since 2018-05-09
 */
public class MemberGoodsCar implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * sku属性组合ID
     */
    private Integer skuGroupId;

    /**
     * 
     */
    private Integer num;

    /**
     * 
     */
    private Integer memberId;

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
     * 设置商品ID
     *
     * @param goodsId 商品ID
     */
    public void setGoodsId(Integer goodsId){
        this.goodsId = goodsId;
    }

    /**
     * 获取商品ID
     *
     * @return 商品ID
     */
    public Integer getGoodsId(){
        return goodsId;
    }


    /**
     * 设置sku属性组合ID
     *
     * @param skuGroupId sku属性组合ID
     */
    public void setSkuGroupId(Integer skuGroupId){
        this.skuGroupId = skuGroupId;
    }

    /**
     * 获取sku属性组合ID
     *
     * @return sku属性组合ID
     */
    public Integer getSkuGroupId(){
        return skuGroupId;
    }


    /**
     * 设置
     *
     * @param num 
     */
    public void setNum(Integer num){
        this.num = num;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getNum(){
        return num;
    }


    /**
     * 设置
     *
     * @param memberId 
     */
    public void setMemberId(Integer memberId){
        this.memberId = memberId;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getMemberId(){
        return memberId;
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