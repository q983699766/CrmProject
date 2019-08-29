package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SysUsersRole implements Serializable {
    private Long userRoleId;

    private Long userId;

    private Long roleId;

    private Long operatorId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysUsersRole(Long userRoleId, Long userId, Long roleId, Long operatorId, Date lastTime) {
        this.userRoleId = userRoleId;
        this.userId = userId;
        this.roleId = roleId;
        this.operatorId = operatorId;
        this.lastTime = lastTime;
    }

    public SysUsersRole() {
        super();
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
		return "SysUsersRole [userRoleId=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + ", operatorId="
				+ operatorId + ", lastTime=" + lastTime + "]";
	}
}