package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import com.sc.service.HrScheDetailService;
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
	
	@Autowired
	HrScheDetailService hrScheDetailService;
	
	//查询所有
	@Override
	public PageInfo<OfficeDetailSms> selectByExample(Integer pageNum, Integer pageSize,OfficeSmsExample example,Long userId,String smsHeadline,OfficeSms officeSms) {
		System.out.println("得到的example為：：：===="+example);
		System.out.println("得到的officeSms為：：：===="+officeSms);
		PageHelper.startPage(pageNum, pageSize);
		List<OfficeDetailSms> selectByExample;
		if(smsHeadline!=null&&smsHeadline!=""){
			/*officeSms.setSmsHeadline(smsHeadline);*/
			officeSms.setSmsSender(userId);
			System.out.println("进入模糊查询set后得到的officeSms為：：：===="+officeSms);
			selectByExample = officeDetailSmsMapper.selectdetailsmsAndmysms(officeSms);
		}else{
			 selectByExample = officeDetailSmsMapper.selectdetailsmsAnduser(userId);
		}
		
			
		//selectByExample = officeDetailSmsMapper.selectByExample(null);
		
		
		PageInfo<OfficeDetailSms> pageInfo = new PageInfo<OfficeDetailSms>(selectByExample);
		
		List<com.sc.bean.OfficeDetailSms> list = pageInfo.getList();
		for (OfficeDetailSms officeDetailSms2 : list) {
			Long smsId = officeDetailSms2.getSmsId();
			Long receiverId = officeDetailSms2.getReceiverId();
			Long comId = officeDetailSms2.getComId();
			
			SysCOMPANY seleCOMById = hrScheDetailService.seleCOMById(comId);
			OfficeSms selesmsById = hrScheDetailService.selesmsById(smsId);
			SysUsers seleuserById = hrScheDetailService.seleuserById(receiverId);
			
			System.out.println(seleCOMById);
			officeDetailSms2.setSyscompany(seleCOMById);
			officeDetailSms2.setSysUsers(seleuserById);
			officeDetailSms2.setOfficeSms(selesmsById);	
		}
		pageInfo.setList(list);
		return pageInfo;
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

	@Override
	public OfficeDetailSms selectdetailsmsById(Long detailId) {
		
		return officeDetailSmsMapper.selectByPrimaryKey(detailId);
	}

	@Override
	public PageInfo<OfficeDetailSms> selectreaded(Integer pageNum, Integer pageSize, OfficeSmsExample example,
			Long userId, OfficeSms officeSms,String read) {
		
		System.out.println("得到的example為：：：===="+example);
		System.out.println("得到的officeSms為：：：===="+officeSms);
		PageHelper.startPage(pageNum, pageSize);
		List<OfficeDetailSms> selectByExample;
		if(read!=null&&read!=""&&read.equals("1")){
			System.out.println("进入impl并且read=1");
			/*officeSms.setSmsHeadline(smsHeadline);*/
			officeSms.setSmsSender(userId);
			System.out.println("进入模糊查询set后得到的officeSms為：：：===="+officeSms);
			selectByExample = officeDetailSmsMapper.selectdetailread(officeSms);
		}else{
			System.out.println("进入impl并且read=0");
				officeSms.setSmsSender(userId);
			 selectByExample = officeDetailSmsMapper.selectdetailread1(officeSms);
		}
		//selectByExample = officeDetailSmsMapper.selectByExample(null);
		
		
		PageInfo<OfficeDetailSms> pageInfo = new PageInfo<OfficeDetailSms>(selectByExample);
		
		List<com.sc.bean.OfficeDetailSms> list = pageInfo.getList();
		for (OfficeDetailSms officeDetailSms2 : list) {
			Long smsId = officeDetailSms2.getSmsId();
			Long receiverId = officeDetailSms2.getReceiverId();
			Long comId = officeDetailSms2.getComId();
			
			SysCOMPANY seleCOMById = hrScheDetailService.seleCOMById(comId);
			OfficeSms selesmsById = hrScheDetailService.selesmsById(smsId);
			SysUsers seleuserById = hrScheDetailService.seleuserById(receiverId);
			
			System.out.println(seleCOMById);
			officeDetailSms2.setSyscompany(seleCOMById);
			officeDetailSms2.setSysUsers(seleuserById);
			officeDetailSms2.setOfficeSms(selesmsById);	
		}
		pageInfo.setList(list);
		return pageInfo;
	}
}
