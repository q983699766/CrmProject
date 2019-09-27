package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeChecktarget;
import com.sc.bean.OfficeChecktargetExample;
import com.sc.bean.OfficeChecktask;
import com.sc.bean.OfficeChecktaskExample;
import com.sc.bean.OfficeGrant;
import com.sc.bean.OfficeGrantExample;
import com.sc.bean.OfficeTaskdetail;
import com.sc.bean.OfficeTaskdetailExample;
import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersExample;
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
	
	@Autowired
	OfficeGrantMapper officeGrantMapper;
	
	@Override
	public void del(Long taskId, Long userId, Long comId) {
		// 通过userId查出其下属
		OfficeGrantExample eg = new OfficeGrantExample();
		com.sc.bean.OfficeGrantExample.Criteria criteria2 = eg.createCriteria();
		criteria2.andUpidEqualTo(userId);
		List<OfficeGrant> listg = officeGrantMapper.selectByExample(eg);
		List<Long> values = new ArrayList<Long>();
		for (OfficeGrant u : listg) {
			values.add(u.getUserId());
		}
		
		// 删除下属表：设置查找范围，comid，下属列表，taskid等，查出列表，并按主键删除这些列表数据
		OfficeTaskdetailExample e = new OfficeTaskdetailExample();
		com.sc.bean.OfficeTaskdetailExample.Criteria criteria = e.createCriteria();
		criteria.andComIdEqualTo(comId);
		criteria.andTaskIdEqualTo(taskId);
		criteria.andReceiverIdIn(values);
		List<OfficeTaskdetail> listdetail = officeTaskdetailMapper.selectByExample(e);
		for (OfficeTaskdetail officeTaskdetail : listdetail) {
			officeTaskdetailMapper.deleteByPrimaryKey(officeTaskdetail.getIdd());
		}
		
		// 删除OfficeChecktask表，主键为taskId
		officeChecktaskMapper.deleteByPrimaryKey(taskId);
	}
	
	@Override
	public void fabu(OfficeChecktask off, Long[] lreceiverIds, Long userId) {
		// 将接收人id数组改为List
		List<Long> receivers = new ArrayList<Long>();
		for(Long i : lreceiverIds) {
			receivers.add(i);
		}
		
		// 插入一条数据到OfficeChecktask，并返回主键
		off.setTaskPublisher(userId);
		off.setLastTime(new Date());
		Integer fabuId = officeChecktaskMapper.getfabu(off);
		System.out.println("TaskId:"+off.getTaskId());
		
		// 将接收人列表插入到数据库
		OfficeTaskdetail  officeTaskdetail = new OfficeTaskdetail();
		officeTaskdetail.setIsFinish(0L);
		officeTaskdetail.setComId(off.getComId());
		officeTaskdetail.setLastTime(new Date());
		officeTaskdetail.setStatue(0L);
		officeTaskdetail.setTaskId(off.getTaskId());
		for(Long j : receivers) {
			officeTaskdetail.setReceiverId(j);
			officeTaskdetailMapper.insert(officeTaskdetail);
		}
	}
	
	@Override
	public List<SysUsers> prereceiver(Long userId) {
		OfficeGrantExample e = new OfficeGrantExample();
		com.sc.bean.OfficeGrantExample.Criteria criteria = e.createCriteria();
		criteria.andUpidEqualTo(userId);
		List<OfficeGrant> list = officeGrantMapper.selectByExample(e);
		
		List<Long> userIdList = new ArrayList<Long>();
		for (OfficeGrant officeGrant : list) {
			userIdList.add(officeGrant.getUserId());
		}
		
		SysUsersExample euser = new SysUsersExample();
		com.sc.bean.SysUsersExample.Criteria criteria2 = euser.createCriteria();
		criteria2.andUserIdIn(userIdList);
		List<SysUsers> list2 = sysUsersMapper.selectByExample(euser);
		
		return list2;
	}
	
	@Override
	public List<OfficeChecktarget> pretargetId() {
		return officeChecktargetMapper.selectByExample(null);
	}

	@Override
	public void updateisfinish(Long idd) {
		// TODO Auto-generated method stub
		OfficeTaskdetail off = officeTaskdetailMapper.selectByPrimaryKey(idd);
		off.setIsFinish(1L);
		officeTaskdetailMapper.updateByPrimaryKey(off);
	}
	
	@Override
	public List<OfficeChecktask> selectall(Long userId) {
		OfficeChecktaskExample eoc = new OfficeChecktaskExample();
		com.sc.bean.OfficeChecktaskExample.Criteria criteria = eoc.createCriteria();
		criteria.andTaskPublisherEqualTo(userId);
		
		List<OfficeChecktask> list = officeChecktaskMapper.selectByExample(eoc);
		
		for (OfficeChecktask officeChecktask : list) {
			officeChecktask.setSysUsers(sysUsersMapper.selectByPrimaryKey(officeChecktask.getTaskPublisher()));
			officeChecktask.setOfficeChecktarget(officeChecktargetMapper.selectByPrimaryKey(officeChecktask.getTargetId()));
		}
		
		return list;
	}
	
	@Override
	public List<OfficeTaskdetail> selectthisline(Long taskId,Long taskPublisher) {
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
		
		// 通过taskPublisher查出其下属的id列表
		List<Long> receiverList = new ArrayList<Long>();
		OfficeGrantExample eg = new OfficeGrantExample();
		com.sc.bean.OfficeGrantExample.Criteria cg = eg.createCriteria();
		cg.andUpidEqualTo(taskPublisher);
		List<OfficeGrant> listg = officeGrantMapper.selectByExample(eg);
		for (OfficeGrant officeGrant : listg) {
//			System.out.println("xiashuID:"+officeGrant.getUserId());
			receiverList.add(officeGrant.getUserId());
		}
		
		c.andReceiverIdIn(receiverList);
		List<OfficeTaskdetail> list2 = officeTaskdetailMapper.selectByExample(e);
		
		for (OfficeTaskdetail officeTaskdetail : list2) {
			officeTaskdetail.setStatue(statue);
			officeTaskdetailMapper.updateByPrimaryKey(officeTaskdetail);
		}
		
		OfficeTaskdetailExample example = new OfficeTaskdetailExample();
		com.sc.bean.OfficeTaskdetailExample.Criteria criteria = example.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		criteria.andReceiverIdIn(receiverList);
		List<OfficeTaskdetail> list = officeTaskdetailMapper.selectByExample(example);
		
		for (OfficeTaskdetail officeTaskdetail : list) {
			Long receiverId = officeTaskdetail.getReceiverId();
			SysUsers sysUsers = sysUsersMapper.selectByPrimaryKey(receiverId);
			officeTaskdetail.setSysUsers(sysUsers);
		}
		
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
		
		for (OfficeTaskdetail officeTaskdetail : list2) {
			Long receiverId = officeTaskdetail.getReceiverId();
			SysUsers sysUsers = sysUsersMapper.selectByPrimaryKey(receiverId);
			officeTaskdetail.setSysUsers(sysUsers);
		}
		
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
