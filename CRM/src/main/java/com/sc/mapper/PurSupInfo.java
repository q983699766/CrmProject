package com.sc.mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PurSupInfo implements Serializable {
    private Long supInfoNum;

    private String supName;

    private String supUname;

    private String contacts;

    private String fixedTel;

    private String telphone;

    private String fax;

    private String email;

    private String openBank;

    private String bankNature;

    private String comIndex;

    private String effectiveOrnot;

    private Long operatorId;

    private String remarksInfo;

    private Long comId;

    private Date lastDate;

    private BigDecimal bankNumber;

    private static final long serialVersionUID = 1L;

    public PurSupInfo(Long supInfoNum, String supName, String supUname, String contacts, String fixedTel, String telphone, String fax, String email, String openBank, String bankNature, String comIndex, String effectiveOrnot, Long operatorId, String remarksInfo, Long comId, Date lastDate, BigDecimal bankNumber) {
        this.supInfoNum = supInfoNum;
        this.supName = supName;
        this.supUname = supUname;
        this.contacts = contacts;
        this.fixedTel = fixedTel;
        this.telphone = telphone;
        this.fax = fax;
        this.email = email;
        this.openBank = openBank;
        this.bankNature = bankNature;
        this.comIndex = comIndex;
        this.effectiveOrnot = effectiveOrnot;
        this.operatorId = operatorId;
        this.remarksInfo = remarksInfo;
        this.comId = comId;
        this.lastDate = lastDate;
        this.bankNumber = bankNumber;
    }

    public PurSupInfo() {
        super();
    }

    public Long getSupInfoNum() {
        return supInfoNum;
    }

    public void setSupInfoNum(Long supInfoNum) {
        this.supInfoNum = supInfoNum;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName == null ? null : supName.trim();
    }

    public String getSupUname() {
        return supUname;
    }

    public void setSupUname(String supUname) {
        this.supUname = supUname == null ? null : supUname.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getFixedTel() {
        return fixedTel;
    }

    public void setFixedTel(String fixedTel) {
        this.fixedTel = fixedTel == null ? null : fixedTel.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    public String getBankNature() {
        return bankNature;
    }

    public void setBankNature(String bankNature) {
        this.bankNature = bankNature == null ? null : bankNature.trim();
    }

    public String getComIndex() {
        return comIndex;
    }

    public void setComIndex(String comIndex) {
        this.comIndex = comIndex == null ? null : comIndex.trim();
    }

    public String getEffectiveOrnot() {
        return effectiveOrnot;
    }

    public void setEffectiveOrnot(String effectiveOrnot) {
        this.effectiveOrnot = effectiveOrnot == null ? null : effectiveOrnot.trim();
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

    public BigDecimal getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(BigDecimal bankNumber) {
        this.bankNumber = bankNumber;
    }
}