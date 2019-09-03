package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.service.CcSpxxService;
import com.sc.service.PurProductsService;


@Controller
@RequestMapping("/products")
public class PurProductsController {
	

		@Autowired
		PurProductsService purproductsservice;
		@Autowired
		CcSpxxService ccspxxservice;
		
		//查询所有待采购产品库存信息
		@RequestMapping("/selectproducts.do")
		public ModelAndView selectproducts (ModelAndView mav,Integer pageNum, Integer pageSize){
			System.out.println("查询所有待采购产品库存信息+++++"+ccspxxservice.selectCcspxx());
			mav.addObject("pi", ccspxxservice.selectCcspxxPage(pageNum, pageSize));
			System.out.println(ccspxxservice.selectCcspxx());
		    mav.setViewName("jinhuo/productsinfo");
			
		    return mav;
		}
}
