package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {
    private Long logId;

    private Long userId;

    private String accessIp;

    private String permission;

    private Date accessTime;

    private Long comId;

    private static final long serialVersionUID = 1L;

    public SysLog(Long logId, Long userId, String accessIp, String permission, Date accessTime, Long comId) {
        this.logId = logId;
        this.userId = userId;
        this.accessIp = accessIp;
        this.permission = permission;
        this.accessTime = accessTime;
        this.comId = comId;
    }

    public SysLog() {
        super();
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessIp() {
        return accessIp;
    }

    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp == null ? null : accessIp.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }
}