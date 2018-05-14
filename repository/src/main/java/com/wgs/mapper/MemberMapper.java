package com.wgs.mapper;
import com.wgs.dto.member.MemberInfoDTO;
import com.wgs.entity.Member;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 用户
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface MemberMapper {

    /**
     * 新建用户
     *
     * @param member 用户
     */
    void insert(Member member);

    /**
     * 更新用户
     *
     * @param member 用户
     */
    void update(Member member);

    /**
     * 删除用户
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除用户
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询用户
     *
     * @param id 编号
     * @return 用户
     */
    Member findById(Integer id);

    /**
     * 查询用户
     *
     * @return 用户集合
     */
    List<Member> findAll();

    Member findByOpenId(@Param("openId") String openId);

    MemberInfoDTO findMemberInfo(@Param("memberId") Integer memberId);
}