package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeSms;
import com.sc.bean.OfficeSmsExample;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersExample;
import com.sc.mapper.OfficeDetailSmsMapper;
import com.sc.mapper.OfficeSmsMapper;
import com.sc.mapper.SysCOMPANYMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.service.HrScheService;

@Service
public class HrScheServiceImpl implements HrScheService{

	@Autowired
	OfficeSmsMapper officeSmsMapper;
	
	@Autowired 
	SysCOMPANYMapper sysComoanyMapper;
	
	@Autowired 
	SysUsersMapper sysUsersMapper;
	
	@Autowired
	OfficeDetailSmsMapper officeDetailSmsMapper;
	
	//查询所有
	@Override
	public List<OfficeSms> selectByExample(OfficeSmsExample example) {
		
		return this.officeSmsMapper.selectByExample(null);
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
	public List<OfficeSms> selectall(OfficeSms sms) {
		
		return null;
	}

	@Override
	public OfficeSms selectById(Long smsId) {
		
		return officeSmsMapper.selectByPrimaryKey(smsId);
	}

	@Override
	public void addsmsInfo(OfficeSms officeSms) {
		
			this.officeSmsMapper.insert(officeSms);

	}

	@Override
	public void adddetailsms(OfficeDetailSms officeDetailSms) {
		
		this.officeDetailSmsMapper.insert(officeDetailSms);
	}

	@Override
	public List<SysUsers> selectuserByExample(SysUsersExample example) {
		
		return this.sysUsersMapper.selectByExample(null);
	}
}
