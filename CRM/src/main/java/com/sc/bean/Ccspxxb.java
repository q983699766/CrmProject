package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Ccspxxb implements Serializable {
    private Long productId;

    private String spMc;

    private String spLb;

    private String ggSm;

    private String dw;

    private Long ckBh;

    private Long kcSl;

    private BigDecimal cbj;

    private BigDecimal lsj;

    private BigDecimal jxj;

    private String bzxx;

    private Long comId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public Ccspxxb(Long productId, String spMc, String spLb, String ggSm, String dw, Long ckBh, Long kcSl, BigDecimal cbj, BigDecimal lsj, BigDecimal jxj, String bzxx, Long comId, Date lastTime) {
        this.productId = productId;
        this.spMc = spMc;
        this.spLb = spLb;
        this.ggSm = ggSm;
        this.dw = dw;
        this.ckBh = ckBh;
        this.kcSl = kcSl;
        this.cbj = cbj;
        this.lsj = lsj;
        this.jxj = jxj;
        this.bzxx = bzxx;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public Ccspxxb() {
        super();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSpMc() {
        return spMc;
    }

    public void setSpMc(String spMc) {
        this.spMc = spMc == null ? null : spMc.trim();
    }

    public String getSpLb() {
        return spLb;
    }

    public void setSpLb(String spLb) {
        this.spLb = spLb == null ? null : spLb.trim();
    }

    public String getGgSm() {
        return ggSm;
    }

    public void setGgSm(String ggSm) {
        this.ggSm = ggSm == null ? null : ggSm.trim();
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw == null ? null : dw.trim();
    }

    public Long getCkBh() {
        return ckBh;
    }

    public void setCkBh(Long ckBh) {
        this.ckBh = ckBh;
    }

    public Long getKcSl() {
        return kcSl;
    }

    public void setKcSl(Long kcSl) {
        this.kcSl = kcSl;
    }

    public BigDecimal getCbj() {
        return cbj;
    }

    public void setCbj(BigDecimal cbj) {
        this.cbj = cbj;
    }

    public BigDecimal getLsj() {
        return lsj;
    }

    public void setLsj(BigDecimal lsj) {
        this.lsj = lsj;
    }

    public BigDecimal getJxj() {
        return jxj;
    }

    public void setJxj(BigDecimal jxj) {
        this.jxj = jxj;
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
		return "Ccspxxb [productId=" + productId + ", spMc=" + spMc + ", spLb=" + spLb + ", ggSm=" + ggSm + ", dw=" + dw
				+ ", ckBh=" + ckBh + ", kcSl=" + kcSl + ", cbj=" + cbj + ", lsj=" + lsj + ", jxj=" + jxj + ", bzxx="
				+ bzxx + ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
    
    
    
    
}