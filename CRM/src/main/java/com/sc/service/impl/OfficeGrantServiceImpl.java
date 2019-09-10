package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeChecktarget;
import com.sc.bean.OfficeChecktargetExample;
import com.sc.bean.Users;
import com.sc.bean.UsersExample;
import com.sc.bean.UsersExample.Criteria;
import com.sc.mapper.OfficeChecktargetMapper;
import com.sc.mapper.OfficeGrantMapper;
import com.sc.mapper.UsersMapper;
import com.sc.service.OfficeChecktargetService;
import com.sc.service.OfficeGrantService;
import com.sc.service.UsersService;

@Service
public class OfficeGrantServiceImpl implements OfficeGrantService {
	@Autowired
	OfficeGrantMapper officeGrantMapper;
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
