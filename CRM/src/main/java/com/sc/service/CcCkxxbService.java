package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;


public interface CcCkxxbService {
	
	//添加
	public void addCcCkxx(CcCkxxb u);
	//库存商品信息分页
	public PageInfo<CcCkxxb> selectCcCcxxPage(Integer pageNum, Integer pageSize);
	//通过id管理我的库存商品信息
	public PageInfo<CcCkxxb> selectCcCkxxbByUid(Long uid);
	//删除库存该商品
	public void delCcCkxx(Long uid);
	//修改库存的商品信息
	public void updateCcCkxx(CcCkxxb u);
	
	
	
	
}
