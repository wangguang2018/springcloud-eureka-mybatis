package com.wgs.entity;

import java.io.Serializable;
import java.math.*;

/**
 * Entity - 订单商品
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class OrderGoods implements Serializable {


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
     * 购买数量
     */
    private Integer num;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * sku商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * SKU商品总价
     */
    private BigDecimal totalPrice;



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
     * 设置购买数量
     *
     * @param num 购买数量
     */
    public void setNum(Integer num){
        this.num = num;
    }

    /**
     * 获取购买数量
     *
     * @return 购买数量
     */
    public Integer getNum(){
        return num;
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
     * 设置sku商品单价
     *
     * @param goodsPrice sku商品单价
     */
    public void setGoodsPrice(BigDecimal goodsPrice){
        this.goodsPrice = goodsPrice;
    }

    /**
     * 获取sku商品单价
     *
     * @return sku商品单价
     */
    public BigDecimal getGoodsPrice(){
        return goodsPrice;
    }


    /**
     * 设置SKU商品总价
     *
     * @param totalPrice SKU商品总价
     */
    public void setTotalPrice(BigDecimal totalPrice){
        this.totalPrice = totalPrice;
    }

    /**
     * 获取SKU商品总价
     *
     * @return SKU商品总价
     */
    public BigDecimal getTotalPrice(){
        return totalPrice;
    }

}