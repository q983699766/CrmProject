package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.PurSupInfo;
import com.sc.bean.Users;
import com.sc.mapper.PurSupInfoMapper;
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
	
	//跳转到修改供应商信息表
	@RequestMapping("/goupdateinfo.do")
	@ResponseBody
	public PurSupInfo goupdateinfo (ModelAndView mav,Long  supinfonum ){
		System.out.println("进入跳转修改供应商信息页面的方法");
		
		return  pursupinfoservice.SelectById(supinfonum);
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
	
	//添加
	@RequestMapping("/addinfo.do")
	public ModelAndView addinfo (ModelAndView mav,PurSupInfo pursupinfo){
		 pursupinfoservice.addinfo(pursupinfo);
		 mav.setViewName("jinhuo/supinfo");
		
	    return mav;
	}
	
	
}
