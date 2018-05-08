package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

/**
 * Entity - sku属性组合信息
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class GoodsSkuGroup implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer goodsId;

    /**
     * sku属性值ID串
     */
    private String goodsSkuInfoIds;

    /**
     * sku对应价格
     */
    private BigDecimal price;

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
     * 设置
     *
     * @param goodsId 
     */
    public void setGoodsId(Integer goodsId){
        this.goodsId = goodsId;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getGoodsId(){
        return goodsId;
    }


    /**
     * 设置sku属性值ID串
     *
     * @param goodsSkuInfoIds sku属性值ID串
     */
    public void setGoodsSkuInfoIds(String goodsSkuInfoIds){
        this.goodsSkuInfoIds = goodsSkuInfoIds;
    }

    /**
     * 获取sku属性值ID串
     *
     * @return sku属性值ID串
     */
    public String getGoodsSkuInfoIds(){
        return goodsSkuInfoIds;
    }


    /**
     * 设置sku对应价格
     *
     * @param price sku对应价格
     */
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    /**
     * 获取sku对应价格
     *
     * @return sku对应价格
     */
    public BigDecimal getPrice(){
        return price;
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