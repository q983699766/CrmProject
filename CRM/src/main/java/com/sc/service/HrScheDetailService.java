package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;
import com.sc.bean.OfficeSms;
import com.sc.bean.PurSupInfo;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;



public interface HrScheDetailService {

	//查询所有信息详情
	public PageInfo<OfficeDetailSms> selectsmsByExample(Integer pageNum, Integer pageSize,OfficeDetailSms OfficeDetailSms,String smsHeadline,Long smssend,OfficeSms officeSms);
	
	
	//通过ID查找公司
			public SysCOMPANY seleCOMById(long comid);
			
			//通过ID查找用户
			public SysUsers seleuserById(long userid);
			
			//通过ID查找信息
			public OfficeSms selesmsById(long smsid);
			
			//通过ID更改状态
			public int updatesmsById(OfficeDetailSms officeDetailSms);
			
			//通过ID删除detailsms
			public void deldetailsmsInfo(OfficeDetailSms officeDetailSms);
			
			//通过ID删除detailsms
			public void deldetailsmsbyid(long detailid);
			
			//通过ID查找详细信息
			public OfficeDetailSms selesmsBybean(OfficeDetailSms officeDetailSms);
			
			//通过ID查找详细信息
			public OfficeDetailSms selesmsByid(long detailid);
			
			//通过ID删除sms
			public void delsmsInfo(long smsid);
			
			//通过id修改供应商信息
			public void updatestate(OfficeDetailSms officeDetailSms);
}
