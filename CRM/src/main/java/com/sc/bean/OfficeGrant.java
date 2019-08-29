package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OfficeGrant implements Serializable {
    private Long relId;

    private Long userId;

    private Long upid;

    private String describ;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public OfficeGrant(Long relId, Long userId, Long upid, String describ, Long comId, Date lastTime) {
        this.relId = relId;
        this.userId = userId;
        this.upid = upid;
        this.describ = describ;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public OfficeGrant() {
        super();
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUpid() {
        return upid;
    }

    public void setUpid(Long upid) {
        this.upid = upid;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ == null ? null : describ.trim();
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

	@Override
	public String toString() {
		return "OfficeGrant [relId=" + relId + ", userId=" + userId + ", upid=" + upid + ", describ=" + describ
				+ ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
    
    
}