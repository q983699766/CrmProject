package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.SysBranch;
import com.sc.bean.SysComoany;
import com.sc.bean.SysDuty;
import com.sc.mapper.SysBranchMapper;
import com.sc.mapper.SysComoanyMapper;
import com.sc.mapper.SysDutyMapper;
import com.sc.service.SysBranchService;
import com.sc.service.SysDutyService;


@Service
public class SysBranchServiceImpl implements SysBranchService {

	@Autowired
	SysBranchMapper sysBranchMapper;

	@Override
	public List<SysBranch> selectSysBranch() {
		return this.sysBranchMapper.selectByExample(null);
	}

	@Override
	public void addaddBranch(SysBranch u) {
		this.sysBranchMapper.insert(u);
		
	}

	@Override
	public void delBranch(SysBranch u) {
	this.sysBranchMapper.deleteByPrimaryKey(u.getSecId());
		
	}

	@Override
	public SysBranch selectBranch(Long secId) {
	
		return this.sysBranchMapper.selectByPrimaryKey(secId);
	}

	@Override
	public void upBranch(SysBranch u) {
	this.sysBranchMapper.updateByPrimaryKey(u);
	}
	
}
