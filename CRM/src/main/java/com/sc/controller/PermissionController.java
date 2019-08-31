package com.sc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("permisctlr")
public class PermissionController {
		
		@RequestMapping("/getPermission.do")
		public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req){
			mav.setViewName("permission/user_role");
			return mav;
		
		}
		
	}
