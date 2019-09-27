package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;
import com.sc.bean.OfficeDetailSmsExample.Criteria;
import com.sc.bean.OfficeSms;
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
	
	@Autowired
	HrScheDetailService hrScheDetailService;
	
	@Override
	public PageInfo<OfficeDetailSms> selectsmsByExample(Integer pageNum, Integer pageSize,OfficeDetailSms OfficeDetailSms,String smsHeadline,Long smssend,OfficeSms officeSms) {
		System.out.println("得到的officeSms数据为：==="+officeSms);
		PageHelper.startPage(pageNum, pageSize);
		List<OfficeDetailSms> selectByExample;
		if(smsHeadline!=null&&smsHeadline!=""){
			officeSms.setSmsSender(smssend);
			selectByExample = officeDetailSmsMapper.selectdetailsmsAndsms(officeSms);
			System.out.println("进入模糊查询set后得到的officeSms為：：：===="+officeSms);
		}else{
			 //selectByExample = officeDetailSmsMapper.selectByExample(null);
			 selectByExample = officeDetailSmsMapper.selectdetailsmsAndall(smssend);
		}
		
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

	@Override
	public void deldetailsmsInfo(OfficeDetailSms officeDetailSms) {
		
		if(officeDetailSms!=null&&officeDetailSms.getDetailId()!=null){
			this.officeDetailSmsMapper.deleteByPrimaryKey(officeDetailSms.getDetailId());
		}
		
	}

	@Override
	public OfficeDetailSms selesmsBybean(OfficeDetailSms officeDetailSms) {
		
		return officeDetailSmsMapper.selectByPrimaryKey(officeDetailSms.getDetailId());
	}

	@Override
	public void delsmsInfo(long smsid) {

		this.officeSmsMapper.deleteByPrimaryKey(smsid);
		
	}

	@Override
	public OfficeDetailSms selesmsByid(long detailid) {
		
		return officeDetailSmsMapper.selectByPrimaryKey(detailid);
	}

	@Override
	public void deldetailsmsbyid(long detailid) {
		
		
			this.officeDetailSmsMapper.deleteByPrimaryKey(detailid);
		
	}

	//id更新
	@Override
	public void updatestate(OfficeDetailSms officeDetailSms) {
		if(officeDetailSms!=null&&officeDetailSms.getSmsState()!=null){
			this.officeDetailSmsMapper.updateByPrimaryKeySelective(officeDetailSms);
		}
		
	}

	@Override
	public Integer countnum(long uid) {
		OfficeDetailSmsExample officeDetailSmsExample = new OfficeDetailSmsExample();
		Criteria c = officeDetailSmsExample.createCriteria();
		c.andSmsStateEqualTo("0");
		c.andReceiverIdEqualTo(uid);
		
		List<OfficeDetailSms> selectByExample = officeDetailSmsMapper.selectByExample(officeDetailSmsExample);
		Integer num = selectByExample.size();
		return num;
	}
	
	
	
		


}
