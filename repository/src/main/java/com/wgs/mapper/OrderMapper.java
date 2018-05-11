package com.wgs.mapper;
import com.wgs.dto.order.OrderDTO;
import com.wgs.entity.Order;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 订单
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface OrderMapper {

    /**
     * 新建订单
     *
     * @param order 订单
     */
    void insert(Order order);

    /**
     * 更新订单
     *
     * @param order 订单
     */
    void update(Order order);

    /**
     * 删除订单
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除订单
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询订单
     *
     * @param id 编号
     * @return 订单
     */
    Order findById(Integer id);

    /**
     * 查询订单
     *
     * @return 订单集合
     */
    List<Order> findAll();

    /**
     * 更新状态
     *
     * @param ids 编号
     * @param status 状态
     * @return 更新数量
     */
    int updateStatus(@Param("ids") Integer[] ids, @Param("status") Byte status);

    List<OrderDTO> findOrderList(@Param("memberId") Integer memberId);

}