package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SalOrder;

public interface SalMessageService {
	//统计总交易金额
	public float totalMoney();
	
	//统计总订单数量
	public int orderCount();
	
	//统计交易成功数量
	public int successOrderCount();
	
	//统计交易失败数量
	public int failOrderCount();
	
	//统计退款金额
	public float totalRebate();
	
	//分月统计订单数量 
	public int[] orderCountGroupByMonth();
	
	//分月统计待支付订单数量
	public int[] waitPayOrderCountGroupByMonth();
	
	//分月统计已支付订单数量
	public int[] havePayOrderCountGroupByMonth();
	
	//分月统计待发货订单数量
	public int[] waitPutOrderCountGroupByMonth();
	
	//分页订单信息
	public PageInfo<SalOrder> selectSalOrder(Integer pageNum, Integer pageSize);
	
	//分页搜索订单信息
	public PageInfo<SalOrder> selectSalOrderLike(Integer pageNum, Integer pageSize,String type,String message);
	
	//删除订单
	public void delSalOrderBykey(Long orderid);
	
	//发货
	public void sendSalOrderBykey(Long orderid);
	
}
