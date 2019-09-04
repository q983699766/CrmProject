package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysComoany;
import com.sc.mapper.SysCOMPANYMapper;
import com.sc.mapper.SysComoanyMapper;
import com.sc.service.SysComPanyService;


@Service
public class SysComPanyServiceImpl implements SysComPanyService {

@Autowired
SysCOMPANYMapper  sysCOMPANYMapper;
	@Override
	public List<SysCOMPANY> selectComoany() {
	
		return this.sysCOMPANYMapper.selectByExample(null);
	}

	@Override
	public void delComoany(SysCOMPANY u) {
		this.sysCOMPANYMapper.deleteByPrimaryKey(u.getComId());
		
	}

	@Override
	public void addComoany(SysCOMPANY u) {
	this.sysCOMPANYMapper.insert(u);
		
	}

	@Override
	public SysCOMPANY updateComoany(Long comId) {
		return this.sysCOMPANYMapper.selectByPrimaryKey(comId);
	}

	@Override
	public void upComoany(SysCOMPANY u) {
		this.sysCOMPANYMapper.updateByPrimaryKey(u);
		
	}

	
}
