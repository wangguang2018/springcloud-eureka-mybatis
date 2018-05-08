package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 用户token
 *
 * @author zhaoziyu
 * @since 2018-05-08
 */
public class MemberToken implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String accessToken;

    /**
     * 
     */
    private Date expireTime;

    /**
     * 
     */
    private Integer memberId;

    /**
     * 
     */
    private String refreshToken;

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
     * 设置
     *
     * @param accessToken 
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getAccessToken(){
        return accessToken;
    }


    /**
     * 设置
     *
     * @param expireTime 
     */
    public void setExpireTime(Date expireTime){
        this.expireTime = expireTime;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Date getExpireTime(){
        return expireTime;
    }


    /**
     * 设置
     *
     * @param memberId 
     */
    public void setMemberId(Integer memberId){
        this.memberId = memberId;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getMemberId(){
        return memberId;
    }


    /**
     * 设置
     *
     * @param refreshToken 
     */
    public void setRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getRefreshToken(){
        return refreshToken;
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