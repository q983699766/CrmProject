package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SysPermissionRole implements Serializable {
    private Long permissionRoleId;

    private Long permissionId;

    private Long roleId;

    private Long operatorId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysPermissionRole(Long permissionRoleId, Long permissionId, Long roleId, Long operatorId, Date lastTime) {
        this.permissionRoleId = permissionRoleId;
        this.permissionId = permissionId;
        this.roleId = roleId;
        this.operatorId = operatorId;
        this.lastTime = lastTime;
    }

    public SysPermissionRole() {
        super();
    }

    public Long getPermissionRoleId() {
        return permissionRoleId;
    }

    public void setPermissionRoleId(Long permissionRoleId) {
        this.permissionRoleId = permissionRoleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

	@Override
	public String toString() {
		return "SysPermissionRole [permissionRoleId=" + permissionRoleId + ", permissionId=" + permissionId
				+ ", roleId=" + roleId + ", operatorId=" + operatorId + ", lastTime=" + lastTime + "]";
	}
}