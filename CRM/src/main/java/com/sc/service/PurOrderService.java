package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.PurOrder;

public interface PurOrderService {

		////查询所有订单
		public PageInfo<PurOrder> selectallorder(Integer pageNum,Integer pageSize,PurOrder purorder);
		//添加采购单信息
		public void addinfo(PurOrder purorder);
		//通过id删除采购单信息
		public void delinfo(Long purnumber);
		//通过id修改供应商信息
		public void updateinfo(Long purnumber);
		
		//查询订单并且查询订单详情
		
		
		
	
}
