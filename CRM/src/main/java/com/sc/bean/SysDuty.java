package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysDuty implements Serializable {
    private Long dutId;

    private String dutName;

    private Long secId;

    private String dutRemark;

    private Long comId;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    @Override
	public String toString() {
		return "SysDuty [dutId=" + dutId + ", dutName=" + dutName + ", secId=" + secId + ", dutRemark=" + dutRemark
				+ ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}

	public SysDuty(Long dutId, String dutName, Long secId, String dutRemark, Long comId, Date lastTime) {
        this.dutId = dutId;
        this.dutName = dutName;
        this.secId = secId;
        this.dutRemark = dutRemark;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SysDuty() {
        super();
    }

    public Long getDutId() {
        return dutId;
    }

    public void setDutId(Long dutId) {
        this.dutId = dutId;
    }

    public String getDutName() {
        return dutName;
    }

    public void setDutName(String dutName) {
        this.dutName = dutName == null ? null : dutName.trim();
    }

    public Long getSecId() {
        return secId;
    }

    public void setSecId(Long secId) {
        this.secId = secId;
    }

    public String getDutRemark() {
        return dutRemark;
    }

    public void setDutRemark(String dutRemark) {
        this.dutRemark = dutRemark == null ? null : dutRemark.trim();
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
}