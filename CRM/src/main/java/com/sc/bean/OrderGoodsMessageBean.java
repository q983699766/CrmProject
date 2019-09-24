package com.sc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

public class OrderGoodsMessageBean implements Serializable{
	private Long customId;
	private String remark;
	private BigDecimal totalM; 
	private SalGoodsDetailsPageBean[] list;
	private Long orderId;
	
	public OrderGoodsMessageBean() {
		super();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomId() {
		return customId;
	}

	public void setCustomId(Long customId) {
		this.customId = customId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getTotalM() {
		return totalM;
	}

	public void setTotalM(BigDecimal totalM) {
		this.totalM = totalM;
	}

	public SalGoodsDetailsPageBean[] getList() {
		return list;
	}

	public void setList(SalGoodsDetailsPageBean[] list) {
		this.list = list;
	}

	

	
	

	@Override
	public String toString() {
		return "OrderGoodsMessageBean [customId=" + customId + ", remark=" + remark + ", totalM=" + totalM + ", list="
				+ Arrays.toString(list) + "]";
	}

	public OrderGoodsMessageBean(Long customId, String remark, BigDecimal totalM, SalGoodsDetailsPageBean[] list) {
		super();
		this.customId = customId;
		this.remark = remark;
		this.totalM = totalM;
		this.list = list;
	}
	
	
}
