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

}
