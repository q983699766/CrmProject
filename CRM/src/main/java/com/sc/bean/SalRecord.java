package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SalRecord implements Serializable {
    private Long recordId;

    private String recordTitle;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date recordTime;

    //联系人编号
    private Long customId;

    private String recordContent;

    
    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SalRecord(Long recordId, String recordTitle, Date recordTime, Long customId, String recordContent, Long comId, Date lastTime) {
        this.recordId = recordId;
        this.recordTitle = recordTitle;
        this.recordTime = recordTime;
        this.customId = customId;
        this.recordContent = recordContent;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SalRecord() {
        super();
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getRecordTitle() {
        return recordTitle;
    }

    public void setRecordTitle(String recordTitle) {
        this.recordTitle = recordTitle == null ? null : recordTitle.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent == null ? null : recordContent.trim();
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
		return "SalRecord [recordId=" + recordId + ", recordTitle=" + recordTitle + ", recordTime=" + recordTime
				+ ", customId=" + customId + ", recordContent=" + recordContent + ", comId=" + comId + ", lastTime="
				+ lastTime + "]";
	}
}