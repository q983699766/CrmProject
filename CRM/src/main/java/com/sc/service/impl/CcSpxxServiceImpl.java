package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;
import com.sc.bean.Ccspxxb;
import com.sc.bean.CcspxxbExample;
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

	@Override
	public void addCcspxx(Ccspxxb u) {
		// TODO Auto-generated method stub
		
	}

	//分页查询所有
	@Override
	public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
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
	public void delCcspxx(Integer fwid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCcspxx(CcCkxxb u) {
		// TODO Auto-generated method stub
		
	}
}