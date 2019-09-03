package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.service.CcSpxxService;

@Controller//注册成bean对象
@RequestMapping("/ccxxctlr")
public class CcCkSpxxbController {
	@Autowired
	CcSpxxService ccSpxxService ;
	//1.分页查看房屋列表（以测试）
			@RequestMapping("/list.do")
			public ModelAndView list(ModelAndView mav,
					@RequestParam(defaultValue="1")Integer pageNum,
					@RequestParam(defaultValue="5")Integer pageSize ){
				
				System.out.println("aaaaaaa");
				//添加模型数据
			   mav.addObject("pi", ccSpxxService.selectCcspxxPage(pageNum, pageSize));
			   
				//设置视图名称         转发
				mav.setViewName("Ck/aaa");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
}
