package com.sc.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sc.formAuthenticationFilter.CustomFormAuthenticationFilter;
import com.sc.realm.CustomRealmMd5;

@Configuration
public class ShiroConfiguration {

	/*@Resource
	SysPermissionService sysPermissionInfoService;*/
	
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
		formAuthenticationFilter.setRememberMeParam("randomcode");
		
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
		
		filterChainDefinitionMap.put("/validatecode.jsp", "anon");
		filterChainDefinitionMap.put("/login.jsp", "anon");
		filterChainDefinitionMap.put("/main.jsp", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		
		
		//设置功能权限
		/*List<SysPermission> list=sysPermissionInfoService.selectAllSysPermission();
		for (SysPermission sysPermission : list) {
			if(sysPermission.getSysRemarks()!=null&&!sysPermission.getSysRemarks().equals("")
				&&sysPermission.getSysPermission()!=null&&!sysPermission.getSysPermission().equals("")	){
				System.out.println("===1=="+sysPermission.getSysPermission()+"====="+sysPermission.getSysRemarks());
				filterChainDefinitionMap.put(sysPermission.getSysPermission(), "perms["+sysPermission.getSysRemarks()+"]");
			}
		}*/
		
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilter;
	}
}
