package com.sc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("/bleed.do")
	public ModelAndView bleed(ModelAndView mav,HttpServletResponse resp){
		mav.setViewName("custom/bleed");
		try {
			resp.getWriter().write("<script> layer.close(index)</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
	
}
