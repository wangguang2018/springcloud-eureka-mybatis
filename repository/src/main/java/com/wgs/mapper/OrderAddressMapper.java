package com.wgs.mapper;
import com.wgs.entity.OrderAddress;



import java.util.List;

/**
 * Mapper - 订单收货地址
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface OrderAddressMapper {

    /**
     * 新建订单收货地址
     *
     * @param orderAddress 订单收货地址
     */
    void insert(OrderAddress orderAddress);

    /**
     * 更新订单收货地址
     *
     * @param orderAddress 订单收货地址
     */
    void update(OrderAddress orderAddress);

    /**
     * 删除订单收货地址
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除订单收货地址
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询订单收货地址
     *
     * @param id 编号
     * @return 订单收货地址
     */
    OrderAddress findById(Integer id);

    /**
     * 查询订单收货地址
     *
     * @return 订单收货地址集合
     */
    List<OrderAddress> findAll();

}