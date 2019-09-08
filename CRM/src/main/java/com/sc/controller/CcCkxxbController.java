package com.sc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.CcCkxxb;
import com.sc.service.CcCkxxbService;

@Controller//注册成bean对象
@RequestMapping("/ccckxxctlr")
public class CcCkxxbController {

	@Autowired
	CcCkxxbService ccCkxxbService;
	//1.分页查看仓库商品列表（以测试）
			@RequestMapping("/ck.do")
			public ModelAndView ck(ModelAndView mav,
					@RequestParam(defaultValue="1")Integer pageNum,
					@RequestParam(defaultValue="5")Integer pageSize ){
				
				System.out.println("aaaaaaa");
				//添加模型数据
			   mav.addObject("pi", ccCkxxbService.selectCcCcxxPage(pageNum, pageSize));
			   
				//设置视图名称         转发
				mav.setViewName("Ck/cclb");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
	
			
		//添加
		@RequestMapping("/add.do")
		
		public ModelAndView add(ModelAndView mav , CcCkxxb u ){
			
			System.out.println("aaaaaaa"+u);
			Date date = new Date();
			u.setLastTime(date);
			
			//添加模型数据
			ccCkxxbService.addCcCkxx(u);
		   
			//设置视图名称         转发
			mav.setViewName("redirect:ck.do");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
			return mav;
		}
	
		//删除
		@RequestMapping("del.do")
		public ModelAndView del(ModelAndView mav,Long uid){
			
			System.out.println("接收到的fwid为"+uid);
			ccCkxxbService.delCcCkxx(uid);
			//重定向到列表方法
			mav.setViewName("redirect:ck.do");
			return mav;
		}
		
		
}
