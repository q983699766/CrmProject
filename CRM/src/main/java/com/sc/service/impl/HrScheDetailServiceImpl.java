package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;
import com.sc.bean.OfficeSms;
import com.sc.bean.OfficeSmsExample;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;
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
	public List<OfficeDetailSms> selectsmsByExample(OfficeDetailSmsExample example) {
		
		return this.officeDetailSmsMapper.selectByExample(null);
	}

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
