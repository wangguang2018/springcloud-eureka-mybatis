package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 商品的sku属性列表
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class GoodsSkuInfo implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * sku属性ID
     */
    private Integer skuId;

    /**
     * sku属性值名称
     */
    private String name;

    /**
     * sku属性值图片
     */
    private String img;

    /**
     * sku属性值大图
     */
    private String bigImg;

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
     * 设置sku属性ID
     *
     * @param skuId sku属性ID
     */
    public void setSkuId(Integer skuId){
        this.skuId = skuId;
    }

    /**
     * 获取sku属性ID
     *
     * @return sku属性ID
     */
    public Integer getSkuId(){
        return skuId;
    }


    /**
     * 设置sku属性值名称
     *
     * @param name sku属性值名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取sku属性值名称
     *
     * @return sku属性值名称
     */
    public String getName(){
        return name;
    }


    /**
     * 设置sku属性值图片
     *
     * @param img sku属性值图片
     */
    public void setImg(String img){
        this.img = img;
    }

    /**
     * 获取sku属性值图片
     *
     * @return sku属性值图片
     */
    public String getImg(){
        return img;
    }


    /**
     * 设置sku属性值大图
     *
     * @param bigImg sku属性值大图
     */
    public void setBigImg(String bigImg){
        this.bigImg = bigImg;
    }

    /**
     * 获取sku属性值大图
     *
     * @return sku属性值大图
     */
    public String getBigImg(){
        return bigImg;
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