package com.sc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.PurProducts;
import com.sc.mapper.PurProductsMapper;
import com.sc.service.CcSpxxService;
import com.sc.service.PurProductsService;


@Controller
@RequestMapping("/products")
public class PurProductsController {
	

		@Autowired
		PurProductsService purproductsservice;
		@Autowired
		CcSpxxService ccspxxservice;
		@Autowired
		PurProductsMapper purProductsMapper;
		
		
		
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
				@RequestParam(defaultValue="5")Integer pageSize ,Ccspxxb ccspxx,PurProducts purProducts){
			List<PurProducts> selectByExample = purProductsMapper.selectByExample(null);
			   System.out.println(selectByExample+"111111111111111111");
			   if(!(selectByExample.isEmpty())){
			
			List<Ccspxxb> list = ccspxxservice.selectByExamplel(ccspxx);
			
			
			for (Ccspxxb ccspxxb : list) {
		        System.out.println("小于50的数据输"+ccspxxb);
				Long productId = ccspxxb.getProductId();
				Long comId = ccspxxb.getComId();
				
				System.out.println(productId);
			 //  PurProducts products = purproductsservice.SelectById(productId);
			   
			   purProducts.setActive("缺货");
			   Date date = new Date();
			   purProducts.setLastDate(date);
			   purProducts.setDeliveryTime(date);
			   purProducts.setProductId(productId);
			   purProducts.setComId(comId);
			   purProducts.setRemarksInfo("加急采购");
			    int k = 0;
			   for (int i = 0; i < selectByExample.size(); i++) {
				   Long productId2 = selectByExample.get(i).getProductId();
				   if(productId2==productId){
					   k=1;
					   break;
				      }
			}
			   if(k==0){
				   purproductsservice.addpurproducts(purProducts);
			   }
			   
			      /*for (PurProducts purProducts2 : selectByExample) {
				     Long id = purProducts2.getProductId();
				     System.out.println("222222222222"+id);
				     
				     if(id!=productId){
					   purproductsservice.addpurproducts(purProducts);
				      }*/
			   }
		 } 
		if(selectByExample.isEmpty()) {
			List<Ccspxxb> list = ccspxxservice.selectByExamplel(ccspxx);
		
			for (Ccspxxb ccspxxb : list) {
		        System.out.println("小于50的数据输"+ccspxxb);
				Long productId = ccspxxb.getProductId();
				Long comId = ccspxxb.getComId();
				
				System.out.println(productId);
			 //  PurProducts products = purproductsservice.SelectById(productId);
			   
			   purProducts.setActive("缺货");
			   Date date = new Date();
			   purProducts.setLastDate(date);
			   purProducts.setDeliveryTime(date);
			   purProducts.setProductId(productId);
			   purProducts.setComId(comId);
			   purProducts.setRemarksInfo("加急采购");
			
			 purproductsservice.addpurproducts(purProducts);
			 System.out.println("添加数据");
				}
		}
			
			 PageInfo<PurProducts> info = purproductsservice.selectpurproducts(pageNum, pageSize);
				mav.addObject("pi",info);
		           mav.setViewName("jinhuo/productsinfo");
				    return mav;
			   
		
		}
		
		
		
		
		
		
}
