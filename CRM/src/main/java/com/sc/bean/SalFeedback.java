package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SalFeedback implements Serializable {
    private Long feedbackId;

    private String pri;

    private Long customId;

    private String states;

    private String feedbackType;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date feedbackTime;

    private Long headId;

    private String feedbackResource;

    private String feedbackTopic;

    private String feedbackDesc;

    private String anaiusis;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SalFeedback(Long feedbackId, String pri, Long customId, String states, String feedbackType, Date feedbackTime, Long headId, String feedbackResource, String feedbackTopic, String feedbackDesc, String anaiusis, Long comId, Date lastTime) {
        this.feedbackId = feedbackId;
        this.pri = pri;
        this.customId = customId;
        this.states = states;
        this.feedbackType = feedbackType;
        this.feedbackTime = feedbackTime;
        this.headId = headId;
        this.feedbackResource = feedbackResource;
        this.feedbackTopic = feedbackTopic;
        this.feedbackDesc = feedbackDesc;
        this.anaiusis = anaiusis;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SalFeedback() {
        super();
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri == null ? null : pri.trim();
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states == null ? null : states.trim();
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType == null ? null : feedbackType.trim();
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public Long getHeadId() {
        return headId;
    }

    public void setHeadId(Long headId) {
        this.headId = headId;
    }

    public String getFeedbackResource() {
        return feedbackResource;
    }

    public void setFeedbackResource(String feedbackResource) {
        this.feedbackResource = feedbackResource == null ? null : feedbackResource.trim();
    }

    public String getFeedbackTopic() {
        return feedbackTopic;
    }

    public void setFeedbackTopic(String feedbackTopic) {
        this.feedbackTopic = feedbackTopic == null ? null : feedbackTopic.trim();
    }

    public String getFeedbackDesc() {
        return feedbackDesc;
    }

    public void setFeedbackDesc(String feedbackDesc) {
        this.feedbackDesc = feedbackDesc == null ? null : feedbackDesc.trim();
    }

    public String getAnaiusis() {
        return anaiusis;
    }

    public void setAnaiusis(String anaiusis) {
        this.anaiusis = anaiusis == null ? null : anaiusis.trim();
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
		return "SalFeedback [feedbackId=" + feedbackId + ", pri=" + pri + ", customId=" + customId + ", states="
				+ states + ", feedbackType=" + feedbackType + ", feedbackTime=" + feedbackTime + ", headId=" + headId
				+ ", feedbackResource=" + feedbackResource + ", feedbackTopic=" + feedbackTopic + ", feedbackDesc="
				+ feedbackDesc + ", anaiusis=" + anaiusis + ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
}