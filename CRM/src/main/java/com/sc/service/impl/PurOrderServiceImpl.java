package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.PurOrder;
import com.sc.bean.PurOrderExample;
import com.sc.mapper.PurOrderMapper;
import com.sc.mapper.PurSupInfoMapper;
import com.sc.service.PurOrderService;

@Service
public class PurOrderServiceImpl implements PurOrderService {

	@Autowired
	PurOrderMapper purordermapper;
@Autowired
  PurSupInfoMapper pursupinfomapper;
	@Override
	public PageInfo<PurOrder> selectallorder(Integer pageNum, Integer pageSize, PurOrder purorder) {
		 //设置开始分页
		PageHelper.startPage(pageNum, pageSize);
		 PurOrderExample example = new PurOrderExample();
		
		//调用查询所有的方法
		List<PurOrder> list=this.purordermapper.selectByExample(example);
		//封装LIST到pageinfo
		PageInfo<PurOrder> pi = new PageInfo<PurOrder>(list);
		
		return pi;
	}

	@Override
	public void addinfo(PurOrder purorder) {
		if(purorder!=null){
		purordermapper.insert(purorder);
	}}

	@Override
	public void delinfo(Long purnumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateinfo(Long purnumber) {
		// TODO Auto-generated method stub

	}
}
