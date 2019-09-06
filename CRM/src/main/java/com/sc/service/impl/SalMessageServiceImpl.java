package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SalOrder;
import com.sc.mapper.SalOrderMapper;
import com.sc.service.SalMessageService;

@Service
public class SalMessageServiceImpl implements SalMessageService {
	
	@Autowired
	SalOrderMapper som;
	
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
	public List<SalOrder> selectSalOrder() {
		List<SalOrder> selectByExample = som.selectByExample(null);
		return selectByExample;
	}

}
