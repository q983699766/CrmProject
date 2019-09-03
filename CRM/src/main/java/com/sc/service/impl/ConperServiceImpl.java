package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SalCustomInfoExample;
import com.sc.mapper.SalCustomInfoMapper;
import com.sc.service.ConperService;

@Service
public class ConperServiceImpl implements ConperService {

	@Autowired
	SalCustomInfoMapper salCustomInfoMapper;
	@Override
	public PageInfo<SalCustomInfo> selectSalCustomInfoPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		SalCustomInfoExample example = new SalCustomInfoExample();
		List<SalCustomInfo> list = salCustomInfoMapper.selectByExample(example);
		PageInfo<SalCustomInfo> pi = new PageInfo<SalCustomInfo>(list);
		return pi;
	}
	@Override
	public SalCustomInfo selectById(Long customId) {
	
		return salCustomInfoMapper.selectByPrimaryKey(customId);
	}

}
