package com.wgs.api.service;

import com.wgs.dto.BaseResult;
import com.ydd.framework.core.common.Pagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-api")
public interface VideoService {

    /**
     * 获取首页视频列表
     * @param pagination
     * @return
     */
    @RequestMapping("/findVideoList")
    BaseResult<Pagination> findVideoList(Pagination pagination);


}
