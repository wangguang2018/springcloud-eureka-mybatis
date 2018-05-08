package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 用户
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class Member implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 小程序openid
     */
    private String xcxOpenId;

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
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    /**
     * 获取昵称
     *
     * @return 昵称
     */
    public String getNickname(){
        return nickname;
    }


    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    /**
     * 获取头像
     *
     * @return 头像
     */
    public String getAvatar(){
        return avatar;
    }


    /**
     * 设置小程序openid
     *
     * @param xcxOpenId 小程序openid
     */
    public void setXcxOpenId(String xcxOpenId){
        this.xcxOpenId = xcxOpenId;
    }

    /**
     * 获取小程序openid
     *
     * @return 小程序openid
     */
    public String getXcxOpenId(){
        return xcxOpenId;
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