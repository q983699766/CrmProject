package com.sc.bean;

import java.awt.List;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SysUsers implements Serializable {
    private Long userId;

    private String userName;

    private String userPassword;

    private Long empId;

    private Long comId;

    private String userState;
    
    private String empName;
    
    private String roleName;


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysUsers(Long userId, String userName, String userPassword, Long empId, Long comId, String userState, Date lastTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.empId = empId;
        this.comId = comId;
        this.userState = userState;
        this.lastTime = lastTime;
    }

    
    public SysUsers() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

	@Override
	public String toString() {
		return "SysUsers [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", empId="
				+ empId + ", comId=" + comId + ", userState=" + userState + ", lastTime=" + lastTime + "]";
	}
    
    
}