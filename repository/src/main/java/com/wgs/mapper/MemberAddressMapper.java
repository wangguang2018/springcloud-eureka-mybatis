package com.wgs.mapper;
import com.wgs.entity.MemberAddress;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 用户收货地址
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface MemberAddressMapper {

    /**
     * 新建用户收货地址
     *
     * @param memberAddress 用户收货地址
     */
    void insert(MemberAddress memberAddress);

    /**
     * 更新用户收货地址
     *
     * @param memberAddress 用户收货地址
     */
    void update(MemberAddress memberAddress);

    /**
     * 删除用户收货地址
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除用户收货地址
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询用户收货地址
     *
     * @param id 编号
     * @return 用户收货地址
     */
    MemberAddress findById(Integer id);

    /**
     * 查询用户收货地址
     *
     * @return 用户收货地址集合
     */
    List<MemberAddress> findAll();

    List<MemberAddress> findByMemberId(@Param("memberId") Integer memberId);

    void updateMemberAddressDefault(@Param("memberId") Integer memberId,@Param("addressId") Integer addressId,@Param("isDefault") Integer isDefault);

    void deleteByMemberId(@Param("memberId") Integer memberId,@Param("addressId") Integer addressId);

}