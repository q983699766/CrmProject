package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.SysLog;
import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionExample;
import com.sc.bean.SysPermissionExample.Criteria;
import com.sc.mapper.SysCOMPANYMapper;
import com.sc.mapper.SysLogMapper;
import com.sc.mapper.SysPermissionMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.service.SysLogService;

@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	SysLogMapper slm;
	
	@Autowired
	SysCOMPANYMapper scm;
	
	@Autowired
	SysUsersMapper sum;
	
	@Autowired
	SysPermissionMapper spm;
	
	@Override
	public PageInfo<SysLog> showSysLog(Integer pageNum,Integer pageSize) {
		String orderby ="ACCESS_TIME desc";
		PageHelper.startPage(pageNum, pageSize,orderby);
		List<SysLog> selectByExample = slm.selectByExample(null);
		PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(selectByExample);
		List<SysLog> list = pageInfo.getList();
		for (SysLog sysLog : list) {
			sysLog.setCompany(scm.selectByPrimaryKey(sysLog.getComId()));
			sysLog.setUser(sum.selectByPrimaryKey(sysLog.getUserId()));
		}
		pageInfo.setList(list);
		return pageInfo;
	}

	@Override
	public String getPermissionName(String url) {
		SysPermissionExample sysPermissionExample = new SysPermissionExample();
		Criteria qbc = sysPermissionExample.createCriteria();
		qbc.andPermissionEqualTo(url);
		List<SysPermission> selectByExample = spm.selectByExample(sysPermissionExample);
		if(selectByExample.size() > 0)return selectByExample.get(0).getPermissionName();
		return "null";
	}

	@Override
	public void insertSysLog(SysLog log) {
		if(log != null){
			slm.insert(log);
		}
	}

}
