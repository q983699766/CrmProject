package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SysLog;

public interface SysLogService {
	//分页查询系统日志
	public PageInfo<SysLog> showSysLog(Integer pageNum,Integer pageSize);
	
	//根据url查询权限名称
	public String getPermissionName(String url);
	
	//插入一条日志
	public void insertSysLog(SysLog log);
	
	//查询全部系统日志
	public List<SysLog> sysLog();
}
