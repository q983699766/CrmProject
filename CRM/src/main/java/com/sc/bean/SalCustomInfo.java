package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class SalCustomInfo implements Serializable {
    private Long customId;

    private String customName;

    private String customProperties;

    private String website;

    private String ticketCode;

    private String superiorUnits;

    private String owner;

    private Long staff;

    private String tradeNumber;

    private String customType;

    private String customState;

    private String customSource;

    private Long headId;

    private String fixedPhone;

    private String cellPhone;

    private String customFax;

    private String depositBank;

    private BigDecimal bankAccout;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date nextcontactTime;

    private String email;

    private String sicCode;

    private String payWay;

    private String effectivity;

    private String detailAddress;

    private String remark;

    private Long comId;
    
    private List<SalConper> salconper;

    public List<SalConper> getSalconper() {
		return salconper;
	}

	public void setSalconper(List<SalConper> salconper) {
		this.salconper = salconper;
	}

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SalCustomInfo(Long customId, String customName, String customProperties, String website, String ticketCode, String superiorUnits, String owner, Long staff, String tradeNumber, String customType, String customState, String customSource, Long headId, String fixedPhone, String cellPhone, String customFax, String depositBank, BigDecimal bankAccout, Date nextcontactTime, String email, String sicCode, String payWay, String effectivity, String detailAddress, String remark, Long comId, Date lastTime) {
        this.customId = customId;
        this.customName = customName;
        this.customProperties = customProperties;
        this.website = website;
        this.ticketCode = ticketCode;
        this.superiorUnits = superiorUnits;
        this.owner = owner;
        this.staff = staff;
        this.tradeNumber = tradeNumber;
        this.customType = customType;
        this.customState = customState;
        this.customSource = customSource;
        this.headId = headId;
        this.fixedPhone = fixedPhone;
        this.cellPhone = cellPhone;
        this.customFax = customFax;
        this.depositBank = depositBank;
        this.bankAccout = bankAccout;
        this.nextcontactTime = nextcontactTime;
        this.email = email;
        this.sicCode = sicCode;
        this.payWay = payWay;
        this.effectivity = effectivity;
        this.detailAddress = detailAddress;
        this.remark = remark;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SalCustomInfo() {
        super();
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(String customProperties) {
        this.customProperties = customProperties == null ? null : customProperties.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode == null ? null : ticketCode.trim();
    }

    public String getSuperiorUnits() {
        return superiorUnits;
    }

    public void setSuperiorUnits(String superiorUnits) {
        this.superiorUnits = superiorUnits == null ? null : superiorUnits.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public Long getStaff() {
        return staff;
    }

    public void setStaff(Long staff) {
        this.staff = staff;
    }

    public String getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(String tradeNumber) {
        this.tradeNumber = tradeNumber == null ? null : tradeNumber.trim();
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType == null ? null : customType.trim();
    }

    public String getCustomState() {
        return customState;
    }

    public void setCustomState(String customState) {
        this.customState = customState == null ? null : customState.trim();
    }

    public String getCustomSource() {
        return customSource;
    }

    public void setCustomSource(String customSource) {
        this.customSource = customSource == null ? null : customSource.trim();
    }

    public Long getHeadId() {
        return headId;
    }

    public void setHeadId(Long headId) {
        this.headId = headId;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone == null ? null : fixedPhone.trim();
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    public String getCustomFax() {
        return customFax;
    }

    public void setCustomFax(String customFax) {
        this.customFax = customFax == null ? null : customFax.trim();
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank == null ? null : depositBank.trim();
    }

    public BigDecimal getBankAccout() {
        return bankAccout;
    }

    public void setBankAccout(BigDecimal bankAccout) {
        this.bankAccout = bankAccout;
    }

    public Date getNextcontactTime() {
        return nextcontactTime;
    }

    public void setNextcontactTime(Date nextcontactTime) {
        this.nextcontactTime = nextcontactTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSicCode() {
        return sicCode;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode == null ? null : sicCode.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getEffectivity() {
        return effectivity;
    }

    public void setEffectivity(String effectivity) {
        this.effectivity = effectivity == null ? null : effectivity.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
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

	@Override
	public String toString() {
		return "SalCustomInfo [customId=" + customId + ", customName=" + customName + ", customProperties="
				+ customProperties + ", website=" + website + ", ticketCode=" + ticketCode + ", superiorUnits="
				+ superiorUnits + ", owner=" + owner + ", staff=" + staff + ", tradeNumber=" + tradeNumber
				+ ", customType=" + customType + ", customState=" + customState + ", customSource=" + customSource
				+ ", headId=" + headId + ", fixedPhone=" + fixedPhone + ", cellPhone=" + cellPhone + ", customFax="
				+ customFax + ", depositBank=" + depositBank + ", bankAccout=" + bankAccout + ", nextcontactTime="
				+ nextcontactTime + ", email=" + email + ", sicCode=" + sicCode + ", payWay=" + payWay
				+ ", effectivity=" + effectivity + ", detailAddress=" + detailAddress + ", remark=" + remark
				+ ", comId=" + comId + ", salconper=" + salconper + ", lastTime=" + lastTime + "]";
	}


}