package com.wgs.api.controller;

import com.wgs.api.service.RegionService;
import com.wgs.dto.BaseResult;
import com.ydd.framework.core.common.dto.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Resource
    private RegionService regionService;

    /**
     * 省市区
     * @return
     */
    @RequestMapping("/list")
    public ResponseDTO findRegionList(){
        BaseResult result = regionService.findRegionList();
        return ResponseDTO.ok().addAttribute("data",result.getContent());
    }

}
