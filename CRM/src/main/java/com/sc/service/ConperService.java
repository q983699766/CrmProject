package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SalCustomInfo;


public interface ConperService {

	//分页查询所有客户信息
	
	public PageInfo<SalCustomInfo> selectSalCustomInfoPage(Integer pageNum, Integer pageSize);
	
	//根据ID查询客户所有信息
	public SalCustomInfo selectById(Long customId);
}
