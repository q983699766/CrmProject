package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Ccspxxb implements Serializable {
    private Long productId; //商品编号

    private String spMc;	//商品名称

    private String spLb;	//商品类型

    private String ggSm;	//规格说明

    private String dw;		//单位

    private Long ckBh;		//仓库编号

    private Long kcSl;		//库存数量

    private BigDecimal cbj;	//成本价

    private BigDecimal lsj;	//零售价

    private BigDecimal jxj;	//经销价

    private String bzxx;	//备注信息

    private Long comId;		//公司编号
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;	//最后修改时间
    
    private PurProducts purproducts;

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

    public PurProducts getPurproducts() {
		return purproducts;
	}

	public void setPurproducts(PurProducts purproducts) {
		this.purproducts = purproducts;
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
				+ bzxx + ", comId=" + comId + ", lastTime=" + lastTime + ", purproducts=" + purproducts + "]";
	}

	
    
    
    
}