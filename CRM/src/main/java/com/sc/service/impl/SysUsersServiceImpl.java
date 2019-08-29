package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersExample;
import com.sc.bean.SysUsersExample.Criteria;
import com.sc.mapper.SysUsersMapper;
import com.sc.service.SysUsersService;


@Service
public class SysUsersServiceImpl implements SysUsersService {

	@Autowired
	SysUsersMapper sysusermapper;
	
	
	@Override
	public SysUsers login(String userName) {
		
		SysUsersExample example = new SysUsersExample();
		Criteria c = example.createCriteria();
		c.andUserNameEqualTo(userName);
		
		List<SysUsers> list = sysusermapper.selectByExample(example);
		
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}
}
