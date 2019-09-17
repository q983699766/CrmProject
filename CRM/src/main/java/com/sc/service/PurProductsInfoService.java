package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.PurOrderInfo;

public interface PurProductsInfoService {
	
	//分页查询
	public PageInfo<PurOrderInfo> selectPurOrderInfo(Integer pageNum, Integer pageSize,Long purInfoNumber );
	
	//通过id查询
	public PurOrderInfo selctPurOrderInfoByid(Long purInfoNumber );
	//模糊查询
	public PageInfo<PurOrderInfo> mh(Integer pageNum, Integer pageSize,PurOrderInfo purInfoNumber );
}
