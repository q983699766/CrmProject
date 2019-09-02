package com.sc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;


public interface RolesService {

	//查看所有角色
	public List<SysRole> getRoleList();
	
	//修改角色
	public void updateRole(SysRole role);
	
	//删除角色
	public void delRole(Long RoleId);
	
	//添加角色
	public void addRole(SysRole role);
	
}
