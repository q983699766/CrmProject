package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CcCkxxb implements Serializable {
    private Long ckBh;	//仓库编号

    private String ckM;	//仓库名

    private String bzxx;//备注信息

    private Long comId;	//公司编号

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;	//最后修改时间

    private static final long serialVersionUID = 1L;

    public CcCkxxb(Long ckBh, String ckM, String bzxx, Long comId, Date lastTime) {
        this.ckBh = ckBh;
        this.ckM = ckM;
        this.bzxx = bzxx;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public CcCkxxb() {
        super();
    }

    public Long getCkBh() {
        return ckBh;
    }

    public void setCkBh(Long ckBh) {
        this.ckBh = ckBh;
    }

    public String getCkM() {
        return ckM;
    }

    public void setCkM(String ckM) {
        this.ckM = ckM == null ? null : ckM.trim();
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx == null ? null : bzxx.trim();
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
		return "CcCkxxb [ckBh=" + ckBh + ", ckM=" + ckM + ", bzxx=" + bzxx + ", comId=" + comId + ", lastTime="
				+ lastTime + "]";
	}
    
    
    
    
    
}