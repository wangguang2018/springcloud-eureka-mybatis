package com.wgs.mapper;



import com.wgs.dto.goods.GoodsDTO;
import com.wgs.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper - 商品主体
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface GoodsMapper {

    /**
     * 新建商品主体
     *
     * @param goods 商品主体
     */
    void insert(Goods goods);

    /**
     * 更新商品主体
     *
     * @param goods 商品主体
     */
    void update(Goods goods);

    /**
     * 删除商品主体
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除商品主体
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询商品主体
     *
     * @param id 编号
     * @return 商品主体
     */
    Goods findById(Integer id);

    /**
     * 查询商品主体
     *
     * @return 商品主体集合
     */
    List<Goods> findAll();

    GoodsDTO findGoodsInfoById(@Param("goodsId") Integer goodsId);
}