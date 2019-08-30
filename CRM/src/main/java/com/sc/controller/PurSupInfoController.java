package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.mapper.PurSupInfoMapper;
import com.sc.service.PurSupInfoService;

@Controller
@RequestMapping("/pursupinfo")
public class PurSupInfoController {

	@Autowired
	PurSupInfoService pursupinfoservice;
	
	@RequestMapping("/selectinfo.do")
	public ModelAndView selectinfo (ModelAndView mav){
		System.out.println("进入查询供应商信息方法");
	mav.setViewName("jinhuo/supinfo");
		return mav;
		
	}
	
	
}
