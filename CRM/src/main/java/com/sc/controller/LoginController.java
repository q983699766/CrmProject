package com.sc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.Message;
import com.sc.bean.SysUsers;
import com.sc.service.SysUsersService;

@Controller
@RequestMapping("loginctlr")
public class LoginController {


	@Autowired
	SysUsersService sysuserservice;
	
	
	@RequestMapping("/login.do")
	public ModelAndView login(ModelAndView mav , HttpServletRequest req){
		System.out.println("********登录失败了");
		String msg = (String)req.getAttribute("shiroLoginFailure");
		System.out.println("********失败原因："+msg);
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
	public ModelAndView main(ModelAndView mav , HttpSession session, HttpServletRequest req,HttpServletResponse resp){
		System.out.println("登录成功了");
		System.out.println((String) session.getAttribute("upass"));
		
		Subject subject = SecurityUtils.getSubject();
		
		SysUsers sysusers = (SysUsers)subject.getPrincipal();
		
		String rememberme = (String) session.getAttribute("rememberme");


		if(sysusers!=null){
					String uname=sysusers.getUserName();
					String upass=(String) session.getAttribute("upass");
					if (rememberme != null) {
						System.out.println("进入方法了");
						System.out.println("用户名"+uname);
						System.out.println("用户密码"+upass);
						Cookie c1 = new Cookie("uname", uname);// 存储用户名
						c1.setPath("/");//spring_boot需要加这句
						c1.setMaxAge(3*24 * 60 * 60);// 一天有效期
						Cookie c2 = new Cookie("upass", upass);// 存储密码
						c2.setPath("/");//spring_boot需要加这句
						c2.setMaxAge(3*24 * 60 * 60);// 一天有效期
						resp.addCookie(c1);// cookie存入response
						resp.addCookie(c2);// cookie存入response
					}
		}
		
		if(sysusers.getUserState().equals("0")){
			session.setAttribute("nowuser", sysusers);
			mav.setViewName("redirect:../index.jsp");
			return mav;
		}else{
			subject.logout();
			String fail = "state";
			mav.setViewName("redirect:../login.jsp?fail="+fail);
			return mav;
		}
	}
	
	@RequestMapping("/islogin.do")
	@ResponseBody
	public Message islogin(){
		System.out.println("进来了1");
		Message m = null;
		Subject subject = SecurityUtils.getSubject();
		boolean islogin = subject.isAuthenticated();
		if(islogin){
			m = new Message("200", "yes", "已有登录用户");
		}else{
			m = new Message("100", "no", "可正常登录");
		}
		return m;
	}
	@RequestMapping("/ajaxlogout.do")
	@ResponseBody
	public void ajaxlogout(){
		System.out.println("进来了2");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
}
