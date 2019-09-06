package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.CcspxxbExample;
import com.sc.bean.PurSupInfo;
import com.sc.bean.PurSupInfoExample;
import com.sc.bean.PurSupInfoExample.Criteria;
import com.sc.mapper.CcspxxbMapper;
import com.sc.service.CcSpxxService;
@Service
public class CcSpxxServiceImpl implements CcSpxxService {

	@Autowired
	CcspxxbMapper ccspxxbMapper;

	@Override
	public List<Ccspxxb> selectCcspxx() {
		// TODO Auto-generated method stub
		return null;
	}

	//添加
	@Override
	public void addCcspxx(Ccspxxb u) {
		
		if(u!=null){
			this.ccspxxbMapper.insert(u);
			
		}
	
	}

	//分页查询所有
	@Override
	public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
		example.setOrderByClause("PRODUCT_ID DESC");
		List<Ccspxxb> list = ccspxxbMapper.selectByExample(example);
		PageInfo<Ccspxxb> pi = new PageInfo<Ccspxxb>(list);
		return pi;
	}

	@Override
	public PageInfo<Ccspxxb> selectCcspxxByUid(Integer pageNum, Integer pageSize, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delCcspxx(Long productId) {
		
		this.ccspxxbMapper.deleteByPrimaryKey(productId);
	}

	@Override
	public void updateCcspxx(Ccspxxb u) {
		// TODO Auto-generated method stub
		
	}

	//模糊查询
	@Override
	public PageInfo<Ccspxxb> selectall(Integer pageNum, Integer pageSize, Ccspxxb ccspxx) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
		example.setOrderByClause("PRODUCT_ID DESC");
		if(ccspxx.getSpMc()!=null){
			com.sc.bean.CcspxxbExample.Criteria criteria = example.createCriteria();
			criteria.andSpMcLike("%"+ccspxx.getSpMc()+"%");
			
		}
		
		if(ccspxx.getSpLb()!=null){
			com.sc.bean.CcspxxbExample.Criteria criteria = example.createCriteria();
			criteria.andSpLbLike("%"+ccspxx.getSpLb()+"%");
			
		}
		
		List<Ccspxxb> list = ccspxxbMapper.selectByExample(example);
		PageInfo<Ccspxxb> pi = new PageInfo<Ccspxxb>(list);
		return pi;
	}

		

	
	
	
	
}