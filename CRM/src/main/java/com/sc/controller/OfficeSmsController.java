package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/officectlr")
public class OfficeSmsController {

	
	@RequestMapping("/sms.do")
	public ModelAndView reg(ModelAndView mav){
//		mav.setViewName("custom/conper");
		mav.setViewName("wanchenglong/guestbook");
		return mav;
	}
	
	@RequestMapping("/agenda.do")
	public ModelAndView agenda(ModelAndView mav){
//		mav.setViewName("custom/conper");
		mav.setViewName("wanchenglong/agenda");
		return mav;
	}
	
	
	@RequestMapping("/agenda1.do")
	public ModelAndView agenda1(ModelAndView mav){
//		mav.setViewName("custom/conper");
		System.out.println("进入agenda1");
		mav.setViewName("wanchenglong/schedule");
		return mav;
	}

}
