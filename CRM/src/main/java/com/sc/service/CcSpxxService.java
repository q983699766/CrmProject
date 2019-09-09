package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import com.sc.bean.Ccspxxb;

public interface CcSpxxService {

	//查询所有的 库存商品信息
	public List<Ccspxxb> selectCcspxx();
	//添加
	public void addCcspxx(Ccspxxb u);
	//库存商品信息分页
	public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize);
	//通过id管理我的库存商品信息
	public PageInfo<Ccspxxb> selectCcspxxByUid(Integer pageNum, Integer pageSize,Integer uid);
	//删除库存该商品
	public void delCcspxx(Long productId);
	//修改库存的商品信息
	public void updateCcspxx(Ccspxxb u);
	//商品模糊查询
	public List<Ccspxxb> selectCcspxx(Ccspxxb ccspxx );
	
	
	public List<Ccspxxb> selectByExamplel(Ccspxxb ccspxx);
}