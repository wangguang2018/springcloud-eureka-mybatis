package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.eurekaprovider.service.video.VideoService;
import com.ydd.framework.core.common.Pagination;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class VideoController {

    @Resource
    private VideoService videoService;

    @RequestMapping("/findVideoList")
    public BaseResult<Pagination> findVideoList(@RequestBody Pagination pagination){
        return new BaseResult(videoService.findVideoList(pagination));
    }

}
