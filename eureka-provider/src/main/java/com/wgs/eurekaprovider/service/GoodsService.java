package com.wgs.eurekaprovider.service;

import com.wgs.dto.goods.GoodsDTO;
import com.wgs.dto.goods.GoodsSkuGroupDTO;
import com.wgs.mapper.GoodsMapper;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService extends BaseServiceImpl{

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 获取商品主体信息
     * @param goodsId
     * @return
     */
    public GoodsDTO findGoodsInfo(Integer goodsId){
        return goodsMapper.findGoodsInfoById(goodsId);
    }

    /**
     * 获取商品sku属性的价格信息
     * @param goodsId
     * @return
     */
    public List<GoodsSkuGroupDTO> findGoodsGroupInfo(Integer goodsId){
        return goodsMapper.findGoodsSkuGroupByGoodsId(goodsId);
    }

}
