package com.wgs.dto.topic;

import com.wgs.dto.goods.GoodsDTO;
import com.wgs.entity.Topic;

import java.util.List;

public class TopicDTO extends Topic {
    private List<GoodsDTO> goodsList;

    public List<GoodsDTO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsDTO> goodsList) {
        this.goodsList = goodsList;
    }
}
