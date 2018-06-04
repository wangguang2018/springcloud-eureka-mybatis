package com.wgs.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * Entity - 用户处方
 *
 * @author zuojie.liang
 * @since 2018-05-07
 */
public class MemberPrescription implements Serializable {

    /**
     *
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 用户id
     */
    private Integer memberId;

    /**
     * 右眼瞳距
     */
    private String rightPupilDistance;

    /**
     * 左眼瞳距
     */
    private String leftPupilDistance;

    /**
     * 右眼散光
     */
    private String rightAstigmatism;

    /**
     * 左眼散光
     */
    private String leftAstigmatism;

    /**
     * 右眼度数
     */
    private String rightDegree;

    /**
     * 左眼度数
     */
    private String leftDegree;

    /**
     * 右眼轴位
     */
    private String rightAxialPosition;

    /**
     * 左眼轴位
     */
    private String leftAxialPosition;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getRightAstigmatism() {
        return rightAstigmatism;
    }

    public void setRightAstigmatism(String rightAstigmatism) {
        this.rightAstigmatism = rightAstigmatism;
    }

    public String getLeftAstigmatism() {
        return leftAstigmatism;
    }

    public void setLeftAstigmatism(String leftAstigmatism) {
        this.leftAstigmatism = leftAstigmatism;
    }

    public String getRightDegree() {
        return rightDegree;
    }

    public void setRightDegree(String rightDegree) {
        this.rightDegree = rightDegree;
    }

    public String getLeftDegree() {
        return leftDegree;
    }

    public void setLeftDegree(String leftDegree) {
        this.leftDegree = leftDegree;
    }

    public Integer getCreatedId() {
        return createdId;
    }

    public void setCreatedId(Integer createdId) {
        this.createdId = createdId;
    }

    public Integer getModifiedId() {
        return modifiedId;
    }

    public void setModifiedId(Integer modifiedId) {
        this.modifiedId = modifiedId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getRightPupilDistance() {
        return rightPupilDistance;
    }

    public void setRightPupilDistance(String rightPupilDistance) {
        this.rightPupilDistance = rightPupilDistance;
    }

    public String getLeftPupilDistance() {
        return leftPupilDistance;
    }

    public void setLeftPupilDistance(String leftPupilDistance) {
        this.leftPupilDistance = leftPupilDistance;
    }

    public String getRightAxialPosition() {
        return rightAxialPosition;
    }

    public void setRightAxialPosition(String rightAxialPosition) {
        this.rightAxialPosition = rightAxialPosition;
    }

    public String getLeftAxialPosition() {
        return leftAxialPosition;
    }

    public void setLeftAxialPosition(String leftAxialPosition) {
        this.leftAxialPosition = leftAxialPosition;
    }
}
