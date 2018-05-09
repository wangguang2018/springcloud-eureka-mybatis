package com.wgs.mapper;
import com.wgs.entity.Order;
import com.wgs.entity.OrderGoods;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 订单商品
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface OrderGoodsMapper {

    /**
     * 新建订单商品
     *
     * @param orderGoods 订单商品
     */
    void insert(OrderGoods orderGoods);

    /**
     * 更新订单商品
     *
     * @param orderGoods 订单商品
     */
    void update(OrderGoods orderGoods);

    /**
     * 删除订单商品
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除订单商品
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询订单商品
     *
     * @param id 编号
     * @return 订单商品
     */
    OrderGoods findById(Integer id);

    /**
     * 查询订单商品
     *
     * @return 订单商品集合
     */
    List<OrderGoods> findAll();

    void save(@Param("list") List<OrderGoods> orderGoodsList, @Param("order") Order order);

}