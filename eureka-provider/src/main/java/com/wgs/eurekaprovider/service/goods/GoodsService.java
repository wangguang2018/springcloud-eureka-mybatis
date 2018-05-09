package com.wgs.eurekaprovider.service.goods;

import com.github.pagehelper.PageHelper;
import com.wgs.dto.goods.GoodsDTO;
import com.wgs.dto.goods.GoodsSkuGroupDTO;
import com.wgs.entity.Goods;
import com.wgs.entity.GoodsSkuGroup;
import com.wgs.entity.GoodsSkuGroupInfo;
import com.wgs.entity.GoodsSkuInfo;
import com.wgs.mapper.*;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService extends BaseServiceImpl{

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsSkuGroupMapper goodsSkuGroupMapper;

    @Resource
    private GoodsSkuInfoMapper goodsSkuInfoMapper;

    @Resource
    private GoodsSkuGroupInfoMapper goodsSkuGroupInfoMapper;


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

    /**
     * 根据分类查找商品
     * @param categoryId
     * @return
     */
    public Pagination findGoodsByCategory(Integer categoryId,Pagination pagination){
        PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
        pagination.setQueryResult(goodsMapper.findGoodsByCategory(categoryId));
        return pagination;
    }

    /**
     * 通过ID获取商品
     * @param goodsId
     * @return
     */
    public Goods findById(Integer goodsId){
        return goodsMapper.findById(goodsId);
    }

    /**
     * 获取商品sku组合信息
     * @param skuGroupId
     * @return
     */
    public GoodsSkuGroup findSkuGroupById(Integer skuGroupId){
        return goodsSkuGroupMapper.findById(skuGroupId);
    }

    /**
     * 获取sku文本信息
     * @param skuIdsStr
     * @return
     */
    public String getSkuInfoNameBySkuIds(String skuIdsStr){
        String[] skuIds = skuIdsStr.split(";");
        List<GoodsSkuInfo> skuInfos = goodsSkuInfoMapper.findByIds(skuIds);
        StringBuilder skuInfo = new StringBuilder();
        for(GoodsSkuInfo i : skuInfos){
            skuInfo.append(i.getName()+" ");
        }
        return skuInfo.toString().trim();
    }

    /**
     * 获取sku组合的商品的信息（镜框材质等）
     * @param skuGroupId
     * @return
     */
    public GoodsSkuGroupInfo findSkuGroupInfoByGroupId(Integer skuGroupId){
        return goodsSkuGroupInfoMapper.findBySkuGroupId(skuGroupId);
    }

}
