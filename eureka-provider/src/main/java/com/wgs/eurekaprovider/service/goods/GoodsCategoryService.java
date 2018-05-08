package com.wgs.eurekaprovider.service.goods;

import com.wgs.entity.GoodsCategory;
import com.wgs.mapper.GoodsCategoryMapper;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类
 */
@Service
public class GoodsCategoryService extends BaseServiceImpl{

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    /**
     * 获取所有商品分类
     * @return
     */
    public List<GoodsCategory> findGoodsCategory(){
        return goodsCategoryMapper.findAll();
    }

}
