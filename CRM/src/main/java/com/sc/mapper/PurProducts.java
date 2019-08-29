package com.sc.mapper;

import java.io.Serializable;
import java.util.Date;

public class PurProducts implements Serializable {
    private Long proId;

    private Long productId;

    private Date deliveryTime;

    private String active;

    private Long operatorId;

    private String remarksInfo;

    private Long comId;

    private Date lastDate;

    private static final long serialVersionUID = 1L;

    public PurProducts(Long proId, Long productId, Date deliveryTime, String active, Long operatorId, String remarksInfo, Long comId, Date lastDate) {
        this.proId = proId;
        this.productId = productId;
        this.deliveryTime = deliveryTime;
        this.active = active;
        this.operatorId = operatorId;
        this.remarksInfo = remarksInfo;
        this.comId = comId;
        this.lastDate = lastDate;
    }

    public PurProducts() {
        super();
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getRemarksInfo() {
        return remarksInfo;
    }

    public void setRemarksInfo(String remarksInfo) {
        this.remarksInfo = remarksInfo == null ? null : remarksInfo.trim();
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
}