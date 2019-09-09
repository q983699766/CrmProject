package com.sc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.PurOrderInfo;
import com.sc.bean.PurOrderInfoExample;
import com.sc.mapper.PurOrderInfoMapper;
@Service
public class PurProductsInfoServiceImpl implements PurProductsInfoService {

	
	@Autowired
	PurOrderInfoMapper purOrderInfoMapper;

	//分页查询
	@Override
	public PageInfo<PurOrderInfo> selectPurOrderInfo(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		PurOrderInfoExample example = new PurOrderInfoExample();
		example.setOrderByClause("PRODUCT_ID DESC");		
		List<PurOrderInfo> list = purOrderInfoMapper.selectByExample(example);
		PageInfo<PurOrderInfo> pi = new PageInfo<PurOrderInfo>(list);
		return pi;
		
	}
	

	
}
