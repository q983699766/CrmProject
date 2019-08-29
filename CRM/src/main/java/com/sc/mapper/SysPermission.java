package com.sc.mapper;

import java.io.Serializable;
import java.util.Date;

public class SysPermission implements Serializable {
    private Long permissionId;

    private String permissionName;

    private String permission;

    private String permissionColumn;

    private String remark;

    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysPermission(Long permissionId, String permissionName, String permission, String permissionColumn, String remark, Date lastTime) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permission = permission;
        this.permissionColumn = permissionColumn;
        this.remark = remark;
        this.lastTime = lastTime;
    }

    public SysPermission() {
        super();
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getPermissionColumn() {
        return permissionColumn;
    }

    public void setPermissionColumn(String permissionColumn) {
        this.permissionColumn = permissionColumn == null ? null : permissionColumn.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}