package com.dp.entity;

import java.util.Date;

public class UserPermission {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String permissionCode;

    /**
     * 
     */
    private String permissionName;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String updateBy;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return permissionCode 
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * 
     * @param permissionCode 
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * 
     * @return permissionName 
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 
     * @param permissionName 
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 
     * @return createTime 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return createBy 
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 
     * @param createBy 
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 
     * @return updateTime 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     * @return updateBy 
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 
     * @param updateBy 
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}