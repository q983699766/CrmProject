package com.sc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysUsers;
import com.sc.service.SysUsersService;

@Controller
@RequestMapping("loginctlr")
public class LoginController {


	@Autowired
	SysUsersService sysuserservice;
	
	
	@RequestMapping("/login.do")
	public ModelAndView login(ModelAndView mav , HttpServletRequest req){
		System.out.println("登录失败了");
		String msg = (String)req.getAttribute("shiroLoginFailure");
		System.out.println("失败原因："+msg);
		String fail = "";
		if(msg != null ){
			if(msg.equals(UnknownAccountException.class.getName())){
				fail = "nouser";
			}else if(msg.equals(IncorrectCredentialsException.class .getName())){
				fail = "error";
			}else if(msg.equals("randomCodeError")){
				fail = "codeerror";
			}else{
				fail = "unknown";
			}
		}
		
		mav.setViewName("redirect:../login.jsp?fail="+fail);
		return mav;
	}
	
	@RequestMapping("/main.do")
	public ModelAndView main(ModelAndView mav , HttpSession session){
		System.out.println("登录成功了");
		
		
		Subject subject = SecurityUtils.getSubject();
		
		SysUsers sysusers = (SysUsers)subject.getPrincipal();
		
		session.setAttribute("nowuser", sysusers);
		
		
		mav.setViewName("redirect:../index.jsp");
		return mav;
	}
	
}
