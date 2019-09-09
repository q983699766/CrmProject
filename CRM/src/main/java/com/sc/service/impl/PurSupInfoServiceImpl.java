package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.PurSupInfo;
import com.sc.bean.PurSupInfoExample;
import com.sc.bean.PurSupInfoExample.Criteria;
import com.sc.mapper.PurSupInfoMapper;
import com.sc.service.PurSupInfoService;

@Service
public class PurSupInfoServiceImpl implements PurSupInfoService {

	@Autowired
	PurSupInfoMapper purSupInfoMapper;

	 //id查询
	@Override
	public PurSupInfo SelectById(Long supinfonum) {
		
		return purSupInfoMapper.selectByPrimaryKey(supinfonum);
	}

	//查询所有
	@Override
	public PageInfo<PurSupInfo> selectall(Integer pageNum,Integer pageSize ,PurSupInfo pursupinfo) {
		   //设置开始分页
			PageHelper.startPage(pageNum, pageSize);
			PurSupInfoExample example = new PurSupInfoExample();
			if(pursupinfo.getSupInfoNum()!=null){
				Criteria criteria = example.createCriteria();
				criteria.andSupInfoNumEqualTo(pursupinfo.getSupInfoNum());
			}
			if(pursupinfo.getSupName()!=null){
				Criteria criteria = example.createCriteria();
				criteria.andSupNameLike("%"+pursupinfo.getSupName()+"%");
			}
			if(pursupinfo.getSupUname()!=null){
				Criteria criteria = example.createCriteria();
				criteria.andSupUnameLike("%"+pursupinfo.getSupUname()+"%");
			}
			if(pursupinfo.getContacts()!=null){
				Criteria criteria = example.createCriteria();
				criteria.andContactsLike("%"+pursupinfo.getContacts()+"%");
			}
			//调用查询所有的方法
			List<PurSupInfo> list=this.purSupInfoMapper.selectByExample(example);
			//封装LIST到pageinfo
			PageInfo<PurSupInfo> pi = new PageInfo<PurSupInfo>(list);
			
			return pi;
		}

	//添加
	@Override
	public void addinfo(PurSupInfo pursupinfo) {
	  if(pursupinfo!=null){
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
			this.purSupInfoMapper.updateByPrimaryKey(pursupinfo);
		}
	}



	
}
