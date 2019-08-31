package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SalOrder implements Serializable {
    private Long orderId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String invoiceNumber;

    private Long userId;

    private Long customId;

    private BigDecimal salMoney;

    private Long orderOutState;

    private Long rebate;

    private Long orderState;

    private String remark;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SalOrder(Long orderId, Date createTime, String invoiceNumber, Long userId, Long customId, BigDecimal salMoney, Long orderOutState, Long rebate, Long orderState, String remark, Long comId, Date lastTime) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.invoiceNumber = invoiceNumber;
        this.userId = userId;
        this.customId = customId;
        this.salMoney = salMoney;
        this.orderOutState = orderOutState;
        this.rebate = rebate;
        this.orderState = orderState;
        this.remark = remark;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SalOrder() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public BigDecimal getSalMoney() {
        return salMoney;
    }

    public void setSalMoney(BigDecimal salMoney) {
        this.salMoney = salMoney;
    }

    public Long getOrderOutState() {
        return orderOutState;
    }

    public void setOrderOutState(Long orderOutState) {
        this.orderOutState = orderOutState;
    }

    public Long getRebate() {
        return rebate;
    }

    public void setRebate(Long rebate) {
        this.rebate = rebate;
    }

    public Long getOrderState() {
        return orderState;
    }

    public void setOrderState(Long orderState) {
        this.orderState = orderState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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