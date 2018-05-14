package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.wgs.entity.Banner;
import com.wgs.eurekaprovider.service.banner.BannerService;
import com.wgs.mapper.BannerMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BannerController {

    @Resource
    private BannerService bannerService;

    /**
     * banner
     * @return
     */
    @RequestMapping("/findBannerList")
    public BaseResult<List<Banner>> findBannerList(){
        return new BaseResult(bannerService.findBanners());
    }

}
