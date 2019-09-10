package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

public class OOfficePerSche implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;//主键id
	private String title;//标题
	private String start;//开始时间
	private String end;//结束时间
	private String fullname;//跟标题一样内容
	private String confname;//重要程度
	private String confshortname;//暂未使用：默认M1
	private String allDay;//暂未使用：默认0
	private String topic;//暂未使用：默认‘dasd’
	private String description;//备注内容
	private String uid;//用户id
	private String cid;//用户公司id
	private String lasttime;//最后修改时间

	// Constructors

	/** default constructor */
	public OOfficePerSche() {
	}

	/** full constructor */
	public OOfficePerSche(String title, String start, String end,
			String fullname, String confname, String confshortname,
			String allDay, String topic, String description, String uid,
			String cid, String lasttime) {
		this.title = title;
		this.start = start;
		this.end = end;
		this.fullname = fullname;
		this.confname = confname;
		this.confshortname = confshortname;
		this.allDay = allDay;
		this.topic = topic;
		this.description = description;
		this.uid = uid;
		this.cid = cid;
		this.lasttime = lasttime;
	}

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getConfname() {
		return this.confname;
	}

	public void setConfname(String confname) {
		this.confname = confname;
	}


	public String getConfshortname() {
		return this.confshortname;
	}

	public void setConfshortname(String confshortname) {
		this.confshortname = confshortname;
	}


	public String getAllDay() {
		return this.allDay;
	}

	public void setAllDay(String allDay) {
		this.allDay = allDay;
	}


	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	
	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getLasttime() {
		return this.lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	@Override
	public String toString() {
		return "OOfficePerSche [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + ", fullname="
				+ fullname + ", confname=" + confname + ", confshortname=" + confshortname + ", allDay=" + allDay
				+ ", topic=" + topic + ", description=" + description + ", uid=" + uid + ", cid=" + cid + ", lasttime="
				+ lasttime + "]";
	}
	
	
    
}