package com.sc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysUsers;

@Controller
@RequestMapping("userinfoctlr")
public class UserInfoController {
	
	@RequestMapping("/getinfo.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req, HttpSession session){
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		Long empId = user.getEmpId();
		
		
		
		mav.setViewName("permission/admin_info");
		return mav;
	
	}
	
}
