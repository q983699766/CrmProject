package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalGoodsDetailsPageBean implements Serializable{
	private BigDecimal money;
	private Long id;
	private String name;
	private Long num;
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public SalGoodsDetailsPageBean(BigDecimal money, Long id, String name, Long num) {
		super();
		this.money = money;
		this.id = id;
		this.name = name;
		this.num = num;
	}
	public SalGoodsDetailsPageBean() {
		super();
	}
	@Override
	public String toString() {
		return "SalGoodsDetailsPageBean [money=" + money + ", id=" + id + ", name=" + name + ", num=" + num + "]";
	}
	
	
}
