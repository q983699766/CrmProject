package com.sc.bean;

import java.util.Arrays;

public class SalMessageBean {
	//总交易金额
	private float totalMoney;
	
	//总订单数量
	private int orderCount;
	
	//交易成功数量
	private int successOrderCount;
	
	//交易失败数量
	private int failOrderCount;
	
	//退款金额
	private float totalRebate;
	
	//分月订单数量 
	private int[] orderCountGroupByMonth;
	
	//分月待支付订单数量
	private int[] waitPayOrderCountGroupByMonth;
	
	//分月已支付订单数量
	private int[] havePayOrderCountGroupByMonth;
	
	//分月待发货订单数量
	private int[] waitPutOrderCountGroupByMonth;

	public SalMessageBean(float totalMoney, int orderCount, int successOrderCount, int failOrderCount,
			float totalRebate, int[] orderCountGroupByMonth, int[] waitPayOrderCountGroupByMonth,
			int[] havePayOrderCountGroupByMonth, int[] waitPutOrderCountGroupByMonth) {
		super();
		this.totalMoney = totalMoney;
		this.orderCount = orderCount;
		this.successOrderCount = successOrderCount;
		this.failOrderCount = failOrderCount;
		this.totalRebate = totalRebate;
		this.orderCountGroupByMonth = orderCountGroupByMonth;
		this.waitPayOrderCountGroupByMonth = waitPayOrderCountGroupByMonth;
		this.havePayOrderCountGroupByMonth = havePayOrderCountGroupByMonth;
		this.waitPutOrderCountGroupByMonth = waitPutOrderCountGroupByMonth;
	}

	public SalMessageBean() {
		super();
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getSuccessOrderCount() {
		return successOrderCount;
	}

	public void setSuccessOrderCount(int successOrderCount) {
		this.successOrderCount = successOrderCount;
	}

	public int getFailOrderCount() {
		return failOrderCount;
	}

	public void setFailOrderCount(int failOrderCount) {
		this.failOrderCount = failOrderCount;
	}

	public float getTotalRebate() {
		return totalRebate;
	}

	public void setTotalRebate(float totalRebate) {
		this.totalRebate = totalRebate;
	}

	public int[] getOrderCountGroupByMonth() {
		return orderCountGroupByMonth;
	}

	public void setOrderCountGroupByMonth(int[] orderCountGroupByMonth) {
		this.orderCountGroupByMonth = orderCountGroupByMonth;
	}

	public int[] getWaitPayOrderCountGroupByMonth() {
		return waitPayOrderCountGroupByMonth;
	}

	public void setWaitPayOrderCountGroupByMonth(int[] waitPayOrderCountGroupByMonth) {
		this.waitPayOrderCountGroupByMonth = waitPayOrderCountGroupByMonth;
	}

	public int[] getHavePayOrderCountGroupByMonth() {
		return havePayOrderCountGroupByMonth;
	}

	public void setHavePayOrderCountGroupByMonth(int[] havePayOrderCountGroupByMonth) {
		this.havePayOrderCountGroupByMonth = havePayOrderCountGroupByMonth;
	}

	public int[] getWaitPutOrderCountGroupByMonth() {
		return waitPutOrderCountGroupByMonth;
	}

	public void setWaitPutOrderCountGroupByMonth(int[] waitPutOrderCountGroupByMonth) {
		this.waitPutOrderCountGroupByMonth = waitPutOrderCountGroupByMonth;
	}

	@Override
	public String toString() {
		return "SalMessageBean [totalMoney=" + totalMoney + ", orderCount=" + orderCount + ", successOrderCount="
				+ successOrderCount + ", failOrderCount=" + failOrderCount + ", totalRebate=" + totalRebate
				+ ", orderCountGroupByMonth=" + Arrays.toString(orderCountGroupByMonth)
				+ ", waitPayOrderCountGroupByMonth=" + Arrays.toString(waitPayOrderCountGroupByMonth)
				+ ", havePayOrderCountGroupByMonth=" + Arrays.toString(havePayOrderCountGroupByMonth)
				+ ", waitPutOrderCountGroupByMonth=" + Arrays.toString(waitPutOrderCountGroupByMonth) + "]";
	}
	
	
}
