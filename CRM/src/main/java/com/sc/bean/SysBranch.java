package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SysBranch implements Serializable {
    private BigDecimal secId;

    private String secName;

    private String secComment;

    private BigDecimal comId;

    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysBranch(BigDecimal secId, String secName, String secComment, BigDecimal comId, Date lastTime) {
        this.secId = secId;
        this.secName = secName;
        this.secComment = secComment;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SysBranch() {
        super();
    }

    public BigDecimal getSecId() {
        return secId;
    }

    public void setSecId(BigDecimal secId) {
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