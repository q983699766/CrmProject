package com.sc.service;

import java.util.List;

import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;
import com.sc.bean.OfficeSms;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;



public interface HrScheDetailService {

	//查询所有信息详情
	public List<OfficeDetailSms> selectsmsByExample(OfficeDetailSms OfficeDetailSms);
	
	
	//通过ID查找公司
			public SysCOMPANY seleCOMById(long comid);
			
			//通过ID查找用户
			public SysUsers seleuserById(long userid);
			
			//通过ID查找信息
			public OfficeSms selesmsById(long smsid);
			
			//通过ID更改状态
			public int updatesmsById(OfficeDetailSms officeDetailSms);
			
			
}
