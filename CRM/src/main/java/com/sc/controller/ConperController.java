package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("conperctlr")
public class ConperController {

	@RequestMapping("/conper.do")
	public ModelAndView conper(ModelAndView mav){
		mav.setViewName("custom/conper");
		return mav;
	}
}
