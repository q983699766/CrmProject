package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;

public interface CcSpxxService {

	//查询所有的 库存商品信息
	public List<CcCkxxb> selectCcspxx();
	//添加
	public void addCcspxx(CcCkxxb u);
	//库存商品信息分页
	public PageInfo<CcCkxxb> selectCcspxxPage(Integer pageNum, Integer pageSize);
	//通过id管理我的库存商品信息
	public PageInfo<CcCkxxb> selectCcspxxByUid(Integer pageNum, Integer pageSize,Integer uid);
	//删除库存该商品
	public void delCcspxx(Integer fwid);
	//修改库存的商品信息
	public void updateCcspxx(CcCkxxb u);
}
