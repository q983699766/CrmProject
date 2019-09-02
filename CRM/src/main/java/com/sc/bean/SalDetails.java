package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class SalDetails implements Serializable {
    private Long detailsId;

    private Long orderId;

    private Long productId;

    private Long productCount;

    private BigDecimal productPrices;

    private String remark;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastDate;

    private static final long serialVersionUID = 1L;

    public SalDetails(Long detailsId, Long orderId, Long productId, Long productCount, BigDecimal productPrices, String remark, Long comId, Date lastDate) {
        this.detailsId = detailsId;
        this.orderId = orderId;
        this.productId = productId;
        this.productCount = productCount;
        this.productPrices = productPrices;
        this.remark = remark;
        this.comId = comId;
        this.lastDate = lastDate;
    }

    public SalDetails() {
        super();
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(BigDecimal productPrices) {
        this.productPrices = productPrices;
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

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}