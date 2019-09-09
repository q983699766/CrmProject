package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersRoleExample;
import com.sc.mapper.SysRoleMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.mapper.SysUsersRoleMapper;

@Service
public class UserInfoService implements com.sc.service.UserInfoService{

	@Autowired
	SysUsersRoleMapper SysUsersRole;
	
	@Autowired
	SysRoleMapper SysRole;
	
	@Autowired
	SysUsersMapper SysUsers;

	@Override
	public List<SysRole> getRoleLst() {
		List<com.sc.bean.SysRole> roles = SysRole.selectByExample(null);
		return roles;
	}

	

	@Override
	public SysRole getMyRole(Long uid) {
		SysUsersRoleExample example = new SysUsersRoleExample();
		com.sc.bean.SysUsersRoleExample.Criteria c = example.createCriteria();
		c.andUserIdEqualTo(uid);
		
		List<com.sc.bean.SysUsersRole> list = SysUsersRole.selectByExample(example);
		
		if(list.isEmpty()){
			return null;
		}else{
			com.sc.bean.SysUsersRole user = list.get(0);
			Long roleId = user.getRoleId();
			
			return SysRole.selectByPrimaryKey(roleId);
		}
	}


	@Override
	public void updateUserPassw(String password, SysUsers user) {
		
		
		String salt = "qwerty";
		int count = 3;
		
		Md5Hash m = new Md5Hash(password, salt, count);
		String pass = m.toString();	
		System.out.println(pass);
		
		Date date = new Date();
		user.setLastTime(date);
		user.setUserPassword(pass);
		
		SysUsers.updateByPrimaryKey(user);
	}

}
