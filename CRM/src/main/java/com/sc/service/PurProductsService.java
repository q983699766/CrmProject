package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.PurProducts;

public interface PurProductsService {
	    //查询所有的 库存商品信息
		public List<Ccspxxb> selectCcspxx();
		
		//库存商品信息分页
		public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize);	
		
		//和商品联合查询
		public PageInfo<Ccspxxb> selectproandsp(Integer pageNum, Integer pageSize,Ccspxxb ccspxxb);
		
		//查询所有的 库存商品信息
		public PageInfo<PurProducts> selectpurproducts(Integer pageNum, Integer pageSize);

		
		//通过id查询
		public PurProducts SelectById(Long productId);
		
		//
		public List<PurProducts> selectpurproducts();
		
		public void addpurproducts( PurProducts purproducts);
		
		//根据id删除
		public void delpurproducts(Long productId);	
		
		public void delpurproduct(Long productId);	
		
		
		
		
}
