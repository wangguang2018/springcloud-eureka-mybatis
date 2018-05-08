package com.wgs.mapper;
import com.wgs.entity.MemberToken;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 用户token
 *
 * @author zhaoziyu
 * @since 2018-05-08
 */
public interface MemberTokenMapper {

    /**
     * 新建用户token
     *
     * @param memberToken 用户token
     */
    void insert(MemberToken memberToken);

    /**
     * 更新用户token
     *
     * @param memberToken 用户token
     */
    void update(MemberToken memberToken);

    /**
     * 删除用户token
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除用户token
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询用户token
     *
     * @param id 编号
     * @return 用户token
     */
    MemberToken findById(Integer id);

    /**
     * 查询用户token
     *
     * @return 用户token集合
     */
    List<MemberToken> findAll();

    MemberToken findByMemberId(@Param("memberId") Integer memberId);

}