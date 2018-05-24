package com.wgs.api.service;

import com.wgs.dto.BaseResult;
import com.wgs.entity.Banner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "service-api")
public interface BannerService {

    @RequestMapping("/findBannerList")
    BaseResult<List<Banner>> findBannerList();

    @RequestMapping("/findLaunchImg")
    BaseResult<String> findLaunchImg();
}
