package com.sc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.CcspxxbExample;
import com.sc.mapper.CcspxxbMapper;
import com.sc.service.CcSpxxService;
import com.sc.bean.CcspxxbExample.Criteria ;
@Service
public class CcSpxxServiceImpl implements CcSpxxService {

	@Autowired
	CcspxxbMapper ccspxxbMapper;

	@Override
	public List<Ccspxxb> selectCcspxx() {
		// TODO Auto-generated method stub
		
		return ccspxxbMapper.selectByExample(null);
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
	public void delCcspxx(Long productId) {
		
		this.ccspxxbMapper.deleteByPrimaryKey(productId);
	}

	//通过id查询
	@Override
	public Ccspxxb selectCcspxxByUid(Long productId) {
		return ccspxxbMapper.selectByPrimaryKey(productId);
			
	}


	//修改
	@Override
	public void updateCcspxx(Ccspxxb u) {
		if(u!=null&&u.getProductId()!=null){
			this.ccspxxbMapper.updateByPrimaryKey(u);
		}
		
	}

	//模糊查询
	@Override
	public PageInfo<Ccspxxb> selectmh(Integer pageNum, Integer pageSize, Ccspxxb ccspxx) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
		//example.setOrderByClause("PRODUCT_ID DESC");
		if(ccspxx.getSpMc()!=null){
			Criteria criteria = example.createCriteria();
			criteria.andSpMcLike("%"+ccspxx.getSpMc()+"%");
			
		}
			
		List<Ccspxxb> list = ccspxxbMapper.selectByExample(example);
		PageInfo<Ccspxxb> pi = new PageInfo<Ccspxxb>(list);
		return pi;
	}

			

	
	
	
	
}