package com.sc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionRole;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.service.PermissionService;
import com.sc.service.RolesService;

@Controller
@RequestMapping("permisctlr")
public class PermissionController {
		
	@Autowired
	PermissionService PermissionService;
	
	@Autowired
	RolesService RolesService;
	
	
	@RequestMapping("/reset.do")
	public ModelAndView reset(ModelAndView mav , HttpSession session, HttpServletRequest req){
		
		PermissionService.reset();
		
		List<SysRole> list = RolesService.getRoleList();
		
		mav.addObject("roles", list);
		
		mav.setViewName("permission/roles");
		return mav;
	}
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav , HttpSession session, HttpServletRequest req, Long role, Long perm){
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		Long userId = user.getUserId();
		
		Date date = new Date();
		
		SysPermissionRole PR = new SysPermissionRole();
		PR.setLastTime(date);
		PR.setPermissionId(perm);
		PR.setRoleId(role);
		PR.setOperatorId(userId);
		
		PermissionService.roleAddPerm(PR);
		
		List<SysRole> list = RolesService.getRoleList();
		
		mav.addObject("roles", list);
		
		mav.setViewName("permission/roles");
		return mav;
	}
	
	
	@RequestMapping("/del.do")
	public ModelAndView del(ModelAndView mav , HttpServletRequest req, Long permId){
		PermissionService.delPerm(permId);
		
		List<SysPermission> list = PermissionService.getPermList();
		
		mav.addObject("perms", list);
		
		mav.setViewName("permission/user_role");
		return mav;
	}
	
	
		@RequestMapping("/getPermission.do")
		public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req){
			
			List<SysPermission> list = PermissionService.getPermList();
			
			mav.addObject("perms", list);
			List<SysRole> list2 = RolesService.getRoleList();
			
			mav.addObject("roles", list2);
			
			mav.setViewName("permission/user_role");
			return mav;
		
		}
		
	}
