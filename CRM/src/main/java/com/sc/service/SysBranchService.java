package com.sc.service;

import java.util.List;

import com.sc.bean.SysBranch;

public interface SysBranchService {
	//查询职务信息
	public  List<SysBranch> selectSysBranch();
	//添加信息
	public void addaddBranch(SysBranch u);
	public void delBranch(SysBranch u);
	public SysBranch  selectBranch(Long secId);
	public void  upBranch(SysBranch u);
}
