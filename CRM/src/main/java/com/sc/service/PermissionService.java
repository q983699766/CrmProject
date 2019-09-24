package com.sc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionColumn;
import com.sc.bean.SysPermissionRole;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;

public interface PermissionService {

		//查看所有权限及拥有它的角色
		public List<SysPermission> getPermList();
		
		//查看分栏权限及拥有它的角色
		public List<SysPermission> getPermListByCol(String columnName);
		
		//得到所有权限分栏
		public List<SysPermissionColumn> getColumn();
		
		//添加权限
		public void addPerm(SysPermission perm);
		
		//添加权限分栏
		public void addPermcol(SysPermissionColumn col);
		
		//修改权限
		public void updatePerm(SysPermission perm, Long[] roleId, Long uid);
		
		//删除权限
		public void delPerm(Long permId);
		
		//清除权限
		public void reset();
		
		//给角色配置权限
		public void roleAddPerm(SysPermissionRole sysPR);
		
		//查询权限及拥有它的角色
		public SysPermission selectById(Long permId);
		
		//分页
		public PageInfo<SysPermission> selectUsersPage
		(Integer pageNum, Integer pageSize);
		
		//获取本用户权限
		public java.util.List<SysPermission> getMyPerm(Long uid);
}
