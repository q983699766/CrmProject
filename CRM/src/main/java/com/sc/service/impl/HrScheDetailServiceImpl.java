package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;
import com.sc.bean.OfficeSms;
import com.sc.bean.OfficeSmsExample;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;
import com.sc.bean.Users;
import com.sc.mapper.OfficeDetailSmsMapper;
import com.sc.mapper.OfficeSmsMapper;
import com.sc.mapper.SysCOMPANYMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.service.HrScheDetailService;

@Service
public class HrScheDetailServiceImpl implements HrScheDetailService {

	@Autowired 
	OfficeDetailSmsMapper officeDetailSmsMapper;
	
	@Autowired 
	SysCOMPANYMapper sysComoanyMapper;
	
	@Autowired 
	SysUsersMapper sysUsersMapper;
	
	@Autowired
	OfficeSmsMapper officeSmsMapper;
	
	@Override
	public List<OfficeDetailSms> selectsmsByExample(OfficeDetailSms OfficeDetailSms) {
		
		
		return this.officeDetailSmsMapper.selectByExample(null);
	}
	
	/*@Override
	public PageInfo<OfficeDetailSms> selectsmsByExample(Integer pageNum, Integer pageSize,OfficeDetailSms OfficeDetailSms) {
		
		//设置开始分页
		PageHelper.startPage(pageNum, pageSize);
		//调用查询所有用户的方法	
		List<OfficeDetailSms> list = this.officeDetailSmsMapper.selectByExample(null);
		//封装list到pageinfo
		PageInfo<OfficeDetailSms> pi=new PageInfo<OfficeDetailSms>(list);
		return pi;
	}*/

	@Override
	public SysCOMPANY seleCOMById(long comid) {
		
		return sysComoanyMapper.selectByPrimaryKey(comid);
	}

	@Override
	public SysUsers seleuserById(long userid) {
		
		return sysUsersMapper.selectByPrimaryKey(userid);
	}

	@Override
	public OfficeSms selesmsById(long smsid) {
		
		return officeSmsMapper.selectByPrimaryKey(smsid);
	}

	@Override
	public int updatesmsById(OfficeDetailSms officeDetailSms) {
		
		return officeDetailSmsMapper.updatestaByKey(officeDetailSms);
	}
	
	
	
		


}
