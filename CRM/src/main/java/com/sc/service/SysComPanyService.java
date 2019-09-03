package com.sc.service;

import java.util.List;

import com.sc.bean.SysBranch;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysComoany;
import com.sc.bean.SysDuty;

public interface SysComPanyService {
	//查询公司信息
	public  List<SysCOMPANY> selectComoany();
	//删除公司信息
	public  void delComoany(SysCOMPANY u);
	//添加公司信息
	public  void addComoany(SysCOMPANY u);
	//查询要修改的公司信息
	public SysCOMPANY updateComoany(Long comId);
	//修改公司信息
	public void upComoany(SysCOMPANY u);
}
