package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeChecktarget;
import com.sc.bean.OfficeChecktargetExample;
import com.sc.bean.OfficeChecktask;
import com.sc.bean.OfficeGrant;
import com.sc.bean.OfficeGrantExample;
import com.sc.bean.OfficeTaskdetail;
import com.sc.bean.OfficeTaskdetailExample;
import com.sc.bean.Users;
import com.sc.bean.UsersExample;
import com.sc.bean.UsersExample.Criteria;
import com.sc.mapper.OfficeChecktargetMapper;
import com.sc.mapper.OfficeChecktaskMapper;
import com.sc.mapper.OfficeGrantMapper;
import com.sc.mapper.OfficeTaskdetailMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.mapper.UsersMapper;
import com.sc.service.OfficeChecktargetService;
import com.sc.service.OfficeGrantService;
import com.sc.service.UsersService;

@Service
public class OfficeGrantServiceImpl implements OfficeGrantService {
	@Autowired
	OfficeChecktaskMapper officeChecktaskMapper;
	
	@Autowired
	SysUsersMapper sysUsersMapper;
	
	@Autowired
	OfficeChecktargetMapper officeChecktargetMapper;
	
	@Autowired
	OfficeTaskdetailMapper officeTaskdetailMapper;
	
//	@Override
//	public List<OfficeGrant> selectgrantunderme(Long userId, Long comId) {
//		// TODO Auto-generated method stub
//		OfficeGrantExample og = new OfficeGrantExample();
//		com.sc.bean.OfficeGrantExample.Criteria criteria = og.createCriteria();
//		criteria.andComIdEqualTo(comId);
//		criteria.andUpidEqualTo(userId);
//		return this.officeGrantMapper.selectByExample(og);
//	}
	
	@Override
	public List<OfficeChecktask> selectall() {
		// TODO Auto-generated method stub
		List<OfficeChecktask> list = officeChecktaskMapper.selectByExample(null);
		
		for (OfficeChecktask officeChecktask : list) {
			officeChecktask.setSysUsers(sysUsersMapper.selectByPrimaryKey(officeChecktask.getTaskPublisher()));
			officeChecktask.setOfficeChecktarget(officeChecktargetMapper.selectByPrimaryKey(officeChecktask.getTargetId()));
		}
		
		return list;
	}
	
	@Override
	public List<OfficeTaskdetail> selectthisline(Long taskId) {
		// TODO Auto-generated method stub
		
		OfficeChecktask officeChecktask = officeChecktaskMapper.selectByPrimaryKey(taskId);
		Date starttime = officeChecktask.getTaskStarttime();
		Date endtime = officeChecktask.getTaskEndtime();
		Date dqtime = new Date();
		Long statue=0L;
		if(dqtime.before(starttime)) {
			statue = 0L;
		}else if(dqtime.after(starttime) && dqtime.before(endtime)) {
			statue = 1L;
		}else if(dqtime.after(endtime)) {
			statue = 2L;
		}
		
		OfficeTaskdetailExample e = new OfficeTaskdetailExample();
		com.sc.bean.OfficeTaskdetailExample.Criteria c = e.createCriteria();
		c.andTaskIdEqualTo(taskId);
		List<OfficeTaskdetail> list2 = officeTaskdetailMapper.selectByExample(e);
		
		for (OfficeTaskdetail officeTaskdetail : list2) {
			officeTaskdetail.setStatue(statue);
			officeTaskdetailMapper.updateByPrimaryKey(officeTaskdetail);
		}
		
		OfficeTaskdetailExample example = new OfficeTaskdetailExample();
		com.sc.bean.OfficeTaskdetailExample.Criteria criteria = example.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		List<OfficeTaskdetail> list = officeTaskdetailMapper.selectByExample(example);
		
		return list;
	}
	
	@Override
	public List<OfficeTaskdetail> selectre(Long pblishid) {
		// TODO Auto-generated method stub
		OfficeTaskdetailExample e = new OfficeTaskdetailExample();
		com.sc.bean.OfficeTaskdetailExample.Criteria c = e.createCriteria();
		c.andReceiverIdEqualTo(pblishid);
		List<OfficeTaskdetail> list = officeTaskdetailMapper.selectByExample(e);
		
		OfficeChecktask officeChecktask = null;
		Date dqtime = new Date();
		for (OfficeTaskdetail officeTaskdetail : list) {
			Long statue=0L;
			officeChecktask = officeChecktaskMapper.selectByPrimaryKey(officeTaskdetail.getTaskId());
			if(dqtime.before(officeChecktask.getTaskStarttime())) {
				statue = 0L;
			}else if(dqtime.after(officeChecktask.getTaskStarttime()) && dqtime.before(officeChecktask.getTaskEndtime())) {
				statue = 1L;
			}else if(dqtime.after(officeChecktask.getTaskEndtime())) {
				statue = 2L;
			}
			officeTaskdetail.setStatue(statue);
			officeTaskdetailMapper.updateByPrimaryKey(officeTaskdetail);
		}
		
		List<OfficeTaskdetail> list2 = officeTaskdetailMapper.selectByExample(e);
		
		return list2;
	}
	
/*
	@Override
	public List<OfficeChecktarget> selectOfficeChecktargetAll() {
//		if(comId!=null) {
//			OfficeChecktargetExample example = new OfficeChecktargetExample();
//			com.sc.bean.OfficeChecktargetExample.Criteria criteria = example.createCriteria();
//			criteria.andComIdEqualTo(comId);
//			List<OfficeChecktarget> selectByExample = this.officeChecktargetMapper.selectByExample(example);
//			if(selectByExample!=null) {
//				return selectByExample;
//			}
//		}
//		return null;
		return this.officeChecktargetMapper.selectByExample(null);
	}

	@Override
	public void delOfficeChecktargetById(OfficeChecktarget offchecktarget) {
		// TODO Auto-generated method stub
		if(offchecktarget!=null && offchecktarget.getTargetId()!=null) {
			this.officeChecktargetMapper.deleteByPrimaryKey(offchecktarget.getTargetId());
		}
	}

	@Override
	public void addOfficeChecktarget(OfficeChecktarget offchecktarget) {
		// TODO Auto-generated method stub
		if(offchecktarget!=null) {
			this.officeChecktargetMapper.insert(offchecktarget);
		}
	}

	@Override
	public OfficeChecktarget updateById(Long targetId) {
		// TODO Auto-generated method stub
		if(targetId!=null) {
			return this.officeChecktargetMapper.selectByPrimaryKey(targetId);
		}
		return null;
	}

	@Override
	public void update(OfficeChecktarget offchecktarget) {
		// TODO Auto-generated method stub
		if(offchecktarget!=null) {
			this.officeChecktargetMapper.updateByPrimaryKey(offchecktarget);
		}
	}
	
	
*/


}
