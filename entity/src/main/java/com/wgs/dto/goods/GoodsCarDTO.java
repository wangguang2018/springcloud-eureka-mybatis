package com.wgs.dto.goods;

/**
 * 购物车
 */
public class GoodsCarDTO extends GoodsDTO{

    //商品sku信息
    private String skuInfo;

    private Integer num;

    /**
     * skuID串
     */
    private String goodsSkuInfoIds;

    public String getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(String skuInfo) {
        this.skuInfo = skuInfo;
    }

    public String getGoodsSkuInfoIds() {
        return goodsSkuInfoIds;
    }

    public void setGoodsSkuInfoIds(String goodsSkuInfoIds) {
        this.goodsSkuInfoIds = goodsSkuInfoIds;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
