package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 省市区
 *
 * @author zhaoziyu
 * @since 2018-05-14
 */
public class Region implements Serializable {


    /**
     * ID
     */
    private Integer id;

    /**
     * 区域代码
     */
    private String code;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 名称
     */
    private String name;

    /**
     * 
     */
    private String pinyin;

    /**
     * 上级编号
     */
    private Integer parentId;

    /**
     * 创建者编号
     */
    private Integer createdId;

    /**
     * 创建者编号
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
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 获取ID
     *
     * @return ID
     */
    public Integer getId(){
        return id;
    }


    /**
     * 设置区域代码
     *
     * @param code 区域代码
     */
    public void setCode(String code){
        this.code = code;
    }

    /**
     * 获取区域代码
     *
     * @return 区域代码
     */
    public String getCode(){
        return code;
    }


    /**
     * 设置等级
     *
     * @param level 等级
     */
    public void setLevel(Integer level){
        this.level = level;
    }

    /**
     * 获取等级
     *
     * @return 等级
     */
    public Integer getLevel(){
        return level;
    }


    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取名称
     *
     * @return 名称
     */
    public String getName(){
        return name;
    }


    /**
     * 设置
     *
     * @param pinyin 
     */
    public void setPinyin(String pinyin){
        this.pinyin = pinyin;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getPinyin(){
        return pinyin;
    }


    /**
     * 设置上级编号
     *
     * @param parentId 上级编号
     */
    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }

    /**
     * 获取上级编号
     *
     * @return 上级编号
     */
    public Integer getParentId(){
        return parentId;
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
     * 设置创建者编号
     *
     * @param modifiedId 创建者编号
     */
    public void setModifiedId(Integer modifiedId){
        this.modifiedId = modifiedId;
    }

    /**
     * 获取创建者编号
     *
     * @return 创建者编号
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