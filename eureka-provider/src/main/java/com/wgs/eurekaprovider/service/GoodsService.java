package com.wgs.eurekaprovider.service;

import com.wgs.dto.goods.GoodsDTO;
import com.wgs.dto.goods.GoodsSkuDTO;
import com.wgs.mapper.GoodsMapper;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService extends BaseServiceImpl{

    @Resource
    private GoodsMapper goodsMapper;

    public GoodsDTO findGoodsInfo(Integer goodsId){
        return goodsMapper.findGoodsInfoById(goodsId);
    }

}
