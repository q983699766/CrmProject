package com.sc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SysPermissionRole;
import com.sc.bean.SysRole;
import com.sc.bean.SysRoleExample;
import com.sc.bean.SysRoleExample.Criteria;
import com.sc.bean.SysUsers;
import com.sc.mapper.SysPermissionRoleMapper;
import com.sc.mapper.SysRoleMapper;
import com.sc.service.RolesService;

@Controller
@RequestMapping("rolesctlr")
public class RoleController {
	
	@Autowired
	RolesService RolesService;
	
	@Autowired
	SysRoleMapper SysRoleMapper;
	
	@Autowired
	SysPermissionRoleMapper SysPermissionRoleMapper;
	
	@RequestMapping("/update.do")
	public ModelAndView update111(ModelAndView mav, HttpSession session , HttpServletRequest req, SysRole role){
		
		Integer ok = null;
		
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
			ok=1;
		}else if(list3.size() ==1){
			if(list3.get(0).getRoleId() == role.getRoleId()){
				Date date = new Date();
				role.setLastTime(date);
				SysUsers u = (SysUsers)session.getAttribute("nowuser");
				
				Long uid = u.getUserId();
				role.setOperatorId(uid);
				
				RolesService.updateRole(role);
				ok=1;
			}else{
				ok=1;
			}	
		}else {
			ok=2;
		}
		
		mav.setViewName("redirect:../rolesctlr/getlist.do?ok="+ok);
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
		
		Integer ok = null;
		
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
			
			SysRoleExample sysRoleExample1 = new SysRoleExample();
			Criteria c1 = sysRoleExample1.createCriteria();
			c1.andRoleNameEqualTo(rname);
			List<SysRole> selectByExample1 = SysRoleMapper.selectByExample(sysRoleExample1);
			
			SysRole sysRole = selectByExample1.get(0);
			Long roleId = sysRole.getRoleId();
			
			SysPermissionRole PR = new SysPermissionRole();
			Long PID = (long) 154;
			PR.setPermissionId(PID);
			PR.setRoleId(roleId);
			PR.setLastTime(date);
			PR.setOperatorId(userId);
			
			SysPermissionRoleMapper.insert(PR);
			
			ok=1;
		}else{
			ok=2;
		}
		
		
		
		mav.setViewName("redirect:../rolesctlr/getlist.do?ok="+ok);
		return mav;
	}
	
	
	@RequestMapping("/del.do")
	public ModelAndView del(ModelAndView mav , HttpServletRequest req, Long roleId){
		
		Integer ok = null;
		
		SysRoleExample sysRoleExample = new SysRoleExample();
		Criteria c = sysRoleExample.createCriteria();
		c.andHigherRoleIdEqualTo(roleId);
		
		List<SysRole> selectByExample = SysRoleMapper.selectByExample(sysRoleExample);
		
		if(selectByExample.isEmpty()){
			RolesService.delRole(roleId);
			ok=1;
		}else {
			ok=3;
		}
		
		
		mav.setViewName("redirect:../rolesctlr/getlist.do?ok="+ok);
		return mav;
	}
	
	@RequestMapping("/getlist.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req
			, HttpSession session,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,Integer ok){
		
		PageInfo<SysRole> list = RolesService.selectRolePage(pageNum, pageSize);
		
		mav.addObject("list", list);
		
		mav.addObject("ok", ok);
		mav.setViewName("permission/roles");
		return mav;
	
	}
	
	
}
