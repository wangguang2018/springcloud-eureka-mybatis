package com.wgs.eurekaprovider.controller;

import com.wgs.eurekaprovider.video.VideoService;
import com.ydd.framework.core.common.Pagination;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class VideoController {

    @Resource
    private VideoService videoService;

    @RequestMapping("/findVideoList")
    public Pagination findVideoList(Pagination pagination){
        return videoService.findVideoList(pagination);
    }

}
