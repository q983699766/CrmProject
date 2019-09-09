package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;
import com.sc.bean.Ccspxxb;


public interface CcCkxxbService {
	
	//添加
	public void addCcCkxx(CcCkxxb u);
	//仓库信息分页
	public PageInfo<CcCkxxb> selectCcCcxxPage(Integer pageNum, Integer pageSize);
	//通过id管理仓库信息
	public CcCkxxb selectCcCkxxbByUid(Long ckBh);
	//删除仓库信息
	public void delCcCkxx(Long uid);
	//修改仓库的信息
	public void updateCcCkxx(CcCkxxb u);
	//通过仓库id查询属于该仓库的商品
	public PageInfo <Ccspxxb> selectbyckidPage(Integer pageNum, Integer pageSize ,Long ckBh);
	
	//商品模糊查询
	public PageInfo<CcCkxxb> selectmh(Integer pageNum,Integer pageSize,CcCkxxb ccCkxxb);

	
	
}
