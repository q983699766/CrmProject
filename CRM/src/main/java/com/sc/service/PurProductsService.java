package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;
import com.sc.bean.Ccspxxb;

public interface PurProductsService {
	//查询所有的 库存商品信息
		public List<Ccspxxb> selectCcspxx();
		
		//库存商品信息分页
		public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize);	
		
		//和商品联合查询
		public PageInfo<Ccspxxb> selectproandsp(Integer pageNum, Integer pageSize,Ccspxxb ccspxxb);

		
}
