package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.SalBleed;
import com.sc.bean.SalBleedExample;
import com.sc.bean.SalConper;
import com.sc.bean.SalConperExample;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SalCustomInfoExample;
import com.sc.bean.SalCustomInfoExample.Criteria;
import com.sc.bean.SalFeedback;
import com.sc.bean.SalFeedbackExample;
import com.sc.bean.SalRecord;
import com.sc.bean.SalRecordExample;
import com.sc.mapper.SalBleedMapper;
import com.sc.mapper.SalConperMapper;
import com.sc.mapper.SalCustomInfoMapper;
import com.sc.mapper.SalFeedbackMapper;
import com.sc.mapper.SalRecordMapper;
import com.sc.service.ConperService;

@Service
public class ConperServiceImpl implements ConperService {

	@Autowired
	SalCustomInfoMapper salCustomInfoMapper;
	@Autowired
	SalConperMapper  salConperMapper;
	@Autowired
	SalRecordMapper  salRecordMapper;
	@Autowired
	SalFeedbackMapper salFeedbackMapper;
	@Autowired
	SalBleedMapper salBleedMapper;
	
	
	//分页查询用户信息
	@Override
	public PageInfo<SalCustomInfo> selectSalCustomInfoPage(Integer pageNum, Integer pageSize,SalCustomInfo sal) {
		PageHelper.startPage(pageNum,pageSize);
		SalCustomInfoExample example=new SalCustomInfoExample();	
			Criteria criteria = example.createCriteria();
			criteria.andCustomStateEqualTo("正在合作");	
		List<SalCustomInfo> list = salCustomInfoMapper.selectByExample(example);
		PageInfo<SalCustomInfo> pi = new PageInfo<SalCustomInfo>(list);
		return pi;
	}
	
	
	@Override
	public PageInfo<SalCustomInfo> selectSalCustomInfoMessage(Integer pageNum, Integer pageSize,String message) {
		PageHelper.startPage(pageNum,pageSize);
		SalCustomInfoExample example=new SalCustomInfoExample();
		if(message!=null){
		
		Criteria criteria = example.createCriteria();
		criteria.andCustomStateEqualTo("正在合作");
		criteria.andCustomNameLike("%"+message+"%");
		}
		List<SalCustomInfo> list = salCustomInfoMapper.selectByExample(example);
		PageInfo<SalCustomInfo> pi = new PageInfo<SalCustomInfo>(list);
		return pi;
	}
	
	//通过id查询用户信息
	@Override
	public SalCustomInfo selectById(Long customId) {
	
		return salCustomInfoMapper.selectByPrimaryKey(customId);
	}
	
	//添加用户信息
	@Override
	public void addSalCustomInfo(SalCustomInfo sal) {
		if(sal!=null){
			this.salCustomInfoMapper.insert(sal);
		}
			
	}

	//删除用户信息
	@Override
	public void delSalCustomInfo(SalCustomInfo sal) {
	
		if(sal!=null&&sal.getCustomId()!=null){
			this.salCustomInfoMapper.deleteByPrimaryKey(sal.getCustomId());
		}
		
	}

	//修改用户信息
	@Override
	public void updateSalCustomInfo(SalCustomInfo sal) {
	
		if(sal!=null){
			this.salCustomInfoMapper.updateByPrimaryKey(sal);
		}
	}

	//根据客户ID查询出对应的联系人信息
	@Override
	public List<SalConper> selectconperById(Long customId) {
		
		SalConperExample example = new SalConperExample();
		com.sc.bean.SalConperExample.Criteria criteria = example.createCriteria();
		criteria.andCustomIdEqualTo(customId);
		List<SalConper> list = salConperMapper.selectByExample(example);
		return list;
	}

	@Override
	public void addSalConper(SalConper con) {
		if(con!=null){
			this.salConperMapper.insert(con);
		}
		
	}

	@Override
	public void updateSalConper(SalConper con) {
		if(con!=null){
			this.salConperMapper.updateByPrimaryKey(con);
		}
		
	}

	@Override
	public SalConper selectSalConperById(Long customId) {
		
		return this.salConperMapper.selectByPrimaryKey(customId);
	}

	@Override
	public void delSalConper(SalConper con) {
		if(con!=null&&con.getConperId()!=null){
			this.salConperMapper.deleteByPrimaryKey(con.getConperId());
		}
		
	}

	@Override
	public void delAll(Long customId) {
		if(customId!=null){
			this.salCustomInfoMapper.deleteByPrimaryKey(customId);
		}
		
	}

	//根据联系人ID查询出所有联系记录
	@Override
	public List<SalRecord> selectrecordById(Long customId) {
		
		SalRecordExample example = new SalRecordExample();
		com.sc.bean.SalRecordExample.Criteria criteria = example.createCriteria();
		criteria.andCustomIdEqualTo(customId);
		List<SalRecord> list = salRecordMapper.selectByExample(example);
		return list;
	}

