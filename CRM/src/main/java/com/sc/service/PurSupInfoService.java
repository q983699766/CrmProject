package com.sc.service;

import java.util.List;

import com.sc.bean.PurOrderInfo;
import com.sc.bean.PurSupInfo;
import com.sc.bean.PurSupInfoExample;
import com.sc.bean.SysUsers;

public interface PurSupInfoService {
    
	//通过供应商编号查询
	public PurSupInfo SelectById(Long supinfonum);
	
	//查询所有供应商信息
	public List<PurSupInfo> selectByExample(PurSupInfoExample example);
	//添加供应商信息
	public void addinfo(PurSupInfo pursupinfo);
	//通过id删除供应商信息
	public void delinfo(Long supinfonum);
	//通过id修改供应商信息
	public void updateinfo(PurSupInfo pursupinfo);






	




		

}
