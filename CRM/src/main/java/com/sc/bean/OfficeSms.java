package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

public class OfficeSms implements Serializable {
    private Long smsId;

    private String smsHeadline;

    private String smsContent;

    private Long smsSender;

    private Long comId;

    private Date lastTime;

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
}