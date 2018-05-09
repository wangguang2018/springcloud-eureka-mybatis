package com.wgs.mapper;
import com.wgs.dto.order.OrderGoodsInfoDTO;
import com.wgs.entity.OrderGoodsInfo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 订单商品信息
 *
 * @author zhaoziyu
 * @since 2018-05-09
 */
public interface OrderGoodsInfoMapper {

    /**
     * 新建订单商品信息
     *
     * @param orderGoodsInfo 订单商品信息
     */
    void insert(OrderGoodsInfo orderGoodsInfo);

    /**
     * 更新订单商品信息
     *
     * @param orderGoodsInfo 订单商品信息
     */
    void update(OrderGoodsInfo orderGoodsInfo);

    /**
     * 删除订单商品信息
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除订单商品信息
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询订单商品信息
     *
     * @param id 编号
     * @return 订单商品信息
     */
    OrderGoodsInfo findById(Integer id);

    /**
     * 查询订单商品信息
     *
     * @return 订单商品信息集合
     */
    List<OrderGoodsInfo> findAll();

    void save(List<OrderGoodsInfoDTO> orderGoodsInfoList);

}