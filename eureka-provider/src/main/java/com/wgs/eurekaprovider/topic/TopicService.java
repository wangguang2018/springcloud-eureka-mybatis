package com.wgs.eurekaprovider.topic;

import com.github.pagehelper.PageHelper;
import com.wgs.dto.topic.TopicDTO;
import com.wgs.mapper.TopicMapper;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 主题
 */
@Service
public class TopicService extends BaseServiceImpl {


    @Resource
    private TopicMapper topicMapper;

    /**
     * 主题列表
     * @param pagination
     * @return
     */
    public Pagination findTopicList(Pagination pagination){
        PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
        pagination.setQueryResult(topicMapper.findList());
        return pagination;
    }

    /**
     * 获取主题信息
     * @param topicId
     * @return
     */
    public TopicDTO findTopicInfoById(Integer topicId){
        return topicMapper.findInfoById(topicId);
    }

    /**
     * 获取主题下的所有商品
     * @param pagination
     * @param topicId
     * @return
     */
    public Pagination findTopicGoodsList(Pagination pagination, Integer topicId){
        PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
        pagination.setQueryResult(topicMapper.findTopicGoods(topicId,null));
        return pagination;
    }
}
