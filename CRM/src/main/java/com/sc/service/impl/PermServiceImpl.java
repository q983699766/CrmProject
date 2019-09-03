package com.sc.service.impl;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionRole;
import com.sc.mapper.SysPermissionMapper;
import com.sc.mapper.SysPermissionRoleMapper;
import com.sc.service.PermissionService;

@Service
public class PermServiceImpl implements PermissionService{

	@Autowired
	SysPermissionMapper SysPermission;
	
	@Autowired
	SysPermissionRoleMapper SysPermissionRoleMapper;
	
	@Override
	public java.util.List<com.sc.bean.SysPermission> getPermList() {
		
		java.util.List<com.sc.bean.SysPermission> list = SysPermission.selectByExample(null);
		
		return list;
	}

	@Override
	public void addPerm(SysPermission perm) {
		
	}

	@Override
	public void updatePerm(SysPermission perm) {
		
	}

	@Override
	public void delPerm(Long permId) {
		SysPermission.deleteByPrimaryKey(permId);
	}

	@Override
	public void roleAddPerm(SysPermissionRole sysPR) {
		SysPermissionRoleMapper.insert(sysPR);
	}

}
