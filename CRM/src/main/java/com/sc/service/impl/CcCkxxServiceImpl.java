package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;
import com.sc.bean.CcCkxxbExample;
import com.sc.mapper.CcCkxxbMapper;
import com.sc.service.CcCkxxbService;
@Service
public class CcCkxxServiceImpl implements CcCkxxbService {

	@Autowired
	CcCkxxbMapper CcCkxxbMapper ;
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

	@Override
	public PageInfo<CcCkxxb> selectCcCkxxbByUid(Long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	//删除
	@Override
	public void delCcCkxx(Long uid) {
		this.CcCkxxbMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public void updateCcCkxx(CcCkxxb u) {
		// TODO Auto-generated method stub

	}

}
