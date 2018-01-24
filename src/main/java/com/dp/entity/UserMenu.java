package com.dp.entity;

import java.util.Date;
import java.util.List;

public class UserMenu {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 访问url地址
     */
    private String url;

    /**
     * 父结点id
     */
    private Integer parentId;

    /**
     * 父结点id列表串
     */
    private String parentIds;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序号
     */
    private String sort;

    /**
     * 是否可用,1：可用，0不可用
     */
    private Boolean status;

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
     * 子节点列表
     */
    private List<UserMenu> subUserMenus;

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
     * 资源名称
     * @return name 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 资源名称
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 访问url地址
     * @return url 访问url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 访问url地址
     * @param url 访问url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 父结点id
     * @return parentId 父结点id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父结点id
     * @param parentId 父结点id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 父结点id列表串
     * @return parentIds 父结点id列表串
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 父结点id列表串
     * @param parentIds 父结点id列表串
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * 菜单图标
     * @return icon 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 排序号
     * @return sort 排序号
     */
    public String getSort() {
        return sort;
    }

    /**
     * 排序号
     * @param sort 排序号
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * 是否可用,1：可用，0不可用
     * @return status 是否可用,1：可用，0不可用
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 是否可用,1：可用，0不可用
     * @param status 是否可用,1：可用，0不可用
     */
    public void setStatus(Boolean status) {
        this.status = status;
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

	public List<UserMenu> getSubUserMenus() {
		return subUserMenus;
	}

	public void setSubUserMenus(List<UserMenu> subUserMenus) {
		this.subUserMenus = subUserMenus;
	}
    
}