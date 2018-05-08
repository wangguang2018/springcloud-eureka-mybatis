package com.wgs.mapper;
import com.wgs.entity.GoodsSkuGroupInfo;



import java.util.List;

/**
 * Mapper - sku属性组合额外属性
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface GoodsSkuGroupInfoMapper {

    /**
     * 新建sku属性组合额外属性
     *
     * @param goodsSkuGroupInfo sku属性组合额外属性
     */
    void insert(GoodsSkuGroupInfo goodsSkuGroupInfo);

    /**
     * 更新sku属性组合额外属性
     *
     * @param goodsSkuGroupInfo sku属性组合额外属性
     */
    void update(GoodsSkuGroupInfo goodsSkuGroupInfo);

    /**
     * 删除sku属性组合额外属性
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除sku属性组合额外属性
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询sku属性组合额外属性
     *
     * @param id 编号
     * @return sku属性组合额外属性
     */
    GoodsSkuGroupInfo findById(Integer id);

    /**
     * 查询sku属性组合额外属性
     *
     * @return sku属性组合额外属性集合
     */
    List<GoodsSkuGroupInfo> findAll();

}