package com.sc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.PurSupInfo;
import com.sc.service.PurSupInfoService;

@Controller
@RequestMapping("/pursupinfo")
public class PurSupInfoController {

	@Autowired
	PurSupInfoService pursupinfoservice;
	
	//查询所有供应商信息
	@RequestMapping("/selectinfo.do")
	public ModelAndView selectinfo (ModelAndView mav){
		System.out.println("进入查询供应商信息方法");
		mav.addObject("info", pursupinfoservice.selectByExample(null));
		System.out.println(pursupinfoservice.selectByExample(null));
	    mav.setViewName("jinhuo/supinfo");
		
	    return mav;
	}
	



	//跳转到添加页面
		@RequestMapping("/goaddinfo.do")
		public ModelAndView goadd(ModelAndView mav){
			mav.setViewName("jinhuo/supinfo");
			return mav;
		}
		
	
		//添加用户
		@RequestMapping("/addinfo.do")
		public ModelAndView add(ModelAndView mav,
				MultipartFile files,
				HttpServletRequest req,
				PurSupInfo pursupinfo){ 
			System.out.println("添加的用户信息是："+pursupinfo);
		    pursupinfoservice.addinfo(pursupinfo);
			
			//重定向到列表方法
			mav.setViewName("redirect:selectinfo.do");
			return mav;
		}
	
	
	
	//修改用户
	@RequestMapping("/updateinfo.do")
	public ModelAndView updateinfo(ModelAndView mav,
			PurSupInfo pursupinfo){ 
		System.out.println("修改的的用户信息是："+pursupinfo);
	    pursupinfoservice.updateinfo(pursupinfo.getSupInfoNum());
		
		//重定向到列表方法
		mav.setViewName("redirect:selectinfo.do");
		return mav;
	}
	 //删除信息
  @RequestMapping("/delinfo.do")
	public ModelAndView del(ModelAndView mav,PurSupInfo pursupinfo){
		System.out.println("删除的用户信息是："+pursupinfo);
		pursupinfoservice.delinfo(pursupinfo.getSupInfoNum());
		//重定向到列表方法
		mav.setViewName("redirect:selectinfo.do");
		return mav;
	}
	
	
}
