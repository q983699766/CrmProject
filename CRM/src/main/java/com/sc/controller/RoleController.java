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
import com.sc.bean.SysRoleExample;
import com.sc.bean.SysRoleExample.Criteria;
import com.sc.bean.SysUsers;
import com.sc.mapper.SysRoleMapper;
import com.sc.service.RolesService;

@Controller
@RequestMapping("rolesctlr")
public class RoleController {
	
	@Autowired
	RolesService RolesService;
	
	@Autowired
	SysRoleMapper SysRoleMapper;
	
	@RequestMapping("/update.do")
	public ModelAndView update111(ModelAndView mav, HttpSession session , HttpServletRequest req, SysRole role){
		
		String rname = role.getRoleName();
		SysRoleExample sysRoleExample = new SysRoleExample();
		Criteria c = sysRoleExample.createCriteria();
		c.andRoleNameEqualTo(rname);
		
		List<SysRole> list3 = SysRoleMapper.selectByExample(sysRoleExample);
		
		if(list3.size() == 0){
			Date date = new Date();
			role.setLastTime(date);
			SysUsers u = (SysUsers)session.getAttribute("nowuser");
			
			Long uid = u.getUserId();
			role.setOperatorId(uid);
			
			RolesService.updateRole(role);
			mav.addObject("ok", "1");
		}else if(list3.size() ==1){
			if(list3.get(0).getRoleId() == role.getRoleId()){
				Date date = new Date();
				role.setLastTime(date);
				SysUsers u = (SysUsers)session.getAttribute("nowuser");
				
				Long uid = u.getUserId();
				role.setOperatorId(uid);
				
				RolesService.updateRole(role);
				mav.addObject("ok", "1");
			}else{
				mav.addObject("ok", "2");
			}	
		}else {
			mav.addObject("ok", "2");
		}
		
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
		
		String rname = role.getRoleName();
		SysRoleExample sysRoleExample = new SysRoleExample();
		Criteria c = sysRoleExample.createCriteria();
		c.andRoleNameEqualTo(rname);
		List<SysRole> selectByExample = SysRoleMapper.selectByExample(sysRoleExample);
		
		if(selectByExample.isEmpty()){
			SysUsers user = (SysUsers)session.getAttribute("nowuser");
			
			Long userId = user.getUserId();
			
			role.setOperatorId(userId);
			
			Date date = new Date();
			role.setLastTime(date);
			
			RolesService.addRole(role);
			mav.addObject("ok", "1");
		}else{
			mav.addObject("ok", "2");
		}
		
		
		
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
		
		mav.addObject("ok", "1");
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
