package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysEmpuser;
import com.sc.mapper.SysEmpuserMapper;
import com.sc.service.SysEmpuserService;


@Service
public class SysEmpuserServiceImpl implements SysEmpuserService {

	@Autowired
	SysEmpuserMapper sysEmpuserMapper;

	@Override
	public List<SysEmpuser> selectSysEmpuser() {
		return this.sysEmpuserMapper.selectByExample(null);
	}

	@Override
	public void delSysEmpuser(SysEmpuser empId) {
		this.sysEmpuserMapper.deleteByPrimaryKey(empId.getEmpId());
		
	}

	@Override
	public void addSysEmpuser(SysEmpuser u) {
		this.sysEmpuserMapper.insert(u);
		
	}

	@Override
	public SysEmpuser updateSysEmpuser(Long empId) {
		
		return this.sysEmpuserMapper.selectByPrimaryKey(empId);
	}

	@Override
	public void update(SysEmpuser u) {
	this.sysEmpuserMapper.updateByPrimaryKey(u);
		
	}

	
}
