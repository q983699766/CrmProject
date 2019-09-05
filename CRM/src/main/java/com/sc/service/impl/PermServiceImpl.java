package com.sc.service.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionColumn;
import com.sc.bean.SysPermissionRole;
import com.sc.bean.SysPermissionRoleExample;
import com.sc.bean.SysPermissionRoleExample.Criteria;
import com.sc.bean.SysRole;
import com.sc.mapper.SysPermissionColumnMapper;
import com.sc.mapper.SysPermissionMapper;
import com.sc.mapper.SysPermissionRoleMapper;
import com.sc.mapper.SysRoleMapper;
import com.sc.service.PermissionService;

@Service
public class PermServiceImpl implements PermissionService{

	@Autowired
	SysPermissionMapper SysPermission;
	
	@Autowired
	SysPermissionColumnMapper SysPermissionColumn;
	
	@Autowired
	SysPermissionRoleMapper SysPermissionRoleMapper;
	
	@Autowired
	SysRoleMapper SysRoleMapper;
	
	@Override
	public java.util.List<com.sc.bean.SysPermission> getPermList() {
		
		java.util.List<com.sc.bean.SysPermission> list = SysPermission.selectByExample(null);
		
		return list;
	}

	@Override
	public void addPerm(SysPermission perm) {
		SysPermission.insert(perm);
	}

	@Override
	public void updatePerm(SysPermission perm,Long[] roleId, Long uid) {
		Long permissionId = perm.getPermissionId();
		SysPermissionRoleExample sysPermissionRoleExample = new SysPermissionRoleExample();
		Criteria c = sysPermissionRoleExample.createCriteria();
		c.andPermissionIdEqualTo(permissionId);
		
		SysPermission.updateByPrimaryKey(perm);
		
		Date date = new Date();
		SysPermissionRole permRole = new SysPermissionRole();
		permRole.setOperatorId(uid);
		permRole.setLastTime(date);
		permRole.setPermissionId(permissionId);
		
		SysPermissionRoleMapper.deleteByExample(sysPermissionRoleExample);
		for (Long rId : roleId) {
			
			permRole.setRoleId(rId);
			SysPermissionRoleMapper.insert(permRole);
		}
		
	}

	@Override
	public void delPerm(Long permId) {
		SysPermission.deleteByPrimaryKey(permId);
	}

	@Override
	public void roleAddPerm(SysPermissionRole sysPR) {
		SysPermissionRoleMapper.insert(sysPR);
	}

	@Override
	public void reset() {
		SysPermissionRoleMapper.reset();
	}

	@Override
	public com.sc.bean.SysPermission selectById(Long permId) {
		
		com.sc.bean.SysPermission perm = SysPermission.selectByPrimaryKey(permId);
		
		Long permissionId = perm.getPermissionId();
		SysPermissionRoleExample sysPermissionRoleExample = new SysPermissionRoleExample();
		Criteria c = sysPermissionRoleExample.createCriteria();
		c.andPermissionIdEqualTo(permissionId);
		
		java.util.List<SysPermissionRole> permRole = SysPermissionRoleMapper.selectByExample(sysPermissionRoleExample);
		
		ArrayList<SysRole> list = new ArrayList<SysRole>();
		
		for (SysPermissionRole sysPermissionRole : permRole) {
			Long roleId = sysPermissionRole.getRoleId();
			SysRole role = SysRoleMapper.selectByPrimaryKey(roleId);
			list.add(role);
		}
		perm.setRoles(list);
		
		return perm;
	}

	@Override
	public java.util.List<SysPermissionColumn> getColumn() {
		
		return SysPermissionColumn.selectByExample(null);
	}

}
