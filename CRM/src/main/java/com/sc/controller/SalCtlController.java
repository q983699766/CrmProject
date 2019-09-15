package com.sc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SalMessageBean;
import com.sc.bean.SalOrder;
import com.sc.service.SalMessageService;

@Controller
@RequestMapping("salCtl")
public class SalCtlController {
	@Autowired
	SalMessageService sms;
	
	
	
	@RequestMapping("countSal")
	public ModelAndView countSal(ModelAndView mav){
		 mav.addObject("salMessageBean",  new SalMessageBean(
				sms.totalMoney(),
				sms.orderCount(),
				sms.successOrderCount(),
				sms.failOrderCount(),
				sms.totalRebate(),
				sms.orderCountGroupByMonth(),
				sms.waitPayOrderCountGroupByMonth(),
				sms.havePayOrderCountGroupByMonth(),
				sms.waitPutOrderCountGroupByMonth()));
		 mav.setViewName("salcontroller/transaction");
		 return mav;
	}
	
	@RequestMapping("salMessCtl")
	public ModelAndView salMessCtl(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize,
			@RequestParam(defaultValue="-1")String type,
			@RequestParam(defaultValue="")String message){
		PageInfo<SalOrder> selectSalOrder = null;
		if("0".equals(type) || "1".equals(type)){ //0 1 按订单或者关键字查询
			selectSalOrder = sms.selectSalOrderLike(pageNum, pageSize, type, message);
		}
		else{
			selectSalOrder = sms.selectSalOrder(pageNum,pageSize);
		}
		mav.addObject("data", selectSalOrder);
		mav.addObject("type", type);
		mav.addObject("message", message);
		mav.setViewName("salcontroller/orderTable");
		return mav;
	}
	
	@RequestMapping("dele")
	@ResponseBody
	public PageInfo<SalOrder> deleSal(Long salid,
		@RequestParam(defaultValue="1")Integer pageNum,
		@RequestParam(defaultValue="5")Integer pageSize,
		@RequestParam(defaultValue="-1")String type,
		@RequestParam(defaultValue="")String message){
		PageInfo<SalOrder> selectSalOrder = null;
		sms.delSalOrderBykey(salid);
		if("0".equals(type) || "1".equals(type)){ //0 1 按订单或者关键字查询
			selectSalOrder = sms.selectSalOrderLike(pageNum, pageSize, type, message);
		}
		else{
			selectSalOrder = sms.selectSalOrder(pageNum,pageSize);
		}
		return selectSalOrder;
	}
	
	@RequestMapping("send")
	@ResponseBody
	public String sendOrder(long orderid){
		System.out.println("*************************"+orderid);
		sms.sendSalOrderBykey(orderid);
		return "success";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Object salMessTable(){
		return "";
	}
}
