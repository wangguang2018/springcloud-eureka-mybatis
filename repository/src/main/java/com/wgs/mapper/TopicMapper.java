package com.wgs.mapper;
import com.wgs.entity.Topic;



import java.util.List;

/**
 * Mapper - 主题
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public interface TopicMapper {

    /**
     * 新建主题
     *
     * @param topic 主题
     */
    void insert(Topic topic);

    /**
     * 更新主题
     *
     * @param topic 主题
     */
    void update(Topic topic);

    /**
     * 删除主题
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除主题
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询主题
     *
     * @param id 编号
     * @return 主题
     */
    Topic findById(Integer id);

    /**
     * 查询主题
     *
     * @return 主题集合
     */
    List<Topic> findAll();

}