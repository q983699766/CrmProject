package com.sc.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sc.bean.SysPermission;
import com.sc.bean.SysUsers;
import com.sc.formAuthenticationFilter.CustomFormAuthenticationFilter;
import com.sc.mapper.SysPermissionMapper;
import com.sc.mapper.SysPermissionRoleMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.mapper.SysUsersRoleMapper;
import com.sc.realm.CustomRealmMd5;
import com.sc.service.PermissionService;

@Configuration
public class ShiroConfiguration {

	/*@Resource
	SysPermissionService sysPermissionInfoService;*/
	
	@Resource
	PermissionService PermissionService;
	
	@Bean
	public CustomRealmMd5 customRealmMD5(){
		CustomRealmMd5 realm=new CustomRealmMd5();
		HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
		matcher.setHashIterations(3);
		matcher.setHashAlgorithmName("md5");
		realm.setCredentialsMatcher(matcher);
		return realm;
	}
	
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		//DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
		//sessionManager.setGlobalSessionTimeout(600000);
		//sessionManager.setDeleteInvalidSessions(true);
		//securityManager.setSessionManager(sessionManager);
		
		securityManager.setRealm(customRealmMD5());
		return securityManager;
	}
	
	/**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(){
		
		CustomFormAuthenticationFilter formAuthenticationFilter=new CustomFormAuthenticationFilter();
		formAuthenticationFilter.setLoginUrl("/loginctlr/login.do");
		formAuthenticationFilter.setUsernameParam("uname");
		formAuthenticationFilter.setPasswordParam("upass");
		/*formAuthenticationFilter.setRememberMeParam("randomcode");*/
		formAuthenticationFilter.setRememberMeParam("rememberme");
		
		ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager());
		shiroFilter.setLoginUrl("/login.jsp");
		shiroFilter.setSuccessUrl("/loginctlr/main.do");
		shiroFilter.setUnauthorizedUrl("/refuse.jsp");
		
		Map<String, Filter> map=new HashMap<String, Filter>();
		map.put("authc", formAuthenticationFilter);
		
		LogoutFilter logoutFilter=new LogoutFilter();
		logoutFilter.setRedirectUrl("/login.jsp");
		map.put("logout", logoutFilter);
		
		PermissionsAuthorizationFilter permsFilter=new PermissionsAuthorizationFilter(); 
		map.put("perms", permsFilter);
		shiroFilter.setFilters(map);
		
		Map<String, String> filterChainDefinitionMap=new LinkedHashMap<String, String>();
		//静态资源可匿名访问
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/lib/**", "anon");
		filterChainDefinitionMap.put("/schedule/**", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/temp/**", "anon");
		filterChainDefinitionMap.put("/upload/**", "anon");
		filterChainDefinitionMap.put("/assets/**", "anon");
		filterChainDefinitionMap.put("/font/**", "anon");
		filterChainDefinitionMap.put("/products/**", "anon");
		filterChainDefinitionMap.put("/Widget/**", "anon");
		filterChainDefinitionMap.put("/My97DatePicker/**", "anon");
		filterChainDefinitionMap.put("loginctlr/ajaxlogout.do", "anon");
		filterChainDefinitionMap.put("loginctlr/islogin.do", "anon");
		filterChainDefinitionMap.put("/validatecode.jsp", "anon");
		filterChainDefinitionMap.put("/login.jsp", "anon");
		filterChainDefinitionMap.put("/index.jsp", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		
		
		//设置功能权限
		/*SysUsers user = (SysUsers)session.getAttribute("nowuser");
		Long uId = user.getUserId();
		List<SysPermission> myPerm = PermissionService.getMyPerm(uId);
		for (SysPermission sysPermission : myPerm) {
			if(sysPermission.getPermissionName()!=null&&!sysPermission.getPermissionName().equals("")
					&&sysPermission.getPermission()!=null&&!sysPermission.getPermission().equals("")	){
					System.out.println("===1=="+sysPermission.getPermission()+"====="+sysPermission.getPermissionName());
					filterChainDefinitionMap.put(sysPermission.getPermission(), "perms["+sysPermission.getPermissionName()+"]");
				}
		}*/
		List<SysPermission> list=PermissionService.getPermList();
		for (SysPermission sysPermission : list) {
			if(sysPermission.getRemark()!=null&&!sysPermission.getRemark().equals("")
				&&sysPermission.getPermission()!=null&&!sysPermission.getPermission().equals("")	){
				System.out.println("===1=="+sysPermission.getPermission()+"====="+sysPermission.getRemark());
				//filterChainDefinitionMap.put("/userctrl/list.do", "perms[users:list]");
				filterChainDefinitionMap.put(sysPermission.getPermission(), "perms["+sysPermission.getRemark()+"]");
			}
		}
		
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilter;
	}
}
