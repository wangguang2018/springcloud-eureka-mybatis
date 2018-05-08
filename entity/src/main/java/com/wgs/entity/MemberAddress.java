package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 用户收货地址
 *
 * @author zhaoziyu
 * @since 2018-05-07
 */
public class MemberAddress implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer memberId;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 具体地址
     */
    private String street;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 默认地址
     */
    private Integer isDefault;

    /**
     * 市ID
     */
    private Integer cityId;

    /**
     * 省
     */
    private Integer provinceId;

    /**
     * 区
     */
    private Integer areaId;

    /**
     * 
     */
    private String cityName;

    /**
     * 
     */
    private String provinceName;

    /**
     * 
     */
    private String area;

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
     * 设置收货地址
     *
     * @param address 收货地址
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * 获取收货地址
     *
     * @return 收货地址
     */
    public String getAddress(){
        return address;
    }


    /**
     * 设置具体地址
     *
     * @param street 具体地址
     */
    public void setStreet(String street){
        this.street = street;
    }

    /**
     * 获取具体地址
     *
     * @return 具体地址
     */
    public String getStreet(){
        return street;
    }


    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * 获取联系电话
     *
     * @return 联系电话
     */
    public String getPhone(){
        return phone;
    }


    /**
     * 设置联系人
     *
     * @param contact 联系人
     */
    public void setContact(String contact){
        this.contact = contact;
    }

    /**
     * 获取联系人
     *
     * @return 联系人
     */
    public String getContact(){
        return contact;
    }


    /**
     * 设置默认地址
     *
     * @param isDefault 默认地址
     */
    public void setIsDefault(Integer isDefault){
        this.isDefault = isDefault;
    }

    /**
     * 获取默认地址
     *
     * @return 默认地址
     */
    public Integer getIsDefault(){
        return isDefault;
    }


    /**
     * 设置市ID
     *
     * @param cityId 市ID
     */
    public void setCityId(Integer cityId){
        this.cityId = cityId;
    }

    /**
     * 获取市ID
     *
     * @return 市ID
     */
    public Integer getCityId(){
        return cityId;
    }


    /**
     * 设置省
     *
     * @param provinceId 省
     */
    public void setProvinceId(Integer provinceId){
        this.provinceId = provinceId;
    }

    /**
     * 获取省
     *
     * @return 省
     */
    public Integer getProvinceId(){
        return provinceId;
    }


    /**
     * 设置区
     *
     * @param areaId 区
     */
    public void setAreaId(Integer areaId){
        this.areaId = areaId;
    }

    /**
     * 获取区
     *
     * @return 区
     */
    public Integer getAreaId(){
        return areaId;
    }


    /**
     * 设置
     *
     * @param cityName 
     */
    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getCityName(){
        return cityName;
    }


    /**
     * 设置
     *
     * @param provinceName 
     */
    public void setProvinceName(String provinceName){
        this.provinceName = provinceName;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getProvinceName(){
        return provinceName;
    }


    /**
     * 设置
     *
     * @param area 
     */
    public void setArea(String area){
        this.area = area;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getArea(){
        return area;
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