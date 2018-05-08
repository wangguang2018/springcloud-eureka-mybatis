package com.wgs.dto.video;

import com.wgs.dto.goods.GoodsDTO;
import com.wgs.entity.Video;

import java.io.Serializable;
import java.util.List;

public class VideoDTO extends Video implements Serializable {

    private List<GoodsDTO> goodsList;

    public List<GoodsDTO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsDTO> goodsList) {
        this.goodsList = goodsList;
    }
}
