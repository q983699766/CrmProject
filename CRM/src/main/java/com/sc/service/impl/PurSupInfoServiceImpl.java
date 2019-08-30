package com.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.mapper.PurSupInfoMapper;
import com.sc.service.PurSupInfoService;

@Service
public class PurSupInfoServiceImpl implements PurSupInfoService {

	@Autowired
	PurSupInfoMapper purSupInfoMapper;
	 
	@Override
	public void SelectById(Integer supInfoNum) {
		if(supInfoNum!=null){
			 this.purSupInfoMapper.selectByPrimaryKey(supInfoNum);
		}
		
	}

	@Override
	public void SelectAll()
	{
		this.purSupInfoMapper.selectByExample(null);
		
	}

	@Override
	public void addinfo(Integer supInfoNum) {
		
		
	}

	@Override
	public void delinfo(Integer supInfoNum) {
		if(supInfoNum!=null)
		{
			this.purSupInfoMapper.deleteByPrimaryKey(supInfoNum);
		}
	}

	@Override
	public void updateinfo(Integer supInfoNum) {
		if(supInfoNum!=null)
		{
			this.purSupInfoMapper.updateByPrimaryKey(supInfoNum);
		}
	}

	
}
