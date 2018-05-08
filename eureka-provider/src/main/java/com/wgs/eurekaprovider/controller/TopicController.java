package com.wgs.eurekaprovider.controller;

import com.wgs.dto.topic.TopicDTO;
import com.wgs.eurekaprovider.service.TopicService;
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
    public Pagination findTopicList(Pagination pagination){
        return topicService.findTopicList(pagination);
    }

    @RequestMapping("/findTopicInfoById")
    public TopicDTO findTopicInfoById(@RequestParam("topicId")Integer topicId){
        return topicService.findTopicInfoById(topicId);
    }

    @RequestMapping("/findTopicGoods")
    public Pagination findTopicGoodsList(Pagination pagination,@RequestParam("topicId") Integer topicId){
        return topicService.findTopicGoodsList(pagination,topicId);
    }
}
