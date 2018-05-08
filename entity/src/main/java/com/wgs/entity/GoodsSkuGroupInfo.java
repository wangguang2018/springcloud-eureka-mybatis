package com.wgs.entity;

import java.io.Serializable;

/**
 * Entity - sku属性组合额外属性
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class GoodsSkuGroupInfo implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 镜框材质
     */
    private String spectaclesFrameMaterial;

    /**
     * 镜片颜色
     */
    private String lensColor;

    /**
     * sku属性组合ID
     */
    private Integer skuGroupId;



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

}