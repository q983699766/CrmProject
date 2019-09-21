package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeSms;
import com.sc.bean.OfficeSmsExample;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersExample;

public interface HrScheService {
	//查询短消息
	public List<OfficeSms> selectall(OfficeSms sms);

	//查询所有供应商信息
	public PageInfo<OfficeDetailSms> selectByExample(Integer pageNum, Integer pageSize,OfficeSmsExample example,Long userId,String smsHeadline,OfficeSms officeSms);
	
	//查询所有供应商信息
		public PageInfo<OfficeDetailSms> selectreaded(Integer pageNum, Integer pageSize,OfficeSmsExample example,Long userId,OfficeSms officeSms,String read);
		
		
	//通过ID查找公司
	public SysCOMPANY seleCOMById(long comid);
	
	//通过ID查找用户
	public SysUsers seleuserById(long userid);
	
	//通过信息ID查找信息
	public OfficeSms selectById(Long smsId);
	
	//通过信息ID查找信息详情
	public OfficeDetailSms selectdetailsmsById(Long detailId);
	
	//查找全部用户
	public List<SysUsers> selectuserByExample(SysUsersExample example);
	
	
	
	
	//添加信息
	public void addsmsInfo(OfficeSms officeSms);
	
	//添加详细信息
	public void adddetailsms(OfficeDetailSms officeDetailSms);
	
}
