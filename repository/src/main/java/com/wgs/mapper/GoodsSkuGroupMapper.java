package com.wgs.mapper;
import com.wgs.entity.GoodsSkuGroup;



import java.util.List;

/**
 * Mapper - sku属性组合信息
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface GoodsSkuGroupMapper {

    /**
     * 新建sku属性组合信息
     *
     * @param goodsSkuGroup sku属性组合信息
     */
    void insert(GoodsSkuGroup goodsSkuGroup);

    /**
     * 更新sku属性组合信息
     *
     * @param goodsSkuGroup sku属性组合信息
     */
    void update(GoodsSkuGroup goodsSkuGroup);

    /**
     * 删除sku属性组合信息
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除sku属性组合信息
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询sku属性组合信息
     *
     * @param id 编号
     * @return sku属性组合信息
     */
    GoodsSkuGroup findById(Integer id);

    /**
     * 查询sku属性组合信息
     *
     * @return sku属性组合信息集合
     */
    List<GoodsSkuGroup> findAll();

}