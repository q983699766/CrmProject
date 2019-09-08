package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;
import com.sc.bean.Ccspxxb;


public interface CcCkxxbService {
	
	//添加
	public void addCcCkxx(CcCkxxb u);
	//库存商品信息分页
	public PageInfo<CcCkxxb> selectCcCcxxPage(Integer pageNum, Integer pageSize);
	//通过id管理我的库存商品信息
	public CcCkxxb selectCcCkxxbByUid(Long ckBh);
	//删除库存该商品
	public void delCcCkxx(Long uid);
	//修改库存的商品信息
	public void updateCcCkxx(CcCkxxb u);
	
	public PageInfo <Ccspxxb> selectbyckidPage(Integer pageNum, Integer pageSize ,Long ckBh);
	
	
	
	
}
