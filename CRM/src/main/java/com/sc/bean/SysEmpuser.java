package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SysEmpuser implements Serializable {
    private BigDecimal empId;

    private String empName;

    private String empSix;

    private String empPrice;

    private String empNumber;

    private String empAddress;

    private String empTadayadd;

    private String empEduca;

    private String empFace;

    private String empSchool;

    private String empPhone;

    private String empMeshphone;

    private String empContact;

    private String empState;

    private BigDecimal dutId;

    private String empSysstate;

    private String empRemark;

    private BigDecimal comId;

    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysEmpuser(BigDecimal empId, String empName, String empSix, String empPrice, String empNumber, String empAddress, String empTadayadd, String empEduca, String empFace, String empSchool, String empPhone, String empMeshphone, String empContact, String empState, BigDecimal dutId, String empSysstate, String empRemark, BigDecimal comId, Date lastTime) {
        this.empId = empId;
        this.empName = empName;
        this.empSix = empSix;
        this.empPrice = empPrice;
        this.empNumber = empNumber;
        this.empAddress = empAddress;
        this.empTadayadd = empTadayadd;
        this.empEduca = empEduca;
        this.empFace = empFace;
        this.empSchool = empSchool;
        this.empPhone = empPhone;
        this.empMeshphone = empMeshphone;
        this.empContact = empContact;
        this.empState = empState;
        this.dutId = dutId;
        this.empSysstate = empSysstate;
        this.empRemark = empRemark;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SysEmpuser() {
        super();
    }

    public BigDecimal getEmpId() {
        return empId;
    }

    public void setEmpId(BigDecimal empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpSix() {
        return empSix;
    }

    public void setEmpSix(String empSix) {
        this.empSix = empSix == null ? null : empSix.trim();
    }

    public String getEmpPrice() {
        return empPrice;
    }

    public void setEmpPrice(String empPrice) {
        this.empPrice = empPrice == null ? null : empPrice.trim();
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber == null ? null : empNumber.trim();
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress == null ? null : empAddress.trim();
    }

    public String getEmpTadayadd() {
        return empTadayadd;
    }

    public void setEmpTadayadd(String empTadayadd) {
        this.empTadayadd = empTadayadd == null ? null : empTadayadd.trim();
    }

    public String getEmpEduca() {
        return empEduca;
    }

    public void setEmpEduca(String empEduca) {
        this.empEduca = empEduca == null ? null : empEduca.trim();
    }

    public String getEmpFace() {
        return empFace;
    }

    public void setEmpFace(String empFace) {
        this.empFace = empFace == null ? null : empFace.trim();
    }

    public String getEmpSchool() {
        return empSchool;
    }

    public void setEmpSchool(String empSchool) {
        this.empSchool = empSchool == null ? null : empSchool.trim();
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone == null ? null : empPhone.trim();
    }

    public String getEmpMeshphone() {
        return empMeshphone;
    }

    public void setEmpMeshphone(String empMeshphone) {
        this.empMeshphone = empMeshphone == null ? null : empMeshphone.trim();
    }

    public String getEmpContact() {
        return empContact;
    }

    public void setEmpContact(String empContact) {
        this.empContact = empContact == null ? null : empContact.trim();
    }

    public String getEmpState() {
        return empState;
    }

    public void setEmpState(String empState) {
        this.empState = empState == null ? null : empState.trim();
    }

    public BigDecimal getDutId() {
        return dutId;
    }

    public void setDutId(BigDecimal dutId) {
        this.dutId = dutId;
    }

    public String getEmpSysstate() {
        return empSysstate;
    }

    public void setEmpSysstate(String empSysstate) {
        this.empSysstate = empSysstate == null ? null : empSysstate.trim();
    }

    public String getEmpRemark() {
        return empRemark;
    }

    public void setEmpRemark(String empRemark) {
        this.empRemark = empRemark == null ? null : empRemark.trim();
    }

    public BigDecimal getComId() {
        return comId;
    }

    public void setComId(BigDecimal comId) {
        this.comId = comId;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}