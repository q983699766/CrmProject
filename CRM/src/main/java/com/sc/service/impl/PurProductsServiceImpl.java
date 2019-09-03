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
import com.sc.mapper.CcspxxbMapper;
import com.sc.mapper.PurProductsMapper;
import com.sc.service.PurProductsService;

import net.bytebuddy.asm.Advice.Return;

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
	@Override
	public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
		List<Ccspxxb> list = ccspxxbmapper.selectByExample(example);
		PageInfo<Ccspxxb> pi = new PageInfo<Ccspxxb>(list);
		return pi;
	}
	
	

}
