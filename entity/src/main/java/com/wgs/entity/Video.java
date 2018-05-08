package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 视频
 *
 * @author zhaoziyu
 * @since 2018-05-08
 */
public class Video implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 视频地址
     */
    private String videoUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 封面
     */
    private String cover;

    /**
     * 创建者编号
     */
    private Integer createdId;

    /**
     * 更新者编号
     */
    private Integer modifiedId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date modifiedTime;

    /**
     * 删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     */
    private Integer deleted;



    /**
     * 设置
     *
     * @param id 
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getId(){
        return id;
    }


    /**
     * 设置视频地址
     *
     * @param videoUrl 视频地址
     */
    public void setVideoUrl(String videoUrl){
        this.videoUrl = videoUrl;
    }

    /**
     * 获取视频地址
     *
     * @return 视频地址
     */
    public String getVideoUrl(){
        return videoUrl;
    }


    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort){
        this.sort = sort;
    }

    /**
     * 获取排序
     *
     * @return 排序
     */
    public Integer getSort(){
        return sort;
    }


    /**
     * 设置封面
     *
     * @param cover 封面
     */
    public void setCover(String cover){
        this.cover = cover;
    }

    /**
     * 获取封面
     *
     * @return 封面
     */
    public String getCover(){
        return cover;
    }


    /**
     * 设置创建者编号
     *
     * @param createdId 创建者编号
     */
    public void setCreatedId(Integer createdId){
        this.createdId = createdId;
    }

    /**
     * 获取创建者编号
     *
     * @return 创建者编号
     */
    public Integer getCreatedId(){
        return createdId;
    }


    /**
     * 设置更新者编号
     *
     * @param modifiedId 更新者编号
     */
    public void setModifiedId(Integer modifiedId){
        this.modifiedId = modifiedId;
    }

    /**
     * 获取更新者编号
     *
     * @return 更新者编号
     */
    public Integer getModifiedId(){
        return modifiedId;
    }


    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }

    /**
     * 获取创建时间
     *
     * @return 创建时间
     */
    public Date getCreatedTime(){
        return createdTime;
    }


    /**
     * 设置更新时间
     *
     * @param modifiedTime 更新时间
     */
    public void setModifiedTime(Date modifiedTime){
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取更新时间
     *
     * @return 更新时间
     */
    public Date getModifiedTime(){
        return modifiedTime;
    }


    /**
     * 设置删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     * @param deleted 删除标识位
     */
    public void setDeleted(Integer deleted){
        this.deleted = deleted;
    }

    /**
     * 获取删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     * @return 删除标识位
     */
    public Integer getDeleted(){
        return deleted;
    }

}