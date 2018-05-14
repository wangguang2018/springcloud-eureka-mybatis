package com.wgs.api.service;

import com.wgs.dto.BaseResult;
import com.wgs.dto.RegionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "service-api")
public interface RegionService {

    @RequestMapping("/findRegionList")
    BaseResult<List<RegionDTO>> findRegionList();

}
