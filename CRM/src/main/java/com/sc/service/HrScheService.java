package com.sc.service;

import java.util.List;

import com.sc.bean.OfficeSms;
import com.sc.bean.OfficeSmsExample;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;

public interface HrScheService {
	//查询短消息
	public List<OfficeSms> selectall(OfficeSms sms);

	//查询所有供应商信息
	public List<OfficeSms> selectByExample(OfficeSmsExample example);
	
	//通过ID查找公司
	public SysCOMPANY seleCOMById(long comid);
	
	//通过ID查找用户
	public SysUsers seleuserById(long userid);
	
	
	
	
	
}
