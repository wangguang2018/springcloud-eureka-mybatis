package com.wgs.api.controller;

import com.wgs.api.service.BannerService;
import com.wgs.dto.BaseResult;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/banner")
public class BannerController extends BaseApiController {

    @Resource
    private BannerService bannerService;

    @RequestMapping("/list")
    public ResponseDTO findBannerList(){
        BaseResult result = bannerService.findBannerList();
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }

    @RequestMapping("/launch")
    public ResponseDTO findLaunchImg(){
        BaseResult result = bannerService.findLaunchImg();
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }

}
