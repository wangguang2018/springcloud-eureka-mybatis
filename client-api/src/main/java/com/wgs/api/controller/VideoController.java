package com.wgs.api.controller;

import com.wgs.api.service.VideoService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/video")
public class VideoController extends BaseApiController {

    @Resource
    private VideoService videoService;

    @RequestMapping("/list")
    public ResponseDTO videoList(Pagination pagination){
        Pagination p = videoService.findVideoList(pagination);
        return ResponseDTO.ok().addAttribute("data",p);
    }

}
