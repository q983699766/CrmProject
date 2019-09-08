package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;
import com.sc.bean.CcCkxxbExample;
import com.sc.bean.Ccspxxb;
import com.sc.bean.CcspxxbExample;
import com.sc.bean.CcspxxbExample.Criteria;
import com.sc.mapper.CcCkxxbMapper;
import com.sc.mapper.CcspxxbMapper;
import com.sc.service.CcCkxxbService;
@Service
public class CcCkxxServiceImpl implements CcCkxxbService {

	@Autowired
	CcCkxxbMapper CcCkxxbMapper ;
	
	@Autowired
	CcspxxbMapper ccspxxbMapper;
	//添加
	@Override
	public void addCcCkxx(CcCkxxb u) {
		
		if(u!=null)
		this.CcCkxxbMapper.insert(u);
	}

	//分页查询所有
	@Override
	public PageInfo<CcCkxxb> selectCcCcxxPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		CcCkxxbExample example = new CcCkxxbExample();
		example.setOrderByClause("CK_BH DESC");
		List<CcCkxxb> list = CcCkxxbMapper.selectByExample(example);
		PageInfo pi = new PageInfo(list);	
		return pi;
	}

	//通过id查询
	@Override
	public CcCkxxb selectCcCkxxbByUid(Long ckBh) {
		
		return CcCkxxbMapper.selectByPrimaryKey(ckBh);
				
	}

	//删除
	@Override
	public void delCcCkxx(Long uid) {
		this.CcCkxxbMapper.deleteByPrimaryKey(uid);
		
	}

	//修改
	@Override
	public void updateCcCkxx(CcCkxxb u) {
		if(u!=null&&u.getCkBh()!=null){
			CcCkxxbMapper.updateByPrimaryKey(u);
			
		}
	}

	@Override
	public PageInfo<Ccspxxb> selectbyckidPage(Integer pageNum, Integer pageSize, Long ckBh) {
		
			CcspxxbExample example = new CcspxxbExample();
			Criteria criteria = example.createCriteria();
			criteria.andCkBhEqualTo(ckBh);
			List <Ccspxxb> list = ccspxxbMapper.selectByExample(example);
			PageInfo pi = new PageInfo(list);
			System.out.println("3333333"+pi);
			return pi;
		}

		
	





}
