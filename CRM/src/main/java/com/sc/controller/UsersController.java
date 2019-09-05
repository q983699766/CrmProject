package com.sc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersRole;
import com.sc.mapper.SysRoleMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.mapper.SysUsersRoleMapper;
import com.sc.service.RolesService;
import com.sc.service.UsersService;

@Controller
@RequestMapping("usersctlr")
public class UsersController {
	
	@Autowired
	UsersService UsersService;
	
	@Autowired
	RolesService RolesService;
	
	@Autowired
	SysUsersRoleMapper SysUsersRoleMapper;
	
	@RequestMapping("/update.do")
	public ModelAndView update111(ModelAndView mav, HttpSession session , HttpServletRequest req, SysUsers user, Long roleId){
		
		Date date = new Date();
		user.setLastTime(date);
		
		SysUsers u = (SysUsers)session.getAttribute("nowuser");
		
		Long uid = u.getUserId();
		
		UsersService.updateUserRole(user, roleId, uid);
		List<SysUsers> list = UsersService.getUsersList();
		
		mav.addObject("users", list);
		
		mav.setViewName("permission/users");
		return mav;
	}
	
	@RequestMapping("/selectById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public SysUsers selectById(ModelAndView mav , HttpServletRequest req){
		String shiidstr = req.getParameter("userId");
		Long userId =(long) Integer.parseInt(shiidstr);
		System.out.println("获取到的用户编号为:"+userId);
		SysUsers user = UsersService.selectById(userId);
		return user;
	}
	
	
	@RequestMapping("/add.do")
	public ModelAndView update(ModelAndView mav , HttpSession session, HttpServletRequest req, SysUsers user, Long roleId){
		
		Date date = new Date();
		user.setLastTime(date);
		SysUsers us = (SysUsers)session.getAttribute("nowuser");
		Long uid = us.getUserId();
		
		UsersService.addUser(user);
		
		String userName = user.getUserName();
		
		SysUsers u = UsersService.selectByName(userName);
		Long userId = u.getUserId();
		
		SysUsersRole sysUsersRole = new SysUsersRole();
		sysUsersRole.setLastTime(date);
		sysUsersRole.setOperatorId(uid);
		sysUsersRole.setRoleId(roleId);
		sysUsersRole.setUserId(userId);
		
		SysUsersRoleMapper.insert(sysUsersRole);
		
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
		
		List<SysRole> list2 = RolesService.getRoleList();
		
		mav.addObject("users", list);
		mav.addObject("roles", list2);
		
		mav.setViewName("permission/users");
		return mav;
	
	}
}
