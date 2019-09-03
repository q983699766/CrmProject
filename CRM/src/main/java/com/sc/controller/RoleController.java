package com.sc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysRole;
import com.sc.service.RolesService;

@Controller
@RequestMapping("rolesctlr")
public class RoleController {
	
	@Autowired
	RolesService RolesService;
	
	@RequestMapping("/getlist.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req, HttpSession session){
		
		List<SysRole> list = RolesService.getRoleList();
		
		mav.addObject("roles", list);
		System.out.println(list);
		
		mav.setViewName("permission/roles");
		return mav;
	
	}
	
	
}
