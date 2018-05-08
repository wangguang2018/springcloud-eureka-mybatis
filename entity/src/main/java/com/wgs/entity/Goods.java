package com.wgs.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity - 商品主体
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class Goods implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String goodsName;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 商品描述
     */
    private String desc;

    /**
     * 商品编号
     */
    private String goodsSn;

    /**
     * 封面
     */
    private String cover;

    /**
     * 价格(用于显示)
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
     * @param goodsName 
     */
    public void setGoodsName(String goodsName){
        this.goodsName = goodsName;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getGoodsName(){
        return goodsName;
    }


    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(Integer categoryId){
        this.categoryId = categoryId;
    }

    /**
     * 获取分类ID
     *
     * @return 分类ID
     */
    public Integer getCategoryId(){
        return categoryId;
    }


    /**
     * 设置商品描述
     *
     * @param desc 商品描述
     */
    public void setDesc(String desc){
        this.desc = desc;
    }

    /**
     * 获取商品描述
     *
     * @return 商品描述
     */
    public String getDesc(){
        return desc;
    }


    /**
     * 设置商品编号
     *
     * @param goodsSn 商品编号
     */
    public void setGoodsSn(String goodsSn){
        this.goodsSn = goodsSn;
    }

    /**
     * 获取商品编号
     *
     * @return 商品编号
     */
    public String getGoodsSn(){
        return goodsSn;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}