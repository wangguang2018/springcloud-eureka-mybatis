package com.wgs.eurekaprovider.service.banner;

import com.wgs.entity.Banner;
import com.wgs.mapper.BannerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerService {

    @Resource
    private BannerMapper bannerMapper;

    /**
     * 获取banner
     * @return
     */
    public List<Banner> findBanners(){
        return bannerMapper.findAll();
    }

    public String findLaunchImg(){
        return bannerMapper.findLaunchImg();
    }

}
