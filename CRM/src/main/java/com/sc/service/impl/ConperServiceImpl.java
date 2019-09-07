package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.SalConper;
import com.sc.bean.SalConperExample;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SalCustomInfoExample;
import com.sc.bean.SalCustomInfoExample.Criteria;
import com.sc.mapper.SalConperMapper;
import com.sc.mapper.SalCustomInfoMapper;
import com.sc.service.ConperService;

@Service
public class ConperServiceImpl implements ConperService {

	@Autowired
	SalCustomInfoMapper salCustomInfoMapper;
	@Autowired
	SalConperMapper  salConperMapper;
	
	//分页查询用户信息
	@Override
	public PageInfo<SalCustomInfo> selectSalCustomInfoPage(Integer pageNum, Integer pageSize,SalCustomInfo sal) {
		PageHelper.startPage(pageNum,pageSize);
		SalCustomInfoExample example=new SalCustomInfoExample();
		if(sal!=null&&sal.getCustomName()!=null){
		
		Criteria criteria = example.createCriteria();
		criteria.andCustomNameLike("%"+sal.getCustomName()+"%");
		/*criteria.andEmailEqualTo(sal.getEmail());
		criteria.andCellPhoneEqualTo(sal.getCellPhone());*/
		}
		List<SalCustomInfo> list = salCustomInfoMapper.selectByExample(example);
		PageInfo<SalCustomInfo> pi = new PageInfo<SalCustomInfo>(list);
		return pi;
	}
	
	//通过id查询用户信息
	@Override
	public SalCustomInfo selectById(Long customId) {
	
		return salCustomInfoMapper.selectByPrimaryKey(customId);
	}
	
	//添加用户信息
	@Override
	public void addSalCustomInfo(SalCustomInfo sal) {
		if(sal!=null){
			this.salCustomInfoMapper.insert(sal);
		}
			
	}

	//删除用户信息
	@Override
	public void delSalCustomInfo(SalCustomInfo sal) {
	
		if(sal!=null&&sal.getCustomId()!=null){
			this.salCustomInfoMapper.deleteByPrimaryKey(sal.getCustomId());
		}
		
	}

	//修改用户信息
	@Override
	public void updateSalCustomInfo(SalCustomInfo sal) {
	
		if(sal!=null){
			this.salCustomInfoMapper.updateByPrimaryKey(sal);
		}
	}

	//根据客户ID查询出对应的联系人信息
	@Override
	public List<SalConper> selectconperById(Long customId) {
		
		SalConperExample example = new SalConperExample();
		com.sc.bean.SalConperExample.Criteria criteria = example.createCriteria();
		criteria.andCustomIdEqualTo(customId);
		List<SalConper> list = salConperMapper.selectByExample(example);
		return list;
	}

	@Override
	public void addSalConper(SalConper con) {
		if(con!=null){
			this.salConperMapper.insert(con);
		}
		
	}

	@Override
	public void updateSalConper(SalConper con) {
		if(con!=null){
			this.salConperMapper.updateByPrimaryKey(con);
		}
		
	}

	@Override
	public SalConper selectSalConperById(Long conperId) {
		
		return this.salConperMapper.selectByPrimaryKey(conperId);
	}

	@Override
	public void delSalConper(SalConper con) {
		if(con!=null&&con.getConperId()!=null){
			this.salConperMapper.deleteByPrimaryKey(con.getConperId());
		}
		
	}


	
	
	


}
