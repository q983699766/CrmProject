package com.sc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SysUsers;
import com.sc.bean.Users;


public interface UsersService {

	//查看所有用户
	public List<SysUsers> getUsersList();
	
	//修改用户
	public void updateUser(SysUsers user);
	
	//修改用户
	public void updateUserRole(SysUsers user, Long[] roleId, Long uid);
	
	//删除用户
	public void delUser(Long userId);
	
	//添加用户
	public void addUser(SysUsers user);
	
	//查找用户
	public SysUsers selectById(Long usersId);
	
	//分页
	public PageInfo<SysUsers> selectUsersPage
	(Integer pageNum, Integer pageSize);
	
	//查找用户-用户名
	public SysUsers selectByName(String userName);
}
