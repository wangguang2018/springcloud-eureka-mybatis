package com.wgs.eurekaprovider.service.utils;

import com.wgs.entity.utils.DateBean;
import com.wgs.mapper.DateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class DateService {

    private static Logger logger = LoggerFactory.getLogger(DateService.class);

    @Resource
    private DateMapper dateMapper;

    /**
     * 获取当前时间
     * @return
     */
    public Date getNow(){
        DateBean now  = dateMapper.getNow();
        return now.getNow();
    }


}
