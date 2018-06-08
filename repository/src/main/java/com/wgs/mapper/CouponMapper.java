package com.wgs.mapper;
import com.wgs.entity.Coupon;



import java.util.List;

/**
 * Mapper - 优惠券
 *
 * @author zhaoziyu
 * @since 2018-06-08
 */
public interface CouponMapper {

    /**
     * 新建优惠券
     *
     * @param coupon 优惠券
     */
    void insert(Coupon coupon);

    /**
     * 更新优惠券
     *
     * @param coupon 优惠券
     */
    void update(Coupon coupon);

    /**
     * 删除优惠券
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除优惠券
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询优惠券
     *
     * @param id 编号
     * @return 优惠券
     */
    Coupon findById(Integer id);

    /**
     * 查询优惠券
     *
     * @return 优惠券集合
     */
    List<Coupon> findAll();

}