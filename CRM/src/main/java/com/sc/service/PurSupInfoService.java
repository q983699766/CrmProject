package com.sc.service;

import com.sc.bean.PurOrderInfo;
import com.sc.bean.SysUsers;

public interface PurSupInfoService {
    
	//通过供应商编号查询
	public void SelectById(Integer supInfoNum);
	
	//查询所有供应商信息
	public void SelectAll();
	//添加供应商信息
	public void addinfo(Integer supInfoNum);
	//删除供应商信息
	public void delinfo(Integer supInfoNum);
	//修改供应商信息
	public void updateinfo(Integer supInfoNum );
		

}
