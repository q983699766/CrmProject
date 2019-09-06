package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysEmpuser;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersExample;
import com.sc.bean.SysUsersRole;
import com.sc.bean.SysUsersRoleExample;
import com.sc.bean.SysUsersRoleExample.Criteria;
import com.sc.mapper.SysEmpuserMapper;
import com.sc.mapper.SysRoleMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.mapper.SysUsersRoleMapper;
import com.sc.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	SysUsersMapper SysUsersMapper;
	
	@Autowired
	SysEmpuserMapper SysEmpuserMapper;
	
	@Autowired
	SysRoleMapper SysRoleMapper;
	
	@Autowired
	SysUsersRoleMapper SysUsersRoleMapper;
	
	@Override
	public List<SysUsers> getUsersList() {
		List<SysUsers> list = SysUsersMapper.selectByExample(null);
		
		for (SysUsers sysUsers : list) {
			Long empId = sysUsers.getEmpId();
			
			SysEmpuser emp = SysEmpuserMapper.selectByPrimaryKey(empId);
			sysUsers.setEmpName(emp.getEmpName());
			
			Long userId = sysUsers.getUserId();
			
			SysUsersRoleExample sysUsersRoleExample = new SysUsersRoleExample();
			Criteria c = sysUsersRoleExample.createCriteria();
			c.andUserIdEqualTo(userId);
			
			List<SysUsersRole> userRole = SysUsersRoleMapper.selectByExample(sysUsersRoleExample);
			if(!userRole.isEmpty()){
				
				ArrayList<SysRole> list2 = new ArrayList<SysRole>();
				
				for (SysUsersRole sysUsersRole : userRole) {
					Long roleId = sysUsersRole.getRoleId();
					SysRole role = SysRoleMapper.selectByPrimaryKey(roleId);
					list2.add(role);
				}
				sysUsers.setRoles(list2);
			}
				
			
			
		}
		
		return list;
	}
	
	@Override
	public void updateUser(SysUsers user) {
		SysUsersMapper.updateByPrimaryKey(user);
	}
	
	
	@Override
	public void updateUserRole(SysUsers user, Long[] roleId, Long uid) {
		SysUsersMapper.updateByPrimaryKey(user);
		Long userId = user.getUserId();
		SysUsersRoleExample sysUsersRoleExample = new SysUsersRoleExample();
		Criteria c = sysUsersRoleExample.createCriteria();
		c.andUserIdEqualTo(userId);
		SysUsersRoleMapper.deleteByExample(sysUsersRoleExample);
		if(roleId!=null){
			for (Long rId : roleId) {
			SysUsersRole sysUsersRole = new SysUsersRole();
			sysUsersRole.setUserId(userId);
			sysUsersRole.setRoleId(rId);
			sysUsersRole.setOperatorId(uid);
			Date date = new Date();
			sysUsersRole.setLastTime(date);
			SysUsersRoleMapper.insert(sysUsersRole);
			}
		}
	}

	@Override
	public void delUser(Long userId) {
		SysUsersMapper.deleteByPrimaryKey(userId);
		
	}

	@Override
	public void addUser(SysUsers user) {
		
		String salt = "qwerty";
		int count = 3;
		
		String password = user.getUserPassword();
		
		Md5Hash m = new Md5Hash(password, salt, count);
		String pass = m.toString();	
				
		user.setUserPassword(pass);
		
		SysUsersMapper.insert(user);
		
	}

	@Override
	public SysUsers selectById(Long userId) {
		SysUsers user = SysUsersMapper.selectByPrimaryKey(userId);
		Long empId = user.getEmpId();
		SysEmpuser emp = SysEmpuserMapper.selectByPrimaryKey(empId);
		user.setEmpName(emp.getEmpName());
		
		Long uId = user.getUserId();
		
		SysUsersRoleExample sysUsersRoleExample = new SysUsersRoleExample();
		Criteria c = sysUsersRoleExample.createCriteria();
		c.andUserIdEqualTo(uId);
		
		List<SysUsersRole> userRole = SysUsersRoleMapper.selectByExample(sysUsersRoleExample);
		
		if(!userRole.isEmpty()){
			SysUsersRole sysUsersRole = userRole.get(0);
			Long roleId = sysUsersRole.getRoleId();
			SysRole role = SysRoleMapper.selectByPrimaryKey(roleId);
			user.setRoleName(role.getRoleName());
		}
		return user;
	}

	@Override
	public SysUsers selectByName(String userName) {
		
		SysUsersExample sysUsersExample = new SysUsersExample();
		com.sc.bean.SysUsersExample.Criteria c = sysUsersExample.createCriteria();
		c.andUserNameEqualTo(userName);
		
		List<SysUsers> selectByExample = SysUsersMapper.selectByExample(sysUsersExample);
		if(!selectByExample.isEmpty()){
			SysUsers user = selectByExample.get(0);
			return user;
		}
		
		return null;
	}
}
