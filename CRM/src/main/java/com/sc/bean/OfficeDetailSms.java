package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OfficeDetailSms implements Serializable {
    private Long detailId;

    private Long smsId;

    private Long receiverId;

    private String smsState;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;
    
    private SysCOMPANY syscompany;//配置一对一，定义另外一方的对象
    private SysUsers sysUsers;//配置一对一，定义另外一方的对象
    private OfficeSms officeSms;
    
    
    
    
    public OfficeSms getOfficeSms() {
		return officeSms;
	}

	public void setOfficeSms(OfficeSms officeSms) {
		this.officeSms = officeSms;
	}

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

    public OfficeDetailSms(Long detailId, Long smsId, Long receiverId, String smsState, Long comId, Date lastTime) {
        this.detailId = detailId;
        this.smsId = smsId;
        this.receiverId = receiverId;
        this.smsState = smsState;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public OfficeDetailSms() {
        super();
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getSmsState() {
        return smsState;
    }

    public void setSmsState(String smsState) {
        this.smsState = smsState == null ? null : smsState.trim();
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
		return "OfficeDetailSms [detailId=" + detailId + ", smsId=" + smsId + ", receiverId=" + receiverId
				+ ", smsState=" + smsState + ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
    
    
}