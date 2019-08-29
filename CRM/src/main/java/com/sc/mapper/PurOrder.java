package com.sc.mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PurOrder implements Serializable {
    private Long purNumber;

    private String purTitle;

    private Date purDate;

    private Long supInfoNum;

    private BigDecimal payAmount;

    private String invoiceNumber;

    private Long payStatus;

    private Long purProgrees;

    private Date deliveryTime;

    private String deliveryAddress;

    private String deliveryMode;

    private Long operatorId;

    private String remarksInfo;

    private Long comId;

    private Date lastDate;

    private static final long serialVersionUID = 1L;

    public PurOrder(Long purNumber, String purTitle, Date purDate, Long supInfoNum, BigDecimal payAmount, String invoiceNumber, Long payStatus, Long purProgrees, Date deliveryTime, String deliveryAddress, String deliveryMode, Long operatorId, String remarksInfo, Long comId, Date lastDate) {
        this.purNumber = purNumber;
        this.purTitle = purTitle;
        this.purDate = purDate;
        this.supInfoNum = supInfoNum;
        this.payAmount = payAmount;
        this.invoiceNumber = invoiceNumber;
        this.payStatus = payStatus;
        this.purProgrees = purProgrees;
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;
        this.deliveryMode = deliveryMode;
        this.operatorId = operatorId;
        this.remarksInfo = remarksInfo;
        this.comId = comId;
        this.lastDate = lastDate;
    }

    public PurOrder() {
        super();
    }

    public Long getPurNumber() {
        return purNumber;
    }

    public void setPurNumber(Long purNumber) {
        this.purNumber = purNumber;
    }

    public String getPurTitle() {
        return purTitle;
    }

    public void setPurTitle(String purTitle) {
        this.purTitle = purTitle == null ? null : purTitle.trim();
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public Long getSupInfoNum() {
        return supInfoNum;
    }

    public void setSupInfoNum(Long supInfoNum) {
        this.supInfoNum = supInfoNum;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public Long getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Long payStatus) {
        this.payStatus = payStatus;
    }

    public Long getPurProgrees() {
        return purProgrees;
    }

    public void setPurProgrees(Long purProgrees) {
        this.purProgrees = purProgrees;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode == null ? null : deliveryMode.trim();
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