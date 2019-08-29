package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OfficeTaskdetail implements Serializable {
    private Long idd;

    private Long taskId;

    private Long receiverId;

    private Long isFinish;

    private Long statue;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public OfficeTaskdetail(Long idd, Long taskId, Long receiverId, Long isFinish, Long statue, Long comId, Date lastTime) {
        this.idd = idd;
        this.taskId = taskId;
        this.receiverId = receiverId;
        this.isFinish = isFinish;
        this.statue = statue;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public OfficeTaskdetail() {
        super();
    }

    public Long getIdd() {
        return idd;
    }

    public void setIdd(Long idd) {
        this.idd = idd;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Long isFinish) {
        this.isFinish = isFinish;
    }

    public Long getStatue() {
        return statue;
    }

    public void setStatue(Long statue) {
        this.statue = statue;
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
		return "OfficeTaskdetail [idd=" + idd + ", taskId=" + taskId + ", receiverId=" + receiverId + ", isFinish="
				+ isFinish + ", statue=" + statue + ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
    
    
}