	//添加联系记录
	@Override
	public void addSalRecord(SalRecord rec) {
		if(rec!=null){
			this.salRecordMapper.insert(rec);
		}
		
	}

	//根据联系人ID查询当前联系人的信息
	@Override
	public SalConper selectSalConById(Long conperId) {
		
		return this.salConperMapper.selectByPrimaryKey(conperId);
	}

	//删除联系记录
	@Override
	public void delSalRecord(SalRecord rec) {
		if(rec!=null&&rec.getRecordId()!=null){
			this.salRecordMapper.deleteByPrimaryKey(rec.getRecordId());
		}
		
	}

	
	
	//根据客户ID分页查询客户反馈记录
	@Override
	public PageInfo<SalFeedback> selectSalFeedbackById(Integer pageNum, Integer pageSize, Long customId) {
		PageHelper.startPage(pageNum,pageSize);
		SalFeedbackExample example = new SalFeedbackExample();
		if(customId!=null){
			com.sc.bean.SalFeedbackExample.Criteria criteria = example.createCriteria();
			criteria.andCustomIdEqualTo(customId);
		}
		List<SalFeedback> list = salFeedbackMapper.selectByExample(example);
		PageInfo<SalFeedback> pi = new PageInfo<SalFeedback>(list);
		return pi;
		
		
	}
	
	

	//通过优先级模糊查询反馈记录
	@Override
	public PageInfo<SalFeedback> selectSalFeedbackByPri(Integer pageNum, Integer pageSize, String pri) {
		PageHelper.startPage(pageNum,pageSize);
		SalFeedbackExample example = new SalFeedbackExample();
		if(pri!=null&&pri!=""){
			com.sc.bean.SalFeedbackExample.Criteria criteria = example.createCriteria();
			criteria.andPriLike("%"+pri+"%");
		}
		List<SalFeedback> list = salFeedbackMapper.selectByExample(example);
		PageInfo<SalFeedback> pi = new PageInfo<SalFeedback>(list);
		return pi;
	}

	//根据反馈记录ID分页查询客户反馈记录
	@Override
	public SalFeedback selectSalFeedById(Long feedbackId) {
		
		return this.salFeedbackMapper.selectByPrimaryKey(feedbackId);
	}
	
	
	//添加反馈记录
	@Override
	public void addSalFeedback(SalFeedback feedback) {
		if(feedback!=null){
			this.salFeedbackMapper.insert(feedback);
		}
		
	}

	@Override
	public void delSalFeedback(SalFeedback feedback) {
		if(feedback!=null&&feedback.getFeedbackId()!=null){
			this.salFeedbackMapper.deleteByPrimaryKey(feedback.getFeedbackId());
		}
		
	}


	@Override
	public PageInfo<SalCustomInfo> selectLosePage(Integer pageNum, Integer pageSize, SalCustomInfo sal) {
		PageHelper.startPage(pageNum,pageSize);
		System.out.println("111*******进来了");
		List<SalCustomInfo> list = salCustomInfoMapper.selectByOrderId(null);
		PageInfo<SalCustomInfo> pi = new PageInfo<SalCustomInfo>(list);
		List<SalCustomInfo> list2 = pi.getList();
		for (SalCustomInfo salCustomInfo : list2) {
			salCustomInfo.setSalbleed(selectByCustomId(salCustomInfo.getCustomId()));
		}
		pi.setList(list2);
		return pi;
	}


	@Override
	public PageInfo<SalCustomInfo> selectLoseMessage(Integer pageNum, Integer pageSize, String message) {
		PageHelper.startPage(pageNum,pageSize);
		System.out.println("222*******进来了");
		SalCustomInfoExample example = new SalCustomInfoExample();
		if(message!=null){
		Criteria criteria = example.createCriteria();
		criteria.andCustomNameLike("%"+message+"%");
		}
		List<SalCustomInfo> list = salCustomInfoMapper.selectByOrderId(null);
		PageInfo<SalCustomInfo> pi = new PageInfo<SalCustomInfo>(list);
		return pi;
	}


	@Override
	public void addSalBleed(SalBleed bleed) {
		if(null!=bleed){
			this.salBleedMapper.insert(bleed);
		}
		
	}


	@Override
	public SalBleed selectByBleedId(Long churnId) {
		
		return salBleedMapper.selectByPrimaryKey(churnId);
	}


	@Override
	public SalBleed selectByCustomId(Long customId) {
		SalBleed salBleed=null;
		SalBleedExample example = new SalBleedExample();
		com.sc.bean.SalBleedExample.Criteria criteria = example.createCriteria();
		criteria.andCustomIdEqualTo(customId);
		List<SalBleed> list =salBleedMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			salBleed =list.get(0);
		}
		return salBleed;
	}


	@Override
	public void updateSalBleed(SalBleed bleed) {
		if(bleed!=null){
			this.salBleedMapper.updateByPrimaryKey(bleed);
		}
		
	}





	



	
	
	
}
