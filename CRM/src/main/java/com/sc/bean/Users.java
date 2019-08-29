package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
    private Integer uid;

    private String uname;

    private String upass;

    private String sex;

    private Integer age;

    private Date birthday;

    private String active;

    private String pic;

    private static final long serialVersionUID = 1L;

    public Users(Integer uid, String uname, String upass, String sex, Integer age, Date birthday, String active, String pic) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.active = active;
        this.pic = pic;
    }

    public Users() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass == null ? null : upass.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}