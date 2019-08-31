package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

public class SysCOMPANY implements Serializable {
    private Long comId;

    private String comName;

    private String comCode;

    private String comEmail;

    private String comLinkman;

    private String comAddress;

    private String comPhone;

    private String comYphone;

    private String comFax;

    private String comBank;

    private String comBankuser;

    private String comYesandno;

    private String comRemark;

    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysCOMPANY(Long comId, String comName, String comCode, String comEmail, String comLinkman, String comAddress, String comPhone, String comYphone, String comFax, String comBank, String comBankuser, String comYesandno, String comRemark, Date lastTime) {
        this.comId = comId;
        this.comName = comName;
        this.comCode = comCode;
        this.comEmail = comEmail;
        this.comLinkman = comLinkman;
        this.comAddress = comAddress;
        this.comPhone = comPhone;
        this.comYphone = comYphone;
        this.comFax = comFax;
        this.comBank = comBank;
        this.comBankuser = comBankuser;
        this.comYesandno = comYesandno;
        this.comRemark = comRemark;
        this.lastTime = lastTime;
    }

    public SysCOMPANY() {
        super();
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail == null ? null : comEmail.trim();
    }

    public String getComLinkman() {
        return comLinkman;
    }

    public void setComLinkman(String comLinkman) {
        this.comLinkman = comLinkman == null ? null : comLinkman.trim();
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress == null ? null : comAddress.trim();
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone == null ? null : comPhone.trim();
    }

    public String getComYphone() {
        return comYphone;
    }

    public void setComYphone(String comYphone) {
        this.comYphone = comYphone == null ? null : comYphone.trim();
    }

    public String getComFax() {
        return comFax;
    }

    public void setComFax(String comFax) {
        this.comFax = comFax == null ? null : comFax.trim();
    }

    public String getComBank() {
        return comBank;
    }

    public void setComBank(String comBank) {
        this.comBank = comBank == null ? null : comBank.trim();
    }

    public String getComBankuser() {
        return comBankuser;
    }

    public void setComBankuser(String comBankuser) {
        this.comBankuser = comBankuser == null ? null : comBankuser.trim();
    }

    public String getComYesandno() {
        return comYesandno;
    }

    public void setComYesandno(String comYesandno) {
        this.comYesandno = comYesandno == null ? null : comYesandno.trim();
    }

    public String getComRemark() {
        return comRemark;
    }

    public void setComRemark(String comRemark) {
        this.comRemark = comRemark == null ? null : comRemark.trim();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}