package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 主题
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class Topic implements Serializable {


    /**
     * 主题名称
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 主题标题
     */
    private String title;

    /**
     * 主题描述
     */
    private String desc;

    /**
     * 主题图片
     */
    private String img;

    /**
     * 排序
     */
    private Integer sort;

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
     * 设置主题名称
     *
     * @param id 主题名称
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 获取主题名称
     *
     * @return 主题名称
     */
    public Integer getId(){
        return id;
    }


    /**
     * 设置
     *
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getName(){
        return name;
    }


    /**
     * 设置主题标题
     *
     * @param title 主题标题
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * 获取主题标题
     *
     * @return 主题标题
     */
    public String getTitle(){
        return title;
    }


    /**
     * 设置主题描述
     *
     * @param desc 主题描述
     */
    public void setDesc(String desc){
        this.desc = desc;
    }

    /**
     * 获取主题描述
     *
     * @return 主题描述
     */
    public String getDesc(){
        return desc;
    }


    /**
     * 设置主题图片
     *
     * @param img 主题图片
     */
    public void setImg(String img){
        this.img = img;
    }

    /**
     * 获取主题图片
     *
     * @return 主题图片
     */
    public String getImg(){
        return img;
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