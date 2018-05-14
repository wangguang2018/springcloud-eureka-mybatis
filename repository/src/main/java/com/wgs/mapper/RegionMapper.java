package com.wgs.mapper;
import com.wgs.dto.RegionDTO;
import com.wgs.entity.Region;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 省市区
 *
 * @author zhaoziyu
 * @since 2018-05-14
 */
public interface RegionMapper {

    /**
     * 新建省市区
     *
     * @param region 省市区
     */
    void insert(Region region);

    /**
     * 更新省市区
     *
     * @param region 省市区
     */
    void update(Region region);

    /**
     * 删除省市区
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除省市区
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询省市区
     *
     * @param id 编号
     * @return 省市区
     */
    Region findById(Integer id);

    /**
     * 查询省市区
     *
     * @return 省市区集合
     */
    List<Region> findAll();

    List<RegionDTO> findByLevel(@Param("level") Integer level, @Param("parentId") Integer parentId);
}