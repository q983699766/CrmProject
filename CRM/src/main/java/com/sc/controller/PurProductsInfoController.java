package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.service.PurProductsInfoService;

@Controller//注册成bean对象
@RequestMapping("/pur")
public class PurProductsInfoController {

	@Autowired
	PurProductsInfoService purProductsInfoService;
	//1.分页查看仓库商品列表（以测试）
			@RequestMapping("/ck.do")
			public ModelAndView ck(ModelAndView mav,
					@RequestParam(defaultValue="1")Integer pageNum,
					@RequestParam(defaultValue="5")Integer pageSize,Long purInfoNumber ){
				
				System.out.println("aaaaaaa"+purInfoNumber);
				//添加模型数据
			   mav.addObject("pi", purProductsInfoService.selectPurOrderInfo(pageNum, pageSize,purInfoNumber));
			   
				//设置视图名称         转发
				mav.setViewName("Ck/cclb");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
	
}
