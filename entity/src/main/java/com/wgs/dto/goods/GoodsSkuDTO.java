package com.wgs.dto.goods;

import java.io.Serializable;
import java.util.List;

public class GoodsSkuDTO  implements Serializable{
    private Integer skuId;
    private List<GoodsSkuInfoDTO> goodsSkuInfoList;

    public List<GoodsSkuInfoDTO> getGoodsSkuInfoList() {
        return goodsSkuInfoList;
    }

    public void setGoodsSkuInfoList(List<GoodsSkuInfoDTO> goodsSkuInfoList) {
        this.goodsSkuInfoList = goodsSkuInfoList;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }
}
