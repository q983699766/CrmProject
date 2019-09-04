package com.sc.controller;

import java.util.Date;
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
	
	@RequestMapping("/add.do")
	public ModelAndView update(ModelAndView mav , HttpServletRequest req, SysUsers user){
		
		Date date = new Date();
		user.setLastTime(date);
		
		UsersService.addUser(user);
		List<SysUsers> list = UsersService.getUsersList();
		
		mav.addObject("users", list);
		
		mav.setViewName("permission/users");
		return mav;
	}
	
	
	@RequestMapping("/del.do")
	public ModelAndView delById(ModelAndView mav , HttpServletRequest req, Long userId){
		
		UsersService.delUser(userId);
		
		List<SysUsers> list = UsersService.getUsersList();
		
		mav.addObject("users", list);
		mav.setViewName("permission/users");
		
		return mav;
	}
	
	
	@RequestMapping("/updatesta.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req, Long userId){
		

		SysUsers user = UsersService.selectById(userId);
		
		String userState = user.getUserState();
		
		if(userState.equals("0")){
			user.setUserState("1");
			Date date = new Date();
			user.setLastTime(date);
			UsersService.updateUser(user);
			
		}else{
			user.setUserState("0");
			Date date = new Date();
			user.setLastTime(date);
			UsersService.updateUser(user);
		}
		
		List<SysUsers> list = UsersService.getUsersList();
		
		mav.addObject("users", list);
		mav.setViewName("permission/users");
		return mav;
	
	}
	
	
	@RequestMapping("/getlist.do")
	public ModelAndView updateUserSta(ModelAndView mav , HttpServletRequest req, HttpSession session){
		
		List<SysUsers> list = UsersService.getUsersList();
		
		mav.addObject("users", list);
		
		mav.setViewName("permission/users");
		return mav;
	
	}
}
