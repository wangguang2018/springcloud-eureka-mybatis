package com.wgs.entity;

import java.io.Serializable;

/**
 * Entity - 订单商品信息
 *
 * @author zhaoziyu
 * @since 2018-05-09
 */
public class OrderGoodsInfo implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * sku属性名称
     */
    private String skuName;

    /**
     * 镜框材质
     */
    private String spectaclesFrameMaterial;

    /**
     * 镜片颜色
     */
    private String lensColor;

    /**
     * 
     */
    private String goodsName;

    /**
     * 
     */
    private String goodsSn;

    /**
     * 
     */
    private String goodsImg;

    /**
     * 订单商品ID
     */
    private Integer orderGoodsId;



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
     * 设置sku属性名称
     *
     * @param skuName sku属性名称
     */
    public void setSkuName(String skuName){
        this.skuName = skuName;
    }

    /**
     * 获取sku属性名称
     *
     * @return sku属性名称
     */
    public String getSkuName(){
        return skuName;
    }


    /**
     * 设置镜框材质
     *
     * @param spectaclesFrameMaterial 镜框材质
     */
    public void setSpectaclesFrameMaterial(String spectaclesFrameMaterial){
        this.spectaclesFrameMaterial = spectaclesFrameMaterial;
    }

    /**
     * 获取镜框材质
     *
     * @return 镜框材质
     */
    public String getSpectaclesFrameMaterial(){
        return spectaclesFrameMaterial;
    }


    /**
     * 设置镜片颜色
     *
     * @param lensColor 镜片颜色
     */
    public void setLensColor(String lensColor){
        this.lensColor = lensColor;
    }

    /**
     * 获取镜片颜色
     *
     * @return 镜片颜色
     */
    public String getLensColor(){
        return lensColor;
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
     * 设置
     *
     * @param goodsSn 
     */
    public void setGoodsSn(String goodsSn){
        this.goodsSn = goodsSn;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getGoodsSn(){
        return goodsSn;
    }


    /**
     * 设置
     *
     * @param goodsImg 
     */
    public void setGoodsImg(String goodsImg){
        this.goodsImg = goodsImg;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getGoodsImg(){
        return goodsImg;
    }


    /**
     * 设置订单商品ID
     *
     * @param orderGoodsId 订单商品ID
     */
    public void setOrderGoodsId(Integer orderGoodsId){
        this.orderGoodsId = orderGoodsId;
    }

    /**
     * 获取订单商品ID
     *
     * @return 订单商品ID
     */
    public Integer getOrderGoodsId(){
        return orderGoodsId;
    }

}