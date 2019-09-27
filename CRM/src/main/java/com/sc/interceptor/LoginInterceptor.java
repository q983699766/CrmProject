package com.sc.interceptor;

import java.net.InetAddress;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysLog;
import com.sc.bean.SysUsers;
import com.sc.service.SysLogService;
@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	SysLogService sls;
	 

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//System.out.println("3、请求完成执行");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		//System.out.println("2、请求之后执行");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		String servletPath = arg0.getServletPath();//获取到url地址
		String permissionName = sls.getPermissionName(servletPath);
		HttpSession session = arg0.getSession();
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		System.out.println("用户权限："+permissionName);
		System.out.println("url："+servletPath);
		if(user != null){
			System.out.println("当前用户："+user.getUserName());
			if((!"null".equals(permissionName))&&(!"查看日志".equals(permissionName))){
				String hostAddress = InetAddress.getLocalHost().getHostAddress();
				Date date = new Date();
				SysLog sysLog = new SysLog(null, user.getUserId(), hostAddress, permissionName, date, user.getComId());
				sls.insertSysLog(sysLog);
			}
		}
		return true;
	}

}

