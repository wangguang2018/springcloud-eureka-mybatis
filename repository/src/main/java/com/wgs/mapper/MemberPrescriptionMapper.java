package com.wgs.mapper;

import com.wgs.entity.MemberPrescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberPrescriptionMapper {
    /**
     * 新建memberPrescription
     *
     * @param memberPrescription memberPrescription
     */
    void insert(MemberPrescription memberPrescription);

    /**
     * 更新memberPrescription
     *
     * @param memberPrescription memberPrescription
     */
    void update(MemberPrescription memberPrescription);

    /**
     * 删除memberPrescription
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除memberPrescription
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询memberPrescription
     *
     * @param id 编号
     * @return banner
     */
    MemberPrescription findById(Integer id);

    /**
     * 查询memberPrescription
     *
     * @return banner集合
     */
    List<MemberPrescription> findAll(@Param("memberId") Integer memberId);

}
