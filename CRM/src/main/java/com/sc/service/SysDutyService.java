package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SysBranch;
import com.sc.bean.SysComoany;
import com.sc.bean.SysDuty;

public interface SysDutyService {
	//查询职务信息
	public  List<SysDuty> selectDuty();
	//删除职务信息
	public void delduty(SysDuty dutId);
	//添加职位信息
	public void upadtaduty(SysDuty u);
	//查询出修改用户信息
	public SysDuty update(Long dutId);
	//修改用户信息
	public void updatee(SysDuty u);
	
	public PageInfo<SysDuty> selectUsersPage
	(Integer pageNum,Integer pageSize,SysDuty u);
	
	public  List<SysBranch> selesetSysBranch();
	
	public  List<SysComoany> selectSysComoany();
	

}
