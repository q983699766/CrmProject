package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.PurSupInfo;

public interface PurSupInfoService {
    
	//通过供应商编号查询
	public PurSupInfo SelectById(Long supinfonum);
	
	//查询所有供应商信息分页
	public PageInfo<PurSupInfo> selectall(Integer pageNum,Integer pageSize,PurSupInfo pursupinfo);
	//添加供应商信息
	public void addinfo(PurSupInfo pursupinfo);
	//通过id删除供应商信息
	public void delinfo(Long supinfonum);
	//通过id修改供应商信息
	public void updateinfo(PurSupInfo pursupinfo);
	
	




		

}
