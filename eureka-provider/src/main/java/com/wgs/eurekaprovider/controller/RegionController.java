package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.dto.RegionDTO;
import com.wgs.eurekaprovider.service.region.RegionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RegionController {

    @Resource
    private RegionService regionService;

    /**
     * 省市区
     * @return
     */
    @RequestMapping("/findRegionList")
    public BaseResult<List<RegionDTO>> findRegionList(){
        return new BaseResult<>(regionService.findRegionList());
    }
}
