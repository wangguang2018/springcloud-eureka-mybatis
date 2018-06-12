package com.wgs.mapper;
import com.wgs.entity.MemberCoupon;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 用户优惠券
 *
 * @author zhaoziyu
 * @since 2018-06-08
 */
public interface MemberCouponMapper {

    /**
     * 新建用户优惠券
     *
     * @param memberCoupon 用户优惠券
     */
    void insert(MemberCoupon memberCoupon);

    /**
     * 更新用户优惠券
     *
     * @param memberCoupon 用户优惠券
     */
    void update(MemberCoupon memberCoupon);

    /**
     * 删除用户优惠券
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除用户优惠券
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询用户优惠券
     *
     * @param id 编号
     * @return 用户优惠券
     */
    MemberCoupon findById(Integer id);

    /**
     * 查询用户优惠券
     *
     * @return 用户优惠券集合
     */
    List<MemberCoupon> findAll();

    /**
     * 更新状态
     *
     * @param ids 编号
     * @param status 状态
     * @return 更新数量
     */
    int updateStatus(@Param("ids") Integer[] ids, @Param("status") Byte status);

}