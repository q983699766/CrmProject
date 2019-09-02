package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysEmpuser;
import com.sc.bean.SysUsers;
import com.sc.mapper.SysEmpuserMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	SysUsersMapper SysUsersMapper;
	
	@Autowired
	SysEmpuserMapper SysEmpuserMapper;
	
	@Override
	public List<SysUsers> getUsersList() {
		List<SysUsers> list = SysUsersMapper.selectByExample(null);
		
		for (SysUsers sysUsers : list) {
			Long empId = sysUsers.getEmpId();
			
			SysEmpuser emp = SysEmpuserMapper.selectByPrimaryKey(empId);
			sysUsers.setEmpName(emp.getEmpName());
		}
		
		return list;
	}

	@Override
	public void updateUser(SysUsers user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(SysUsers user) {
		// TODO Auto-generated method stub
		
	}

	
}
