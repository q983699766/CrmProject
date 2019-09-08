package com.sc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.PurOrder;
import com.sc.bean.PurSupInfo;
import com.sc.service.PurOrderService;

@Controller
@RequestMapping("/purorder")
public class PurOrderController {

	@Autowired
	PurOrderService purorderservice;
	
	//查询所有订单信息
	@RequestMapping("/selectinfo.do")
	public ModelAndView selectinfo (ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize,PurOrder purorder,HttpServletRequest req){
		
		System.out.println("进入查询订单信息方法");
		mav.addObject("pi", purorderservice.selectallorder(pageNum, pageSize, purorder));
		System.out.println(purorderservice.selectallorder(pageNum, pageSize,purorder));
	    mav.setViewName("jinhuo/purorder");
	   
	    return mav;
	}
	
	//添加订单
	@RequestMapping("/addinfo.do")
	public ModelAndView addinfo(ModelAndView mav,PurOrder purorder){
		System.out.println("进入添加供应商信息方法");
		System.out.println(purorder);
		Date date=new Date();
		purorder.setPurDate(date);
		purorder.setLastDate(date);
		purorder.setPayStatus(Long.parseLong("1"));
		purorder.setPurProgrees(Long.parseLong("2"));
		purorderservice.addinfo(purorder);
		 mav.setViewName("redirect:selectinfo.do");
	    return mav;
	}

}
