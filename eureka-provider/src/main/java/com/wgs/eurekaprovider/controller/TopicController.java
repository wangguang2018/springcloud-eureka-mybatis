package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.dto.topic.TopicDTO;
import com.wgs.eurekaprovider.service.topic.TopicService;
import com.ydd.framework.core.common.Pagination;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TopicController {

    @Resource
    private TopicService topicService;

    @RequestMapping("/findTopicList")
    public BaseResult<Pagination> findTopicList(Pagination pagination){
        return new BaseResult(topicService.findTopicList(pagination));
    }

    @RequestMapping("/findTopicInfoById")
    public BaseResult<TopicDTO> findTopicInfoById(@RequestParam("topicId")Integer topicId){
        return new BaseResult(topicService.findTopicInfoById(topicId));
    }

    @RequestMapping("/findTopicGoods")
    public BaseResult<Pagination> findTopicGoodsList(Pagination pagination,@RequestParam("topicId") Integer topicId){
        return new BaseResult(topicService.findTopicGoodsList(pagination,topicId));
    }
}
