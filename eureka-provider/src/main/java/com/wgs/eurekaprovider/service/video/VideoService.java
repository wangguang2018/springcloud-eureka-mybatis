package com.wgs.eurekaprovider.service.video;

import com.github.pagehelper.PageHelper;
import com.wgs.dto.video.VideoDTO;
import com.wgs.mapper.VideoMapper;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页视频
 */
@Service
public class VideoService extends BaseServiceImpl {

    @Resource
    private VideoMapper videoMapper;

    /**
     * 获取首页视频
     * @return
     */
    public Pagination findVideoList(Pagination pagination){
        PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
        pagination.setQueryResult(videoMapper.findVideoList());
        return pagination;
    }
}
