package com.wgs.dto.goods;

import java.io.Serializable;
import java.util.List;

public class GoodsDTO implements Serializable {
    private Integer id;
    private String name;
    private String desc;
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
}
