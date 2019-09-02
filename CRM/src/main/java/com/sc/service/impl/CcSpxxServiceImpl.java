package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;
import com.sc.bean.CcCkxxbExample;
import com.sc.bean.Ccspxxb;
import com.sc.mapper.CcCkxxbMapper;
import com.sc.service.CcSpxxService;
@Service
public class CcSpxxServiceImpl implements CcSpxxService {

	@Autowired
	CcCkxxbMapper ccCkxxbMapper;
	@Override
	public List<CcCkxxb> selectCcspxx() {
		
		return null;
	}

	
	@Override
	public void addCcspxx(CcCkxxb u) {
		// TODO Auto-generated method stub

	}
	//商品信息分页
	@Override
	public PageInfo<CcCkxxb> selectCcspxxPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		CcCkxxbExample example = new CcCkxxbExample();
		List<CcCkxxb> list = ccCkxxbMapper.selectByExample(example);
		PageInfo<CcCkxxb> pi = new PageInfo<CcCkxxb>(list);
		return pi;
	}

	@Override
	public PageInfo<CcCkxxb> selectCcspxxByUid(Integer pageNum, Integer pageSize, Integer uid) {
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
