package com.wgs.mapper;
import com.wgs.entity.GoodsSkuInfo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 商品的sku属性列表
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface GoodsSkuInfoMapper {

    /**
     * 新建商品的sku属性列表
     *
     * @param goodsSkuInfo 商品的sku属性列表
     */
    void insert(GoodsSkuInfo goodsSkuInfo);

    /**
     * 更新商品的sku属性列表
     *
     * @param goodsSkuInfo 商品的sku属性列表
     */
    void update(GoodsSkuInfo goodsSkuInfo);

    /**
     * 删除商品的sku属性列表
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除商品的sku属性列表
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询商品的sku属性列表
     *
     * @param id 编号
     * @return 商品的sku属性列表
     */
    GoodsSkuInfo findById(Integer id);

    /**
     * 查询商品的sku属性列表
     *
     * @return 商品的sku属性列表集合
     */
    List<GoodsSkuInfo> findAll();

    List<GoodsSkuInfo> findByIds(@Param("ids") String[] ids);

}