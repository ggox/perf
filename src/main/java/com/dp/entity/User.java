package com.dp.entity;

import java.util.Date;

public class User {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门编码
     */
    private String departmentCode;

    /**
     * 组织编码
     */
    private String organizationCode;

    /**
     * 1有效，0失效
     */
    private Boolean status;

    /**
     * 账号是否锁定，1：锁定，0未锁定
     */
    private Boolean locked;

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
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 账号
     * @return account 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 姓名
     * @return realName 姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 姓名
     * @param realName 姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 盐
     * @return salt 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 电话
     * @return tel 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 电话
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 部门编码
     * @return departmentCode 部门编码
     */
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * 部门编码
     * @param departmentCode 部门编码
     */
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    /**
     * 组织编码
     * @return organizationCode 组织编码
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 组织编码
     * @param organizationCode 组织编码
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * 1有效，0失效
     * @return status 1有效，0失效
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 1有效，0失效
     * @param status 1有效，0失效
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 账号是否锁定，1：锁定，0未锁定
     * @return locked 账号是否锁定，1：锁定，0未锁定
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 账号是否锁定，1：锁定，0未锁定
     * @param locked 账号是否锁定，1：锁定，0未锁定
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
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