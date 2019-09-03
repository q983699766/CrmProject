package com.sc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SalCustomInfo;
import com.sc.service.ConperService;

@Controller
@RequestMapping("conctlr")
public class ConperController2 {

	@Autowired
	ConperService conperService;
	//查询所有客户--销售经理可以进
	@RequestMapping("/custom.do")
	public ModelAndView custom(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize ){
		System.out.println("用户进来了！！");
		mav.addObject("pi", conperService.selectSalCustomInfoPage(pageNum, pageSize));
		mav.setViewName("custom/conper");
		return mav;	
	}
	
	@RequestMapping("/selectById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public SalCustomInfo selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
		String customId = req.getParameter("customId");
		Long uid =(long) Integer.parseInt(customId);
		System.out.println("获取到的用户编号为:"+uid);
		SalCustomInfo custom = conperService.selectById(uid);
		
		System.out.println("查出的用户为"+custom);
		return custom;
	}
	
}
