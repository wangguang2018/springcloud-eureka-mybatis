package com.wgs.dto.goods;

import com.wgs.entity.GoodsSkuGroup;

public class GoodsSkuGroupDTO extends GoodsSkuGroup{

    /**
     * 镜框材质
     */
    private String spectaclesFrameMaterial;

    /**
     * 镜片颜色
     */
    private String lensColor;

    public String getLensColor() {
        return lensColor;
    }

    public void setLensColor(String lensColor) {
        this.lensColor = lensColor;
    }

    public String getSpectaclesFrameMaterial() {
        return spectaclesFrameMaterial;
    }

    public void setSpectaclesFrameMaterial(String spectaclesFrameMaterial) {
        this.spectaclesFrameMaterial = spectaclesFrameMaterial;
    }
}
