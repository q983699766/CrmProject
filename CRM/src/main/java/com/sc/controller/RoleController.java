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
import com.sc.service.RolesService;

@Controller
@RequestMapping("rolesctlr")
public class RoleController {
	
	@Autowired
	RolesService RolesService;
	
	@RequestMapping("/update.do")
	public ModelAndView update111(ModelAndView mav, HttpSession session , HttpServletRequest req, SysRole role){
		
		Date date = new Date();
		role.setLastTime(date);
		SysUsers u = (SysUsers)session.getAttribute("nowuser");
		
		Long uid = u.getUserId();
		role.setOperatorId(uid);
		
		RolesService.updateRole(role);
		List<SysRole> list = RolesService.getRoleList();
		
		mav.addObject("roles", list);
		
		mav.setViewName("permission/roles");
		return mav;
	}
	
	
	@RequestMapping("/selectById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public SysRole selectById(ModelAndView mav , HttpServletRequest req){
		String shiidstr = req.getParameter("roleId");
		Long roleId =(long) Integer.parseInt(shiidstr);
		
		SysRole role = RolesService.selectById(roleId);
		return role;
	}
	
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav , HttpServletRequest req, SysRole role, HttpSession session){
		
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		
		Long userId = user.getUserId();
		
		role.setOperatorId(userId);
		
		Date date = new Date();
		role.setLastTime(date);
		
		RolesService.addRole(role);
		
		List<SysRole> list = RolesService.getRoleList();
		
		mav.addObject("roles", list);
		
		mav.setViewName("permission/roles");
		return mav;
	}
	
	
	@RequestMapping("/del.do")
	public ModelAndView del(ModelAndView mav , HttpServletRequest req, Long roleId){
		RolesService.delRole(roleId);
		
		List<SysRole> list = RolesService.getRoleList();
		
		mav.addObject("roles", list);
		
		
		mav.setViewName("permission/roles");
		return mav;
	}
	
	@RequestMapping("/getlist.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req, HttpSession session){
		
		List<SysRole> list = RolesService.getRoleList();
		
		mav.addObject("roles", list);
		
		
		mav.setViewName("permission/roles");
		return mav;
	
	}
	
	
}
