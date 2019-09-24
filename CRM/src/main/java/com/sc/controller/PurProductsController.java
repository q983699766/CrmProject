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
import com.sc.bean.PurOrderInfo;
import com.sc.bean.PurProducts;
import com.sc.mapper.PurOrderInfoMapper;
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
		@Autowired
		PurOrderInfoMapper purOrderInfoMapper ;
	
		
		//查询所有待采购产品库存信息
		@RequestMapping("/selectproducts11.do")
		public ModelAndView selectproducts11 (ModelAndView mav,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="5")Integer pageSize ,Ccspxxb ccspxx,PurProducts purProducts){
		
			List<PurOrderInfo> selectByExample2 = purOrderInfoMapper.selectByExample(null);
			for (PurOrderInfo purOrderInfo : selectByExample2) {
				Long productId = purOrderInfo.getProductId();
			}
			
			List<PurProducts> selectByExample = purProductsMapper.selectByExample(null);
			   System.out.println(selectByExample+"111111111111111111");
			  for (PurProducts purProducts2 : selectByExample) {
				  Long productId = purProducts2.getProductId();
				  System.out.println(productId);
			}
			  
			  
			  
			   if(!(selectByExample.isEmpty())){
			
			List<Ccspxxb> list = ccspxxservice.selectByExamplel(ccspxx);
			
			
			for (Ccspxxb ccspxxb : list) {
		        System.out.println("小于50的数据输"+ccspxxb);
				Long productId = ccspxxb.getProductId();
				Long comId = ccspxxb.getComId();
				Long kcSl = ccspxxb.getKcSl();
				System.out.println(kcSl+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(productId);
			 //  PurProducts products = purproductsservice.SelectById(productId);
			   
			   purProducts.setActive("缺货");
			   Date date = new Date();
			   purProducts.setLastDate(date);
			   
			   long time = date.getTime();
			   long time1=time+86400000*7;
			   Date date1 = new Date(time1);
			   System.out.println("到货时间是"+date1);
			   
			   purProducts.setDeliveryTime(date1);
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
			   
			   long time = date.getTime();
			   long time1=time+86400000*7;
			   Date date1 = new Date(time1);
			   System.out.println("到货时间是"+date1);
			   
			   purProducts.setDeliveryTime(date1);
			   purProducts.setProductId(productId);
			   purProducts.setComId(comId);
			   purProducts.setRemarksInfo("加急采购");
			
			 purproductsservice.addpurproducts(purProducts);
			 System.out.println("添加数据");
				}
		}
			
			 PageInfo<PurProducts> info = purproductsservice.selectpurproducts(pageNum, pageSize);
			 
	
			 
			 System.out.println(info.getList()+".........................");
				mav.addObject("pi",info);
		           mav.setViewName("jinhuo/productsinfo");
				    return mav;
			   
		
		}
		
		
		
		
		
		
}
