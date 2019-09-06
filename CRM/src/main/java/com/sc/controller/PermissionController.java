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

import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionColumn;
import com.sc.bean.SysPermissionRole;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.mapper.SysPermissionColumnMapper;
import com.sc.service.PermissionService;
import com.sc.service.RolesService;

@Controller
@RequestMapping("permisctlr")
public class PermissionController {
		
	@Autowired
	PermissionService PermissionService;
	
	@Autowired
	RolesService RolesService;
	
	@Autowired
	SysPermissionColumnMapper SysPermissionColumnMapper;
	
	
	@RequestMapping("/getPermByCol.do")
	public ModelAndView getPermByCol(ModelAndView mav , HttpSession session, HttpServletRequest req, String columnName){
		
		if(columnName.equals("all")){
			List<SysPermission> list = PermissionService.getPermList();
			mav.addObject("perms", list);
		}else{
			List<SysPermission> list = PermissionService.getPermListByCol(columnName);
			mav.addObject("perms", list);
		}
		
		List<SysRole> list2 = RolesService.getRoleList();
		mav.addObject("roles", list2);
		List<SysPermissionColumn> list3 = PermissionService.getColumn();
		mav.addObject("col", list3);
		
		mav.addObject("colName", columnName);
		mav.setViewName("permission/user_role");
		return mav;
	}
	
	
	@RequestMapping("/addpermcol.do")
	public ModelAndView addPermCol(ModelAndView mav , HttpSession session, HttpServletRequest req, SysPermissionColumn col){
		
		Date date = new Date();
		col.setLastTime(date);
		
		PermissionService.addPermcol(col);
		
		List<SysPermission> list = PermissionService.getPermList();
		mav.addObject("perms", list);
		List<SysRole> list2 = RolesService.getRoleList();
		mav.addObject("roles", list2);
		List<SysPermissionColumn> list3 = PermissionService.getColumn();
		mav.addObject("col", list3);
		
		mav.setViewName("permission/user_role");
		return mav;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav , HttpSession session, HttpServletRequest req, SysPermission perm, Long[] roleId, Long colId){
		
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		Long userId = user.getUserId();
		
		SysPermissionColumn col = SysPermissionColumnMapper.selectByPrimaryKey(colId);
		perm.setPermissionColumn(col.getColumnName());
		
		Date date = new Date();
		perm.setLastTime(date);
		System.out.println(perm.getPermissionColumn());
		PermissionService.updatePerm(perm, roleId, userId);
		
		List<SysPermission> list = PermissionService.getPermList();
		mav.addObject("perms", list);
		List<SysRole> list2 = RolesService.getRoleList();
		mav.addObject("roles", list2);
		List<SysPermissionColumn> list3 = PermissionService.getColumn();
		mav.addObject("col", list3);
		
		mav.setViewName("permission/user_role");
		return mav;
	}
	
	@RequestMapping("/addperm.do")
	public ModelAndView addperm(ModelAndView mav , HttpSession session, HttpServletRequest req, SysPermission perm, String columnName){
		
		Date date = new Date();
		
		perm.setLastTime(date);
		perm.setPermissionColumn(columnName);
		
		PermissionService.addPerm(perm);
		
		List<SysPermission> list = PermissionService.getPermList();
		mav.addObject("perms", list);
		List<SysRole> list2 = RolesService.getRoleList();
		mav.addObject("roles", list2);
		List<SysPermissionColumn> list3 = PermissionService.getColumn();
		mav.addObject("col", list3);
		
		mav.setViewName("permission/user_role");
		return mav;
	}
	
	@RequestMapping("/selectById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public SysPermission selectById(ModelAndView mav , HttpServletRequest req){
		String shiidstr = req.getParameter("permId");
		Long permId =(long) Integer.parseInt(shiidstr);
		
		SysPermission perm = PermissionService.selectById(permId);
		
		return perm;
	}
	
	
	@RequestMapping("/reset.do")
	public ModelAndView reset(ModelAndView mav , HttpSession session, HttpServletRequest req){
		
		PermissionService.reset();
		
		List<SysRole> list = RolesService.getRoleList();
		
		mav.addObject("roles", list);
		
		mav.setViewName("permission/roles");
		return mav;
	}
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav , HttpSession session, HttpServletRequest req, Long role, Long[] perm){
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		Long userId = user.getUserId();
		
		Date date = new Date();
		for (Long l1 : perm) {
			SysPermissionRole PR = new SysPermissionRole();
			PR.setLastTime(date);
			PR.setPermissionId(l1);
			PR.setRoleId(role);
			PR.setOperatorId(userId);
			
			PermissionService.roleAddPerm(PR);
		}
		
		
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
		List<SysRole> list2 = RolesService.getRoleList();
		mav.addObject("roles", list2);
		List<SysPermissionColumn> list3 = PermissionService.getColumn();
		mav.addObject("col", list3);
		
		mav.setViewName("permission/user_role");
		return mav;
	}
	
	
		@RequestMapping("/getPermission.do")
		public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req){
			
			List<SysPermission> list = PermissionService.getPermList();
			mav.addObject("perms", list);
			List<SysRole> list2 = RolesService.getRoleList();
			mav.addObject("roles", list2);
			List<SysPermissionColumn> list3 = PermissionService.getColumn();
			mav.addObject("col", list3);
			
			mav.setViewName("permission/user_role");
			return mav;
		
		}
		
	}
