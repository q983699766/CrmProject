package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.service.SysDutyService;

@Controller
@RequestMapping("sysdutyctlr")
public class sysDutyController {
	@Autowired
	SysDutyService sysDutyService;
	
	@RequestMapping("/list.do")
	public ModelAndView test(ModelAndView mav){
		System.out.println("进来啦！");
		mav.addObject("look", sysDutyService.selectDuty());
		System.out.println(sysDutyService.selectDuty());
		mav.setViewName("gongsi/Products_List");
		return mav;
	}

}
