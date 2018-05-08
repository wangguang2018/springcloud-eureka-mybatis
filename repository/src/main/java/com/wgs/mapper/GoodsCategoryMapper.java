package com.wgs.mapper;
import com.wgs.entity.GoodsCategory;



import java.util.List;

/**
 * Mapper - 商品分类
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface GoodsCategoryMapper {

    /**
     * 新建商品分类
     *
     * @param goodsCategory 商品分类
     */
    void insert(GoodsCategory goodsCategory);

    /**
     * 更新商品分类
     *
     * @param goodsCategory 商品分类
     */
    void update(GoodsCategory goodsCategory);

    /**
     * 删除商品分类
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除商品分类
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询商品分类
     *
     * @param id 编号
     * @return 商品分类
     */
    GoodsCategory findById(Integer id);

    /**
     * 查询商品分类
     *
     * @return 商品分类集合
     */
    List<GoodsCategory> findAll();

}