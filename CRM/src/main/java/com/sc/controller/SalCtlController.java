package com.sc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView salMessCtl(ModelAndView mav){
		 mav.setViewName("salcontroller/orderTable");
		 return mav;
	}
	
	@RequestMapping("salMessTable")
	@ResponseBody
	public List<SalOrder> salMessTable(){
		List<SalOrder> selectSalOrder = sms.selectSalOrder();
		return selectSalOrder;
	}
}
