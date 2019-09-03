package com.sc.service.impl;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysPermission;
import com.sc.mapper.SysPermissionMapper;
import com.sc.service.PermissionService;

@Service
public class PermServiceImpl implements PermissionService{

	@Autowired
	SysPermissionMapper SysPermission;
	
	
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
	public void updateUserPassw(Long permId) {
		
	}

}
