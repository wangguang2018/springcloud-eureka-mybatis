package com.wgs.mapper;
import com.wgs.entity.Banner;



import java.util.List;

/**
 * Mapper - banner
 *
 * @author zhaoziyu
 * @since 2018-05-14
 */
public interface BannerMapper {

    /**
     * 新建banner
     *
     * @param banner banner
     */
    void insert(Banner banner);

    /**
     * 更新banner
     *
     * @param banner banner
     */
    void update(Banner banner);

    /**
     * 删除banner
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除banner
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询banner
     *
     * @param id 编号
     * @return banner
     */
    Banner findById(Integer id);

    /**
     * 查询banner
     *
     * @return banner集合
     */
    List<Banner> findAll();

    String findLaunchImg();
}