package com.wgs.mapper;
import com.wgs.entity.Video;



import java.util.List;

/**
 * Mapper - 视频
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface VideoMapper {

    /**
     * 新建视频
     *
     * @param video 视频
     */
    void insert(Video video);

    /**
     * 更新视频
     *
     * @param video 视频
     */
    void update(Video video);

    /**
     * 删除视频
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除视频
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询视频
     *
     * @param id 编号
     * @return 视频
     */
    Video findById(Integer id);

    /**
     * 查询视频
     *
     * @return 视频集合
     */
    List<Video> findAll();

}