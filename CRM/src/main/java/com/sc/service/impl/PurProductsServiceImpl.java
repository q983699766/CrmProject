package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.CcspxxbExample;
import com.sc.bean.PurProducts;
import com.sc.mapper.CcspxxbMapper;
import com.sc.mapper.PurProductsMapper;
import com.sc.service.PurProductsService;

@Service
public class PurProductsServiceImpl implements PurProductsService {

	@Autowired
	PurProductsMapper purproductsmapper;
	@Autowired
	CcspxxbMapper ccspxxbmapper;

	@Override
	public List<Ccspxxb> selectCcspxx() {
		// TODO Auto-generated method stub
		return null;
	}
	//查询库存所有信息
	@Override
	public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
		List<Ccspxxb> list = ccspxxbmapper.selectByExample(example);
		PageInfo<Ccspxxb> pi = new PageInfo<Ccspxxb>(list);
		return pi;
	}
	/*@Override
	public PageInfo<Ccspxxb> selectproandsp(Integer pageNum, Integer pageSize,Ccspxxb ccspxxb) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
		Criteria criteria = example.createCriteria();
		if(criteria.andKcSlLessThan(null)){
			
		}
		
		List<Ccspxxb> list = ccspxxbmapper.selectByExample(example);
		PageInfo<Ccspxxb> pi = new PageInfo<Ccspxxb>(list);
		return pi;
	}
	*/
	@Override
	public PageInfo<Ccspxxb> selectproandsp(Integer pageNum, Integer pageSize, Ccspxxb ccspxxb) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//查询代采购列表的方法
	@Override
	public PageInfo<PurProducts> selectpurproducts(Integer pageNum, Integer pageSize) {
		 System.out.println("wo lai l ");
		 PageHelper.startPage(pageNum,pageSize);
		
		 List<PurProducts> list = purproductsmapper.selectByExample(null);
	
		 PageInfo<PurProducts> pi = new PageInfo<PurProducts>(list);
		 return pi;
		
	}
	@Override
	public PurProducts SelectById(Long productId) {
		// TODO Auto-generated method stub
		return purproductsmapper.selectByid(productId);
	}
	@Override
	public List<PurProducts> selectpurproducts() {
		
		return purproductsmapper.selectByExample(null);
	}
	
	
	
	@Override
	public void addpurproducts( PurProducts purproducts) {
		purproductsmapper.insert(purproducts);
	}

	

}
