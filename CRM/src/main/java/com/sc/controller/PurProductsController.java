package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.PurProducts;
import com.sc.service.CcSpxxService;
import com.sc.service.PurProductsService;


@Controller
@RequestMapping("/products")
public class PurProductsController {
	

		@Autowired
		PurProductsService purproductsservice;
		@Autowired
		CcSpxxService ccspxxservice;
		
		//查询所有待采购产品库存信息(没用)
		@RequestMapping("/selectproducts.do")
		public ModelAndView selectproducts (ModelAndView mav,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="5")Integer pageSize){
			System.out.println("查询所有待采购产品库存信息+++++"+ccspxxservice.selectCcspxxPage(pageNum, pageSize));
			mav.addObject("pi", ccspxxservice.selectCcspxxPage(pageNum, pageSize));
			System.out.println(ccspxxservice.selectCcspxxPage(pageNum, pageSize)+"xxxxx");
            mav.setViewName("jinhuo/productsinfo");
		    return mav;
		}
		
		//查询所有待采购产品库存信息
		@RequestMapping("/selectproducts11.do")
		public ModelAndView selectproducts11 (ModelAndView mav,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="5")Integer pageSize){
			PageInfo<Ccspxxb> xx = purproductsservice.selectpurproducts(pageNum, pageSize);
			mav.addObject("pi",xx);
           mav.setViewName("jinhuo/productsinfo");
		    return mav;
		}
}
