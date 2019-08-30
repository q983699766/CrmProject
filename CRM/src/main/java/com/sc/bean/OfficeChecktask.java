package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OfficeChecktask implements Serializable {
    private Long taskId;

    private String taskTitle;

    private String taskContent;

    private String taskPublisher;

    private Long targetId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date taskStarttime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date taskEndtime;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public OfficeChecktask(Long taskId, String taskTitle, String taskContent, String taskPublisher, Long targetId, Date taskStarttime, Date taskEndtime, Long comId, Date lastTime) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
        this.taskPublisher = taskPublisher;
        this.targetId = targetId;
        this.taskStarttime = taskStarttime;
        this.taskEndtime = taskEndtime;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public OfficeChecktask() {
        super();
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle == null ? null : taskTitle.trim();
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent == null ? null : taskContent.trim();
    }

    public String getTaskPublisher() {
        return taskPublisher;
    }

    public void setTaskPublisher(String taskPublisher) {
        this.taskPublisher = taskPublisher == null ? null : taskPublisher.trim();
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Date getTaskStarttime() {
        return taskStarttime;
    }

    public void setTaskStarttime(Date taskStarttime) {
        this.taskStarttime = taskStarttime;
    }

    public Date getTaskEndtime() {
        return taskEndtime;
    }

    public void setTaskEndtime(Date taskEndtime) {
        this.taskEndtime = taskEndtime;
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
		return "OfficeChecktask [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskContent=" + taskContent
				+ ", taskPublisher=" + taskPublisher + ", targetId=" + targetId + ", taskStarttime=" + taskStarttime
				+ ", taskEndtime=" + taskEndtime + ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
    
    
}