package com.sc.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.bean.SysUsers;
import com.sc.service.SysUsersService;

public class CustomRealmMd5 extends AuthorizingRealm {

	//注入用户的service
	@Autowired
	SysUsersService sysuserService;
	
	/*@Autowired
	SysPermissionService syspermissionService;*/
	
	//用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		System.out.println("进入用户授权");
		SysUsers sysuser = (SysUsers)arg0.getPrimaryPrincipal();
		System.out.println("需要授权的用户是："+sysuser.getUserName());
		
		//通过用户名从数据库查询该用户所拥有的权限
		/*ArrayList<String> perms = new ArrayList<String>();
		List<SysPermission> list = syspermissionService.getPermsByUid(sysuser.getId());
		
		if(list != null && list.size() > 0){
			for (SysPermission per : list) {
				String percode = per.getPercode();
				if(percode != null && !percode.equals("")){
					perms.add(per.getPercode());
					System.out.println("------该用户拥有的权限资源是："+per.getPercode());
				}
				
			}
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(perms != null && perms.size() > 0){
			info.addStringPermissions(perms);
		}
		return info;*/
		
		return null;
	}

	
	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("进入自定义realm");
		//获取登录的用户名
		String uname = (String)arg0.getPrincipal();
		System.out.println("登录的用户名是：" + uname);
		
		SysUsers sysuser = sysuserService.login(uname);
		System.out.println("数据库查询的用户对象是："+sysuser);
		//通过该用户名查询数据库是否存在该用户
		if(sysuser == null){
			return null;//不存在此用户，直接返回
		}
		
		String pass = sysuser.getUserPassword();
		String salt = "qwerty";
		//把用户名和密码传入，验证密码是否正确
		SimpleAuthenticationInfo info = 
				new SimpleAuthenticationInfo(sysuser, pass, ByteSource.Util.bytes(salt), super.getName());
		
		return info;
	}

}
