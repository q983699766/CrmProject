package com.sc.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.Ccspxxb;
import com.sc.bean.PurOrder;
import com.sc.bean.PurOrderInfo;
import com.sc.bean.PurProducts;
import com.sc.mapper.PurOrderInfoMapper;
import com.sc.mapper.PurProductsMapper;
import com.sc.service.CcSpxxService;
import com.sc.service.PurOrderService;
import com.sc.service.PurProductsService;

@Controller
@RequestMapping("/purorder")
public class PurOrderController<V> {

	@Autowired
	PurOrderService purorderservice;
	@Autowired
	PurProductsService purproductsservice;
	@Autowired
	CcSpxxService ccspxxservice;
	@Autowired
	PurProductsMapper purProductsMapper;
	@Autowired
	PurOrderInfoMapper  purOrderInfoMapper;
	
	

	// 查询所有订单信息
	@RequestMapping("/selectinfo.do")
	public ModelAndView selectinfo(ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize, PurOrder purorder, HttpServletRequest req) {

		System.out.println("进入查询订单信息方法");
		mav.addObject("pi", purorderservice.selectallorder(pageNum, pageSize, purorder));
		System.out.println(purorderservice.selectallorder(pageNum, pageSize, purorder));
		mav.setViewName("jinhuo/purorder");

		return mav;
	}

	// 添加订单
	@RequestMapping("/addinfo.do")
	public ModelAndView addinfo(ModelAndView mav, PurOrder purorder) {
		System.out.println("进入添加采购单信息方法");
		System.out.println(purorder);
		Date date = new Date();
		purorder.setPurDate(date);
		purorder.setLastDate(date);
		purorder.setPayStatus(Long.parseLong("1"));
		purorder.setPurProgrees(Long.parseLong("2"));
		purorder.setPayAmount(BigDecimal.valueOf(0));
		purorder.setInvoiceNumber("暂无");
		purorderservice.addinfo(purorder);
		mav.setViewName("redirect:selectinfo.do");
		return mav;
	}

	// 删除订单信息
	@RequestMapping("/delinfo.do")
	public ModelAndView del(ModelAndView mav, PurOrder purorder) {
		System.out.println("删除的订单信息是：" + purorder);
		purorderservice.delinfo(purorder.getPurNumber());
		// 重定向到列表方法
		mav.setViewName("redirect:selectinfo.do");
		return mav;
	}
	
	//点击添加详情单 按钮跳转方法
		@RequestMapping("/goadd.do")
		@ResponseBody
		public List<PurProducts> selectproall(PurProducts purProducts)  {
			System.out.println("点击添加详情单 按钮跳转方++++++++++++++++++++");
			List<PurProducts> list = purproductsservice.selectpurproducts();
			System.out.println(list+"111111111111111111111");
			return list;
		}
	
	
	//取值
	@RequestMapping("/quzhi.do")
	@ResponseBody
	public Ccspxxb selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
		  System.out.println("进入添加详情弹层页面+++++++++++");
	     String productId1 = req.getParameter("productId");
	     System.out.println(productId1);
	    long long1 = Long.parseLong(productId1);
        Ccspxxb ccspxxByUid = ccspxxservice.selectCcspxxByUid(long1);
        System.out.println("查出的商品信息为"+ccspxxByUid);
		return ccspxxByUid;
		
	}
	// 添加采购单详情单
		@RequestMapping("/addpro2.do")
		public ModelAndView addpro2(ModelAndView mav, PurOrder purorder,Ccspxxb ccspxxb,List<PurOrderInfo> purOrderInfo,HttpSession session) {
			System.out.println("进入添加采购单详情的方法++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("2222222222222222222222222222222222");
			/*List<Ccspxxb> list = ccspxxservice.selectByExamplel(ccspxxb);
			
			for (Ccspxxb ccspxxb1 : list) {
		        System.out.println("小于50的数据输"+ccspxxb1);
				Long productId = ccspxxb1.getProductId();  //得到产品编号
		        String spMc = ccspxxb1.getSpMc();       //得到产品名称
		        BigDecimal cbj = ccspxxb1.getCbj();     //得到成本价
		        Long comId = ccspxxb1.getComId();
		   
	            session.setAttribute("spxx", spMc);
		        
		        purOrderInfo.setWarehouseOrnot("未入库");
		        Date date = new Date();
		        purOrderInfo.setLastDate(date);
		        purOrderInfo.setComId(comId);
		       
			}
			 purorderservice.addpro(purOrderInfo);
			 List<PurOrderInfo> list2 = purOrderInfoMapper.selectByExample(null);
			 mav.addObject("list",list2);*/
//			// 重定向到列表方法
				mav.setViewName("redirect:selectinfo.do");
			     return mav;
		}
		
	
}
