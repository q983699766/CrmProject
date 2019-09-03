package com.sc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysPermission;
import com.sc.service.PermissionService;

@Controller
@RequestMapping("permisctlr")
public class PermissionController {
		
	@Autowired
	PermissionService PermissionService;
	
		@RequestMapping("/getPermission.do")
		public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req){
			
			List<SysPermission> list = PermissionService.getPermList();
			
			mav.addObject("perms", list);
			
			mav.setViewName("permission/user_role");
			return mav;
		
		}
		
	}
