package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SysBranch;
import com.sc.bean.SysComoany;
import com.sc.bean.SysDuty;
import com.sc.bean.SysEmpuser;

public interface SysEmpuserService {
	//查询职务信息
	public  List<SysEmpuser> selectSysEmpuser();
	//删除职务信息
	public void delSysEmpuser(SysEmpuser empId);
	//添加职位信息
	public void addSysEmpuser(SysEmpuser u);
	//查询出修改用户信息
	public SysEmpuser updateSysEmpuser(Long empId);
	//修改用户信息
	public void update(SysEmpuser u);

}
