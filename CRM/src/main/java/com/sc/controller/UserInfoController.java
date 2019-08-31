package com.sc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysEmpuser;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.service.UserInfoService;

@Controller
@RequestMapping("userinfoctlr")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping("/getinfo.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req, HttpSession session){
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		
		Long userId = user.getUserId();
		
		mav.addObject("role", userInfoService.getMyRole(userId));
		
		mav.addObject("roles", userInfoService.getRoleLst());
		
		mav.setViewName("permission/admin_info");
		return mav;
	
	}
	
	@RequestMapping("/updatePassword.do")
	public ModelAndView updatePassword(ModelAndView mav , HttpServletRequest req, String password, HttpSession session,String oldpass){
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		
		String old = user.getUserPassword();
		
		String salt = "qwerty";
		int count = 3;
		
		Md5Hash m = new Md5Hash(oldpass, salt, count);
		String pass = m.toString();	
		
		if(old.equals(pass)){
			userInfoService.updateUserPassw(password, user);
			
			mav.addObject("success", "success");
			System.out.println("密码修改成功");
			mav.setViewName("permission/admin_info");
			return mav;
		}else{
			System.out.println("密码修改失败");
			mav.setViewName("permission/admin_info");
			return mav;
		}
		
	}
	
}
