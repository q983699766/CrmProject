package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysBranch implements Serializable {
    private Long secId;

    private String secName;

    private String secComment;

    private Long comId;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    @Override
	public String toString() {
		return "SysBranch [secId=" + secId + ", secName=" + secName + ", secComment=" + secComment + ", comId=" + comId
				+ ", lastTime=" + lastTime + "]";
	}

	public SysBranch(Long secId, String secName, String secComment, Long comId, Date lastTime) {
        this.secId = secId;
        this.secName = secName;
        this.secComment = secComment;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SysBranch() {
        super();
    }

    public Long getSecId() {
        return secId;
    }

    public void setSecId(Long secId) {
        this.secId = secId;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName == null ? null : secName.trim();
    }

    public String getSecComment() {
        return secComment;
    }

    public void setSecComment(String secComment) {
        this.secComment = secComment == null ? null : secComment.trim();
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