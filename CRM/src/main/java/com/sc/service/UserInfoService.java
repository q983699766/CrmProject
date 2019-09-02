package com.sc.service;

import java.util.List;

import com.sc.bean.SysEmpuser;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;

public interface UserInfoService {

	
	//查询自己账号的角色
	public SysRole getMyRole(Long uid);
	
	//查询角色及相应说明
	public List<SysRole> getRoleLst();
	
	//修改账号员工密码
	public void updateUserPassw(String password, SysUsers user);
}
