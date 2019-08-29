package com.sc.mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PurOrderInfo implements Serializable {
    private Long purInfoNumber;

    private Long purNumber;

    private Long productId;

    private BigDecimal proPrice;

    private String warehouseOrnot;

    private Long operatorId;

    private String remarksInfom;

    private Long comId;

    private Date lastDate;

    private Long productCount;

    private static final long serialVersionUID = 1L;

    public PurOrderInfo(Long purInfoNumber, Long purNumber, Long productId, BigDecimal proPrice, String warehouseOrnot, Long operatorId, String remarksInfom, Long comId, Date lastDate, Long productCount) {
        this.purInfoNumber = purInfoNumber;
        this.purNumber = purNumber;
        this.productId = productId;
        this.proPrice = proPrice;
        this.warehouseOrnot = warehouseOrnot;
        this.operatorId = operatorId;
        this.remarksInfom = remarksInfom;
        this.comId = comId;
        this.lastDate = lastDate;
        this.productCount = productCount;
    }

    public PurOrderInfo() {
        super();
    }

    public Long getPurInfoNumber() {
        return purInfoNumber;
    }

    public void setPurInfoNumber(Long purInfoNumber) {
        this.purInfoNumber = purInfoNumber;
    }

    public Long getPurNumber() {
        return purNumber;
    }

    public void setPurNumber(Long purNumber) {
        this.purNumber = purNumber;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getProPrice() {
        return proPrice;
    }

    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }

    public String getWarehouseOrnot() {
        return warehouseOrnot;
    }

    public void setWarehouseOrnot(String warehouseOrnot) {
        this.warehouseOrnot = warehouseOrnot == null ? null : warehouseOrnot.trim();
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getRemarksInfom() {
        return remarksInfom;
    }

    public void setRemarksInfom(String remarksInfom) {
        this.remarksInfom = remarksInfom == null ? null : remarksInfom.trim();
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}