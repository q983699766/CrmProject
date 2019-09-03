package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.PurSupInfo;
import com.sc.bean.PurSupInfoExample;
import com.sc.mapper.PurSupInfoMapper;
import com.sc.service.PurSupInfoService;

@Service
public class PurSupInfoServiceImpl implements PurSupInfoService {

	@Autowired
	PurSupInfoMapper purSupInfoMapper;

	 //id查询
	@Override
	public PurSupInfo SelectById(Long supinfonum) {
		if(supinfonum!=null){
			purSupInfoMapper.selectByPrimaryKey(supinfonum);
		}
		return null;
	}

	//查询所有
	@Override
	public List<PurSupInfo> selectByExample(PurSupInfoExample example) {
		return this.purSupInfoMapper.selectByExample(null); //空对象代表查所有，
	}

	//添加
	@Override
	public void addinfo(PurSupInfo pursupinfo) {
	if(pursupinfo.getSupInfoNum()!=null){
		this.purSupInfoMapper.insert(pursupinfo);
	   }
	}

	 //id删除
	@Override
	public void delinfo(Long supinfonum) {
		if(supinfonum!=null){
		this.purSupInfoMapper.deleteByPrimaryKey(supinfonum);
	}
	}

	 //id更新
	@Override
	public void updateinfo(PurSupInfo pursupinfo) {
		if(pursupinfo!=null&&pursupinfo.getSupInfoNum()!=null){
			this.purSupInfoMapper.updateByPrimaryKey(pursupinfo.getSupInfoNum());
		}
	}


	@Override
	public void updateinfo(Long supInfoNum) {
		if(supInfoNum!=null){
			this.purSupInfoMapper.updateByPrimaryKey(supInfoNum);
		}
		
	}
	 


	
}
