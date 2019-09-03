package com.sc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysUsers;
import com.sc.service.UsersService;

@Controller
@RequestMapping("usersctlr")
public class UsersController {
	
	@Autowired
	UsersService UsersService;
	
	@RequestMapping("/getlist.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req, HttpSession session){
		
		List<SysUsers> list = UsersService.getUsersList();
		
		mav.addObject("users", list);
		
		mav.setViewName("permission/users");
		return mav;
	
	}
	
}
