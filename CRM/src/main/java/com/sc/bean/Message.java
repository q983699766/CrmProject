package com.sc.bean;

import java.io.Serializable;

public class Message implements Serializable{ //实现虚拟话接口
	private String code; //消息代号
	private String status; //消息状态
	private String content;//消息内容
	
	public Message() {
		super();
	}
	public Message(String code, String status, String content) {
		super();
		this.code = code;
		this.status = status;
		this.content = content;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
