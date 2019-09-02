package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysBranch;
import com.sc.bean.SysComoany;
import com.sc.bean.SysDuty;
import com.sc.mapper.SysBranchMapper;
import com.sc.mapper.SysComoanyMapper;
import com.sc.mapper.SysDutyMapper;
import com.sc.service.SysDutyService;


@Service
public class SysDutyServiceImpl implements SysDutyService {

	@Autowired
	SysDutyMapper sysdutymapper;
	
	@Autowired
	SysBranchMapper sysBranchMapper;

	@Autowired
	SysComoanyMapper sysComoanyMapper;
	@Override
	public List<SysDuty> selectDuty() {
	
		return this.sysdutymapper.selectByExample(null);
	}

	@Override
	public void delduty(SysDuty dutId) {
	this.sysdutymapper.deleteByPrimaryKey(dutId.getDutId());
	}

	@Override
	public void upadtaduty(SysDuty u) {
		this.sysdutymapper.insert(u);
		
	}

	@Override
	public SysDuty update(Long dutId) {
		
		 return this.sysdutymapper.selectByPrimaryKey(dutId);
	}

	@Override
	public void updatee(SysDuty u) {
		
		 this.sysdutymapper.updateByPrimaryKey(u);
		
	}

	@Override
	public List<SysBranch> selesetSysBranch() {
		
		return this.sysBranchMapper.selectByExample(null);
	}

	@Override
	public List<SysComoany> selectSysComoany() {
		
		return this.sysComoanyMapper.selectByExample(null);
	}
	
	
}
