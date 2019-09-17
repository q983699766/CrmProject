package com.sc.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ModelAndView selectinfo (ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize,PurSupInfo pursupinfo){
		
		System.out.println("进入查询供应商信息方法");
		mav.addObject("pi", pursupinfoservice.selectall(pageNum, pageSize,pursupinfo));
		System.out.println(pursupinfoservice.selectall(pageNum, pageSize,pursupinfo));
	    mav.setViewName("jinhuo/supinfo");
		
	    return mav;
	}
	
	//添加用户
		@RequestMapping("/addinfo.do")
		public ModelAndView addinfo(ModelAndView mav,PurSupInfo pursupinfo){
			System.out.println("进入添加供应商信息方法");
			System.out.println(pursupinfo);
			Date date=new Date();
			pursupinfo.setLastDate(date);
			 pursupinfoservice.addinfo(pursupinfo);
			 mav.setViewName("redirect:selectinfo.do");
		    return mav;
		}
	
	//查看详情
	@RequestMapping("/select.do")
	@ResponseBody
	public PurSupInfo selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
		System.out.println("进入查看弹层页面");
		String purSupInfoNum = req.getParameter("supInfoNum");
		System.out.println(purSupInfoNum);
		Long uid =(long) Integer.parseInt(purSupInfoNum);
		System.out.println("获取到的用户编号为:"+uid);
		PurSupInfo pursupinfo=pursupinfoservice.SelectById(uid);
		System.out.println("查出的用户为"+pursupinfo);
		return pursupinfo;
		
	}
	
	
	//修改用户
	@RequestMapping("/updateinfo.do")
	public ModelAndView updateinfo(ModelAndView mav,
			PurSupInfo pursupinfo){ 
		System.out.println("修改的的用户信息是："+pursupinfo);
		Date date = new Date();
		pursupinfo.setLastDate(date);
	    pursupinfoservice.updateinfo(pursupinfo);
		
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
	
  //批量删除信息
  @RequestMapping("/delall.do")
	public ModelAndView delall(ModelAndView mav,HttpServletRequest req){
	  String [] xx=req.getParameterValues("bb");
	  System.out.println("2222222222222222"+xx);
	  System.out.println("进入删除3333333333333333");
	    for (int i = 0; i < xx.length; i++) {
	    	 long l = Long.parseLong(xx[i]);
	    	 System.out.println("111111111111"+l);
	    	pursupinfoservice.delinfo(l);
			
		}
		//重定向到列表方法
		mav.setViewName("redirect:selectinfo.do");
		return mav;
	}
}
