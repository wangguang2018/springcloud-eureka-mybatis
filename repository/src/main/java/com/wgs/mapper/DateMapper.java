package com.wgs.mapper;


import com.wgs.entity.utils.DateBean;

/**
 * Mapper - Dater
 *
 * @author zhaoziyu
 * @since 2018-05-14
 */
public interface DateMapper {

    /**
     * 获取现在
     * @return
     */
    DateBean getNow();
}