package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OfficePersonalAgenda implements Serializable {
    private Long scheduleId;

    private String scheduleClasses;

    private String scheduleTheme;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    private Long writerId;

    private String scheduleDescribe;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public OfficePersonalAgenda(Long scheduleId, String scheduleClasses, String scheduleTheme, Date startDate, Date startTime, Long writerId, String scheduleDescribe, Long comId, Date lastTime) {
        this.scheduleId = scheduleId;
        this.scheduleClasses = scheduleClasses;
        this.scheduleTheme = scheduleTheme;
        this.startDate = startDate;
        this.startTime = startTime;
        this.writerId = writerId;
        this.scheduleDescribe = scheduleDescribe;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public OfficePersonalAgenda() {
        super();
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleClasses() {
        return scheduleClasses;
    }

    public void setScheduleClasses(String scheduleClasses) {
        this.scheduleClasses = scheduleClasses == null ? null : scheduleClasses.trim();
    }

    public String getScheduleTheme() {
        return scheduleTheme;
    }

    public void setScheduleTheme(String scheduleTheme) {
        this.scheduleTheme = scheduleTheme == null ? null : scheduleTheme.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public String getScheduleDescribe() {
        return scheduleDescribe;
    }

    public void setScheduleDescribe(String scheduleDescribe) {
        this.scheduleDescribe = scheduleDescribe == null ? null : scheduleDescribe.trim();
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
		return "OfficePersonalAgenda [scheduleId=" + scheduleId + ", scheduleClasses=" + scheduleClasses
				+ ", scheduleTheme=" + scheduleTheme + ", startDate=" + startDate + ", startTime=" + startTime
				+ ", writerId=" + writerId + ", scheduleDescribe=" + scheduleDescribe + ", comId=" + comId
				+ ", lastTime=" + lastTime + "]";
	}
    
    
    
    
}