package com.sc.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class SalConper implements Serializable {
    private Long conperId;

    private Long customId;

    private String conperName;

    private String englishName;

    private String post;

    private String dept;

    private String cellPhone;

    private String tel;

    private String email;

    private String address;

    private String remark;

    private Long comId;
    
    //拓展属性--联系记录
    private List<SalRecord> salrecord;
  	
	public List<SalRecord> getSalrecord() {
		return salrecord;
	}

	public void setSalrecord(List<SalRecord> salrecord) {
		this.salrecord = salrecord;
	}
	
	
	//拓展属性--销售出库
	private SalOrder salorder;

	public SalOrder getSalorder() {
		return salorder;
	}

	public void setSalorder(SalOrder salorder) {
		this.salorder = salorder;
	}


	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SalConper(Long conperId, Long customId, String conperName, String englishName, String post, String dept, String cellPhone, String tel, String email, String address, String remark, Long comId, Date lastTime) {
        this.conperId = conperId;
        this.customId = customId;
        this.conperName = conperName;
        this.englishName = englishName;
        this.post = post;
        this.dept = dept;
        this.cellPhone = cellPhone;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.remark = remark;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SalConper() {
        super();
    }

    public Long getConperId() {
        return conperId;
    }

    public void setConperId(Long conperId) {
        this.conperId = conperId;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getConperName() {
        return conperName;
    }

    public void setConperName(String conperName) {
        this.conperName = conperName == null ? null : conperName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
		return "SalConper [conperId=" + conperId + ", customId=" + customId + ", conperName=" + conperName
				+ ", englishName=" + englishName + ", post=" + post + ", dept=" + dept + ", cellPhone=" + cellPhone
				+ ", tel=" + tel + ", email=" + email + ", address=" + address + ", remark=" + remark + ", comId="
				+ comId + ", lastTime=" + lastTime + "]";
	}




}