package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SalOrder;
import com.sc.bean.SalOrderExample;
import com.sc.bean.SalOrderExample.Criteria;
import com.sc.mapper.SalCustomInfoMapper;
import com.sc.mapper.SalOrderMapper;
import com.sc.mapper.SysCOMPANYMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.service.SalMessageService;

@Service
public class SalMessageServiceImpl implements SalMessageService {
	
	@Autowired
	SalOrderMapper som;
	
	@Autowired
	SysUsersMapper sum;
	
	@Autowired
	SalCustomInfoMapper scim;
	
	@Autowired
	SysCOMPANYMapper scm;
	
	@Override
	public float totalMoney() {
		return som.totalMoney();
	}

	@Override
	public int orderCount() {
		return som.orderCount();
	}

	@Override
	public int successOrderCount() {
		return som.successOrderCount();
	}

	@Override
	public int failOrderCount() {
		return som.failOrderCount();
	}

	@Override
	public float totalRebate() {
		return som.totalRebate();
	}

	@Override
	public int[] orderCountGroupByMonth() {
		int orderCount[] = new int[12];
		for(int i = 1;i <= 12;i++){
			orderCount[i-1] = som.orderCountGroupByMonth(i);
		}
		return orderCount;
	}

	@Override
	public int[] waitPayOrderCountGroupByMonth() {
		int waitPayOrderCount[] = new int[12];
		for(int i = 1;i <= 12;i++){
			waitPayOrderCount[i-1] = som.waitPayOrderCountGroupByMonth(i);
		}
		return waitPayOrderCount;
	}

	@Override
	public int[] havePayOrderCountGroupByMonth() {
		int havePayOrderCount[] = new int[12];
		for(int i = 1;i <= 12;i++){
			havePayOrderCount[i-1] = som.havePayOrderCountGroupByMonth(i);
		}
		return havePayOrderCount;
	}

	@Override
	public int[] waitPutOrderCountGroupByMonth() {
		int waitPutOrderCount[] = new int[12];
		for(int i = 1;i <= 12;i++){
			waitPutOrderCount[i-1] = som.waitPutOrderCountGroupByMonth(i);
		}
		return waitPutOrderCount;
	}


	@Override
	public PageInfo<SalOrder> selectSalOrder(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SalOrder> selectByExample = som.selectByExample(null);
		PageInfo<SalOrder> pageInfo = new PageInfo<SalOrder>(selectByExample);
		List<SalOrder> list = pageInfo.getList();
		for (SalOrder salOrder : list) {
			salOrder.setUser(sum.selectByPrimaryKey(salOrder.getUserId()));
			salOrder.setCustom(scim.selectByPrimaryKey(salOrder.getCustomId()));
			salOrder.setCompany(scm.selectByPrimaryKey(salOrder.getComId()));;
		}
		pageInfo.setList(list);
		return pageInfo;
	}

	@Override
	public PageInfo<SalOrder> selectSalOrderLike(Integer pageNum, Integer pageSize, String type, String message) {
		PageHelper.startPage(pageNum, pageSize);
		List<SalOrder> SalOrderList = null;
		if("0".equals(type)){
			SalOrderExample salOrderExample = new SalOrderExample();
			Criteria qbc = salOrderExample.createCriteria();
			qbc.andInvoiceNumberEqualTo(message);
			SalOrderList = som.selectByExample(salOrderExample);
		}else{
			SalOrderList = som.selectByLike(message);
		}
		
		PageInfo<SalOrder> pageInfo = new PageInfo<SalOrder>(SalOrderList);
		List<SalOrder> list = pageInfo.getList();
		for (SalOrder salOrder : list) {
			salOrder.setUser(sum.selectByPrimaryKey(salOrder.getUserId()));
			salOrder.setCustom(scim.selectByPrimaryKey(salOrder.getCustomId()));
			salOrder.setCompany(scm.selectByPrimaryKey(salOrder.getComId()));;
		}
		pageInfo.setList(list);
		return pageInfo;
	}

	@Override
	public void delSalOrderBykey(Long orderid) {
		som.deleteByPrimaryKey(orderid);
	}

	@Override
	public void sendSalOrderBykey(Long orderid) {
		SalOrder record = som.selectByPrimaryKey(orderid);
		record.setOrderOutState(1l);
		som.updateByPrimaryKey(record);
	}



	

}
