package com.sc.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class SysRole implements Serializable {
    private Long roleId;

    private String roleName;

    private String roleDescribe;

    private Long higherRoleId;

    private Long operatorId;
    
    private String highRoleName;
    
    private List<SysPermission> perms;

    public List<SysPermission> getPerms() {
		return perms;
	}

	public void setPerms(List<SysPermission> perms) {
		this.perms = perms;
	}

	public String getHighRoleName() {
		return highRoleName;
	}

	public void setHighRoleName(String highRoleName) {
		this.highRoleName = highRoleName;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysRole(Long roleId, String roleName, String roleDescribe, Long higherRoleId, Long operatorId, Date lastTime) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescribe = roleDescribe;
        this.higherRoleId = higherRoleId;
        this.operatorId = operatorId;
        this.lastTime = lastTime;
    }

    public SysRole() {
        super();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
    }

    public Long getHigherRoleId() {
        return higherRoleId;
    }

    public void setHigherRoleId(Long higherRoleId) {
        this.higherRoleId = higherRoleId;
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
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName + ", roleDescribe=" + roleDescribe
				+ ", higherRoleId=" + higherRoleId + ", operatorId=" + operatorId + ", lastTime=" + lastTime + "]";
	}
}