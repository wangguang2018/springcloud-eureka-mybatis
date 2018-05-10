package com.wgs.api.controller;

import com.wgs.api.service.TopicService;
import com.wgs.dto.BaseResult;
import com.wgs.dto.topic.TopicDTO;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/topic")
public class TopicController extends BaseApiController {

    @Resource
    private TopicService topicService;

    /**
     * 主题列表
     * @return
     */
    @RequestMapping("/list")
    public ResponseDTO topicList(Pagination pagination){
        BaseResult<Pagination> p = topicService.findTopicList(pagination);
        return ResponseDTO.ok().addAttribute("data",p.getContent());
    }

    /**
     * 主题详细
     * @param topicId
     * @return
     */
    @RequestMapping("/info")
    public ResponseDTO topicList(@RequestParam("topicId") Integer topicId){
        BaseResult<TopicDTO> topicDTO = topicService.findTopicInfoById(topicId);
        return ResponseDTO.ok().addAttribute("data",topicDTO.getContent());
    }

    /**
     * 主题下的商品列表
     * @param topicId
     * @param pagination
     * @return
     */
    @RequestMapping("/info/goods")
    public ResponseDTO topicList(@RequestParam("topicId") Integer topicId,Pagination pagination){
        BaseResult<Pagination> p = topicService.findTopicGoodsList(pagination,topicId);
        return ResponseDTO.ok().addAttribute("data",p.getContent());
    }

}
