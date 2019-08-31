package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SysDuty implements Serializable {
    private Long dutId;

    private String dutName;

    private BigDecimal secId;

    private String dutRemark;

    private BigDecimal comId;

    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysDuty(Long dutId, String dutName, BigDecimal secId, String dutRemark, BigDecimal comId, Date lastTime) {
        this.dutId = dutId;
        this.dutName = dutName;
        this.secId = secId;
        this.dutRemark = dutRemark;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SysDuty() {
        super();
    }

    public Long getDutId() {
        return dutId;
    }

    public void setDutId(Long dutId) {
        this.dutId = dutId;
    }

    public String getDutName() {
        return dutName;
    }

    public void setDutName(String dutName) {
        this.dutName = dutName == null ? null : dutName.trim();
    }

    public BigDecimal getSecId() {
        return secId;
    }

    public void setSecId(BigDecimal secId) {
        this.secId = secId;
    }

    public String getDutRemark() {
        return dutRemark;
    }

    public void setDutRemark(String dutRemark) {
        this.dutRemark = dutRemark == null ? null : dutRemark.trim();
    }

    public BigDecimal getComId() {
        return comId;
    }

    public void setComId(BigDecimal comId) {
        this.comId = comId;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}