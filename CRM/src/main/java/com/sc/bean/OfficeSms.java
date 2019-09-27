package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OfficeSms implements Serializable {
    private Long smsId;

    private String smsHeadline;

    private String smsContent;

    private Long smsSender;

    private Long comId;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="utf-8")
    private Date lastTime;
    
    private SysCOMPANY syscompany;//配置一对一，定义另外一方的对象
    private SysUsers sysUsers;//配置一对一，定义另外一方的对象
    

   

	public SysCOMPANY getSyscompany() {
		return syscompany;
	}

	public void setSyscompany(SysCOMPANY syscompany) {
		this.syscompany = syscompany;
	}

	public SysUsers getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(SysUsers sysUsers) {
		this.sysUsers = sysUsers;
	}

	private static final long serialVersionUID = 1L;

    public OfficeSms(Long smsId, String smsHeadline, String smsContent, Long smsSender, Long comId, Date lastTime) {
        this.smsId = smsId;
        this.smsHeadline = smsHeadline;
        this.smsContent = smsContent;
        this.smsSender = smsSender;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public OfficeSms() {
        super();
    }

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getSmsHeadline() {
        return smsHeadline;
    }

    public void setSmsHeadline(String smsHeadline) {
        this.smsHeadline = smsHeadline == null ? null : smsHeadline.trim();
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent == null ? null : smsContent.trim();
    }

    public Long getSmsSender() {
        return smsSender;
    }

    public void setSmsSender(Long smsSender) {
        this.smsSender = smsSender;
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
		return "OfficeSms [smsId=" + smsId + ", smsHeadline=" + smsHeadline + ", smsContent=" + smsContent
				+ ", smsSender=" + smsSender + ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
    
    
    
}