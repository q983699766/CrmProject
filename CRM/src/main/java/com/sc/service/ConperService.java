package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SalBleed;
import com.sc.bean.SalConper;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SalFeedback;
import com.sc.bean.SalRecord;


public interface ConperService {

	//分页查询所有客户信息
	
	public PageInfo<SalCustomInfo> selectSalCustomInfoPage(Integer pageNum, Integer pageSize,SalCustomInfo sal);
	public PageInfo<SalCustomInfo> selectSalCustomInfoMessage(Integer pageNum, Integer pageSize,String message);
	//根据ID查询客户所有信息
	public SalCustomInfo selectById(Long customId);
	//添加客户信息
	public void addSalCustomInfo(SalCustomInfo sal);
	//删除客户信息
	public void delSalCustomInfo(SalCustomInfo sal);
	//通过ID删除客户信息
	public void delAll(Long customId);
	
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
	
	//根据客户ID查询当前联系人的信息
	public SalConper selectSalConperById(Long customId);
	
	//删除联系人信息
	public void delSalConper(SalConper con);
	
	//根据客户ID查询出所有联系记录
	public List<SalRecord> selectrecordById(Long customId);
	
	//根据联系人ID查询当前联系人的信息
	public SalConper selectSalConById(Long conperId);
	
	//添加联系记录
	public void addSalRecord(SalRecord rec);
	
	//删除联系记录
	public void delSalRecord(SalRecord rec);
	
	//根据客户ID分页查询客户反馈记录
	public PageInfo<SalFeedback> selectSalFeedbackById(Integer pageNum, Integer pageSize,Long customId);
	
	//根据记录优先级分页查询客户反馈记录
	public PageInfo<SalFeedback> selectSalFeedbackByPri(Integer pageNum, Integer pageSize,String pri);

	//根据反馈记录ID分页查询客户反馈记录
	public SalFeedback selectSalFeedById(Long feedbackId);
	
	//添加反馈记录
	public void addSalFeedback(SalFeedback feedback);
	
	//删除反馈记录
	public void delSalFeedback(SalFeedback feedback);
	
	//分页查询所有暂缓流失客户的信息
	public PageInfo<SalCustomInfo> selectLosePage(Integer pageNum, Integer pageSize,SalCustomInfo sal);
	public PageInfo<SalCustomInfo> selectLoseMessage(Integer pageNum, Integer pageSize,String message);
	
	//添加流失操作信息
	public void  addSalBleed(SalBleed bleed);
	//通过流失主键找出当前客户信息
	public SalBleed selectByBleedId(Long churnId);
	//通过客户ID找出一条流失情况
	public SalBleed selectByCustomId(Long customId);	
	//修改流失情况
	public void updateSalBleed(SalBleed bleed);
	

	
}
