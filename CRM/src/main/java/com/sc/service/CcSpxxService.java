package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import com.sc.bean.Ccspxxb;
import com.sc.bean.PurOrderInfo;
import com.sc.bean.PurSupInfo;
import com.sc.bean.SalDetails;
import com.sc.bean.SalOrder;
import com.sc.mapper.SalOrderMapper;

public interface CcSpxxService {

	// 查询所有的 库存商品信息
	public List<Ccspxxb> selectCcspxx();

	// 添加
	public void addCcspxx(Ccspxxb u);

	// 库存商品信息分页
	public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize);

	// 通过id管理我的库存商品信息
	public Ccspxxb selectCcspxxByUid(Long productId);

	// 删除库存该商品
	public void delCcspxx(Long productId);

	// 修改库存的商品信息
	public void updateCcspxx(Ccspxxb u, PurOrderInfo p);

	public List<Ccspxxb> selectByExamplel(Ccspxxb ccspxx);
	// 商品模糊查询
	public PageInfo<Ccspxxb> selectmh(Integer pageNum, Integer pageSize, Ccspxxb ccspxx);
	
	//销售出库单查询
	public PageInfo<SalOrder> selectSalOrder(Integer pageNum, Integer pageSize);
	//销售模糊查询
	public PageInfo<SalOrder>xsmh(Integer pageNum, Integer pageSize, SalOrder salOrder);
	//查询销售详情表
	public PageInfo<SalDetails> selectSalDetailsByUid(Integer pageNum, Integer pageSize,Long orderId);
	//出库
	public void updaCcspxx(Ccspxxb ccspxxb,SalOrder p);
}
