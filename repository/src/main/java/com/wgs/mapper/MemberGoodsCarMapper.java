package com.wgs.mapper;
import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.entity.MemberGoodsCar;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 购物车
 *
 * @author zhaoziyu
 * @since 2018-05-09
 */
public interface MemberGoodsCarMapper {

    /**
     * 新建购物车
     *
     * @param memberGoodsCar 购物车
     */
    void insert(MemberGoodsCar memberGoodsCar);

    /**
     * 更新购物车
     *
     * @param memberGoodsCar 购物车
     */
    void update(MemberGoodsCar memberGoodsCar);

    /**
     * 删除购物车
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除购物车
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询购物车
     *
     * @param id 编号
     * @return 购物车
     */
    MemberGoodsCar findById(Integer id);

    /**
     * 查询购物车
     *
     * @return 购物车集合
     */
    List<MemberGoodsCar> findAll();

    Integer numberBySkuGroupId(@Param("skuGroupId") Integer skuGroupId, @Param("memberId") Integer memberId);

    void updateNumBySkuGroupId(@Param("skuGroupId") Integer skuGroupId, @Param("memberId") Integer memberId,@Param("num") Integer num);

    void deleteBySkuGroupId(@Param("skuGroupId") Integer skuGroupId, @Param("memberId") Integer memberId);

    List<GoodsCarDTO> findByMember(@Param("memberId") Integer memberId);

    Integer countByMember(@Param("memberId") Integer memberId);

    void deleteByMember(@Param("memberId") Integer memberId);
}