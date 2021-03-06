package com.wgs.dto.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class GoodsDTO implements Serializable {
    private Integer id;
    private String name;
    private String goodsSn;
    private String desc;
    private String cover;
    private String topicImg;
    private BigDecimal price;
    private Integer status;
    private Integer deleted;
    private List<GoodsSkuDTO> skuList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<GoodsSkuDTO> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<GoodsSkuDTO> skuList) {
        this.skuList = skuList;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
