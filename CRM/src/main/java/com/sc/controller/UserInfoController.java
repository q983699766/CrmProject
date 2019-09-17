package com.sc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysEmpuser;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersExample;
import com.sc.bean.SysUsersExample.Criteria;
import com.sc.service.RolesService;
import com.sc.service.UserInfoService;

@Controller
@RequestMapping("userinfoctlr")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	RolesService RolesService;
	
	@RequestMapping("/getinfo.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req, HttpSession session){
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		
		Long userId = user.getUserId();
		
		mav.addObject("role", userInfoService.getMyRole(userId));
		
		mav.addObject("roles", RolesService.getRoleList());
		
		mav.setViewName("permission/admin_info");
		return mav;
		
		
	
	}
	
	@RequestMapping("/updatePassword.do")
	public ModelAndView updatePassword(ModelAndView mav , HttpServletRequest req, String password, HttpSession session,String oldpass){
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		
		Long userId = user.getUserId();
		
		mav.addObject("role", userInfoService.getMyRole(userId));
		
		mav.addObject("roles", RolesService.getRoleList());
		
		String old = user.getUserPassword();
		
		String salt = "qwerty";
		int count = 3;
		
		Md5Hash m = new Md5Hash(oldpass, salt, count);
		String pass = m.toString();	
		
		if(old.equals(pass)){
			userInfoService.updateUserPassw(password, user);
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			mav.addObject("success", "success");
			mav.setViewName("redirect:../login.jsp?fail=success");
			return mav;
		}else{
			
			mav.addObject("success", "fail");
			mav.setViewName("permission/admin_info");
			return mav;
		}
		
	}
	
}
