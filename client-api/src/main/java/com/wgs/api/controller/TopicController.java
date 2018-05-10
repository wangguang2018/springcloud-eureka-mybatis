package com.wgs.api.controller;

import com.wgs.api.service.TopicService;
import com.wgs.dto.topic.TopicDTO;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Resource
    private TopicService topicService;

    /**
     * 主题列表
     * @return
     */
    @RequestMapping("/list")
    public ResponseDTO topicList(Pagination pagination){
        pagination = topicService.findTopicList(pagination);
        return ResponseDTO.ok().addAttribute("data",pagination);
    }

    /**
     * 主题详细
     * @param topicId
     * @return
     */
    @RequestMapping("/info")
    public ResponseDTO topicList(@RequestParam("topicId") Integer topicId){
        TopicDTO topicDTO = topicService.findTopicInfoById(topicId);
        return ResponseDTO.ok().addAttribute("data",topicDTO);
    }

    /**
     * 主题下的商品列表
     * @param topicId
     * @param pagination
     * @return
     */
    @RequestMapping("/info/goods")
    public ResponseDTO topicList(@RequestParam("topicId") Integer topicId,Pagination pagination){
        pagination = topicService.findTopicGoodsList(pagination,topicId);
        return ResponseDTO.ok().addAttribute("data",pagination);
    }

}
