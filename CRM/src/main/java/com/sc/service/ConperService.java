package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SalConper;
import com.sc.bean.SalCustomInfo;


public interface ConperService {

	//分页查询所有客户信息
	
	public PageInfo<SalCustomInfo> selectSalCustomInfoPage(Integer pageNum, Integer pageSize,SalCustomInfo sal);
	
	//根据ID查询客户所有信息
	public SalCustomInfo selectById(Long customId);
	//添加客户信息
	public void addSalCustomInfo(SalCustomInfo sal);
	//删除客户信息
	public void delSalCustomInfo(SalCustomInfo sal);
	//修改用户信息
	public void updateSalCustomInfo(SalCustomInfo sal);
	
	//根据客户ID查询联系人
	public List<SalConper> selectconperById(Long customId);
	
	/*//分页查询所有联系人信息
	public PageInfo<SalConper> selectSalConper(Integer pageNum, Integer pageSize,SalConper con);*/
	
	//添加联系人信息
	public void addSalConper(SalConper con);
	
	//修改联系人信息
	public void updateSalConper(SalConper con);
	
	//根据联系人ID查询当前联系人的信息
	public SalConper selectSalConperById(Long conperId);
	
	//删除联系人信息
	public void delSalConper(SalConper con);

}
