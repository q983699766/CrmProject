package com.sc.service;

import java.util.List;

import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionRole;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;

public interface PermissionService {

		//查看所有权限及拥有它的角色
		public List<SysPermission> getPermList();
		
		
		//添加权限
		public void addPerm(SysPermission perm);
		
		//修改权限
		public void updatePerm(SysPermission perm);
		
		//删除权限
		public void delPerm(Long permId);
		
		//清除权限
		public void reset();
		
		//给角色配置权限
		public void roleAddPerm(SysPermissionRole sysPR);
	
}
