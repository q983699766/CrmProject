package com.sc.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.bean.SysPermission;
import com.sc.bean.SysUsers;
import com.sc.service.PermissionService;
import com.sc.service.SysUsersService;

public class CustomRealmMd5 extends AuthorizingRealm {

	
	@Autowired
	SysUsersService sysuserService;
	
	@Autowired
	PermissionService permissionService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("88888888888888888进入授权方法了！！！！");
		
		SysUsers sysuser = (SysUsers)arg0.getPrimaryPrincipal();
		System.out.println("获取到的对象是：7777777777777777777"+sysuser);
		Long uid = sysuser.getUserId();
		
		
		ArrayList<String> perms = new ArrayList<String>();
		List<SysPermission> list = permissionService.getMyPerm(uid);
		System.out.println("*****************"+list);
		if(list != null && list.size() > 0){
			for (SysPermission per : list) {
				String percode = per.getRemark();
				if(percode != null && !percode.equals("")){
					perms.add(percode);
				}
				
			}
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(perms != null && perms.size() > 0){
			info.addStringPermissions(perms);
		}
		return info;
	}

	

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		
		String uname = (String)arg0.getPrincipal();
		System.out.println("获取到的MINGZI是：22222222222222222"+uname);
		
		SysUsers sysuser = sysuserService.login(uname);
		
		if(sysuser == null){
			return null;
		}
		
		String pass = sysuser.getUserPassword();
		String salt = "qwerty";
		
		SimpleAuthenticationInfo info = 
				new SimpleAuthenticationInfo(sysuser, pass, ByteSource.Util.bytes(salt), super.getName());
		
		return info;
	}

}
