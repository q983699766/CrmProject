package com.sc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionExample;
import com.sc.bean.SysPermissionRole;
import com.sc.bean.SysPermissionRoleExample;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsersRoleExample;
import com.sc.mapper.SysPermissionMapper;
import com.sc.mapper.SysPermissionRoleMapper;
import com.sc.mapper.SysRoleExample;
import com.sc.mapper.SysRoleExample.Criteria;
import com.sc.mapper.SysRoleMapper;
import com.sc.service.RolesService;
@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	SysRoleMapper SysRoleMapper;
	
	@Autowired
	SysPermissionMapper SysPermission;
	
	@Autowired
	SysPermissionRoleMapper SysPermissionRoleMapper;
	
	@Override
	public List<SysRole> getRoleList() {
		
		List<SysRole> roles = SysRoleMapper.selectByExample(null);
		
		for (SysRole sysRole : roles) {
			Long higherRoleId = sysRole.getHigherRoleId();
			SysRole r = SysRoleMapper.selectByPrimaryKey(higherRoleId);
			if(!(r==null)){
			sysRole.setHighRoleName(r.getRoleName());
			}
			
			Long roleId = sysRole.getRoleId();
			
			SysPermissionRoleExample example = new SysPermissionRoleExample();
			com.sc.bean.SysPermissionRoleExample.Criteria c = example.createCriteria();
			c.andRoleIdEqualTo(roleId);
			
			List<SysPermissionRole> permSoles = SysPermissionRoleMapper.selectByExample(example);
			
			List<com.sc.bean.SysPermission> sysPerms =  new ArrayList<SysPermission>();
			
			for (SysPermissionRole sysPermissionRole : permSoles) {
				Long permId = sysPermissionRole.getPermissionId();
				com.sc.bean.SysPermission perms = SysPermission.selectByPrimaryKey(permId);
				sysPerms.add(perms);
			}
			sysRole.setPerms(sysPerms);
		}
		
		return roles;
	}

	@Override
	public void updateRole(SysRole role) {
		SysRoleMapper.updateByPrimaryKeySelective(role);
		
	}

	@Override
	public void delRole(Long RoleId) {
		SysRoleMapper.deleteByPrimaryKey(RoleId);
		
	}

	@Override
	public void addRole(SysRole role) {
		SysRoleMapper.insert(role);
		
	}

	@Override
	public SysRole selectById(Long roleId) {
		SysRole sysr = SysRoleMapper.selectByPrimaryKey(roleId);
		Long higherRoleId = sysr.getHigherRoleId();
		if(higherRoleId!=null){
			SysRole selectByPrimaryKey = SysRoleMapper.selectByPrimaryKey(higherRoleId);
			if(selectByPrimaryKey!=null){
				String highRoleName = selectByPrimaryKey.getRoleName();
				sysr.setHighRoleName(highRoleName);
			}
			}
			
		
		return sysr;
	}

}
