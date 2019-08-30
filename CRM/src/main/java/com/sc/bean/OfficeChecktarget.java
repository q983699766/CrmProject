package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OfficeChecktarget implements Serializable {
    private Long targetId;

    private String checkTarget;

    private String remark;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public OfficeChecktarget(Long targetId, String checkTarget, String remark, Long comId, Date lastTime) {
        this.targetId = targetId;
        this.checkTarget = checkTarget;
        this.remark = remark;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public OfficeChecktarget() {
        super();
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getCheckTarget() {
        return checkTarget;
    }

    public void setCheckTarget(String checkTarget) {
        this.checkTarget = checkTarget == null ? null : checkTarget.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
		return "OfficeChecktarget [targetId=" + targetId + ", checkTarget=" + checkTarget + ", remark=" + remark
				+ ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
    
    
}