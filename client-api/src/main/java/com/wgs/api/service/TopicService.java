package com.wgs.api.service;

import com.wgs.dto.BaseResult;
import com.wgs.dto.topic.TopicDTO;
import com.ydd.framework.core.common.Pagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-api")
public interface TopicService {

    /**
     * 获取主题列表
     * @param pagination
     * @return
     */
    @RequestMapping("/findTopicList")
    BaseResult<Pagination> findTopicList(Pagination pagination);

    /**
     * 获取主题详细
     * @param topicId
     * @return
     */
    @RequestMapping("/findTopicInfoById")
    BaseResult<TopicDTO> findTopicInfoById(@RequestParam("topicId")Integer topicId);

    /**
     * 获取主题下的商品
     * @param pagination
     * @param topicId
     * @return
     */
    @RequestMapping("/findTopicGoods")
    BaseResult<Pagination> findTopicGoodsList(Pagination pagination,@RequestParam("topicId") Integer topicId);

}
