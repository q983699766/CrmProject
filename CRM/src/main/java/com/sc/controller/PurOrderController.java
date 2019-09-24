package com.sc.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.Ccspxxb;
import com.sc.bean.PurOrder;
import com.sc.bean.PurOrderInfo;
import com.sc.bean.PurProducts;
import com.sc.mapper.PurOrderInfoMapper;
import com.sc.mapper.PurOrderMapper;
import com.sc.mapper.PurProductsMapper;
import com.sc.service.CcCkxxbService;
import com.sc.service.CcSpxxService;
import com.sc.service.PurOrderService;
import com.sc.service.PurProductsInfoService;
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
	PurOrderInfoMapper purOrderInfoMapper;
	@Autowired
	PurOrderMapper  purOrderMapper;
	
	
	// 查询所有订单信息
	@RequestMapping("/selectinfo.do")
	public ModelAndView selectinfo(ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize, PurOrder purorder, HttpServletRequest req) {

		System.out.println("进入查询订单信息方法");
		mav.addObject("pi", purorderservice.selecorder(pageNum, pageSize, purorder));
		System.out.println(purorderservice.selecorder(pageNum, pageSize, purorder));
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
		 /* long time = date.getTime();
		   long time1=time+86400000*7;
		   Date date1 = new Date(time1);
		   System.out.println("到货时间是"+date1);
		   purorder.setDeliveryTime(date1);  */
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

	// 点击添加详情单 按钮跳转方法
	@RequestMapping("/goadd.do")
	@ResponseBody
	public List<PurProducts> selectproall(PurProducts purProducts) {
		System.out.println("点击添加详情单 按钮跳转方++++++++++++++++++++");
		List<PurProducts> list = purproductsservice.selectpurproducts();
		System.out.println(list + "111111111111111111111");
		return list;
	}

	// 取值
	@RequestMapping("/quzhi.do")
	@ResponseBody
	public Ccspxxb selectById(ModelAndView mav, HttpServletRequest req) throws IllegalStateException, IOException {
		System.out.println("进入添加详情弹层页面+++++++++++");
		String productId1 = req.getParameter("productId");
		System.out.println(productId1);
		long long1 = Long.parseLong(productId1);
		Ccspxxb ccspxxByUid = ccspxxservice.selectCcspxxByUid(long1);
		System.out.println("查出的商品信息为" + ccspxxByUid);
		return ccspxxByUid;

	}
	
	

	// 添加采购单详情单
	@RequestMapping("/addpro2.do")
	public ModelAndView addpro2(ModelAndView mav, PurOrder purorder,HttpServletRequest req) {
		System.out.println("进入添加采购单详情的方法++++++++++++++++++++++++++++++++++++++++++");
         String parameter = req.getParameter("vvv");
          String remarksInfom = req.getParameter("remarksInfom");
          String productCount = req.getParameter("productCount");
          String id = req.getParameter("productId");
          
         
          
          long id1 = Long.parseLong(id);
          
          long parseLong = Long.parseLong(productCount);
         System.out.println("1111111111111111"+parameter);
         String parameter2 = req.getParameter("cbj");
         System.out.println("222222222222222222222"+parameter2);
        BigDecimal ii = new BigDecimal(parameter2);
        long long1 = Long.parseLong(parameter);
       PurOrderInfo purOrderInfo = new PurOrderInfo();
         purOrderInfo.setWarehouseOrnot("未入库");
         purOrderInfo.setPurNumber(long1);
         purOrderInfo.setRemarksInfom(remarksInfom);
         purOrderInfo.setProductCount(parseLong);
         purOrderInfo.setProductId(id1);
         Date date = new Date();
         purOrderInfo.setLastDate(date);
         purOrderInfo.setProPrice(ii);
        purOrderInfoMapper.insert(purOrderInfo);
        System.out.println("ffffffffffffffffffffffff"+id1);
        PurProducts products = purproductsservice.SelectById(id1);
      /*  System.out.println(products.getProId());
        purproductsservice.delpurproducts(products.getProId());
    */
        
       //设置发票号码和采购金额
        PurOrder selectByPrimaryKey = purOrderMapper.selectByPrimaryKey(long1);
        Date date2 = new Date();
        selectByPrimaryKey.setLastDate(date2);
        BigDecimal payAmount = selectByPrimaryKey.getPayAmount();
        selectByPrimaryKey.setInvoiceNumber(products.getProId()+"123456789");
        selectByPrimaryKey.setPayAmount(payAmount.add(purorder.getPayAmount()));
        System.out.println(products.getProId()+"123456789");
        System.out.println(purorder.getPayAmount()+"金额是");
        purorderservice.updateinfo(selectByPrimaryKey);
       System.out.println("删除的茶农是"+id1);
      
     
 
		// // 重定向到列表方法
		mav.setViewName("redirect:selectinfo.do");
		return mav;
	}

	// 通过id查询
	@RequestMapping("/select1.do")
	@ResponseBody
	public PurOrderInfo selectById1(ModelAndView mav, HttpServletRequest req)
			throws IllegalStateException, IOException {
		System.out.println("进入查看弹层页面");
		String purInfoNumber = req.getParameter("purInfoNumber");
		Long uid = (long) Integer.parseInt(purInfoNumber);
		System.out.println("获取到的用户编号为:" + uid);
		PurOrderInfo byUid = purProductsInfoService.selctPurOrderInfoByid(uid);
		System.out.println("查出的用户为" + byUid);
		return byUid;

	}

	@Autowired
	PurProductsInfoService purProductsInfoService;

	//采购单详情单查看按钮方法
	@RequestMapping("/oderinfo.do")
public ModelAndView ck(ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize, Long purNumber) {

	//	String parameter = req.getParameter("purInfoNumber");
		//long parseLong = Long.parseLong(parameter);
	//	System.out.println(parseLong+":::::::::::::::::::::::::::");
		System.out.println("aaaaaaabbbbbbb采购单编号" + purNumber);
		 List<PurOrderInfo> list = purOrderInfoMapper.selectBypurNumber(purNumber);
		
		 List<PurOrderInfo> list1 = new ArrayList<PurOrderInfo>();
		for (PurOrderInfo purOrderInfo : list) {
			Long purInfoNumber = purOrderInfo.getPurInfoNumber();
			System.out.println(purInfoNumber+"采购单详情单编号");
			
			PurOrderInfo info = purProductsInfoService.selctPurOrderInfoByid(purInfoNumber);
			 System.out.println(info);
			 list1.add(info);
			}
		
		mav.addObject("u",list1);
	 
		// 设置视图名称 转发
		mav.setViewName("jinhuo/proinfo");// 响应的视图名称，路径是：/WEB-INF/users/list.jsp
		return mav;
	}

	//入库
	@Autowired
	CcCkxxbService ccCkxxbService;

	/*@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav, Ccspxxb u, PurOrderInfo puroderinfo) {

	
		Date date = new Date();
		u.setLastTime(date);

		PurOrderInfo primaryKey = purOrderInfoMapper.selectByPrimaryKey(puroderinfo.getPurInfoNumber());
		System.out.println(puroderinfo.getPurInfoNumber()+"采购详情编号");
	
		 System.out.println(u.getProductId()+"获取的产品编号");
		 Ccspxxb ccspxxByUid = ccspxxservice.selectCcspxxByUid(u.getProductId());
		 ccspxxByUid.setKcSl(ccspxxByUid.getKcSl()+puroderinfo.getProductCount());
		 System.out.println("采购的数量是"+puroderinfo.getProductCount());
		 System.out.println("库存的数量是"+ccspxxByUid.getKcSl());
	
		 ccspxxservice.updateCcspxx(ccspxxByUid, null);
		primaryKey.setWarehouseOrnot("已入库");
		purOrderInfoMapper.updateByPrimaryKey(primaryKey);
		// 添加模型数据

		// 设置视图名称 转发
		mav.setViewName("redirect:oderinfo.do");// 响应的视图名称，路径是：/WEB-INF/users/list.jsp
		return mav;
	}
	*/
	@RequestMapping("/add.do")
	@ResponseBody
	public void add(@RequestBody PurOrderInfo puroderinfo) {
		System.out.println("”“”“”“”“”“”“”“”“”“”“”“”“”“”“”“”“"+puroderinfo);
        System.out.println(puroderinfo.getPurInfoNumber()+"采购详情编号");
		System.out.println(puroderinfo.getProductId()+"商品编号");
		Ccspxxb ccspxxByUid = ccspxxservice.selectCcspxxByUid(puroderinfo.getProductId());
		 ccspxxByUid.setKcSl(ccspxxByUid.getKcSl()+puroderinfo.getProductCount());
		 System.out.println("采购的数量是"+puroderinfo.getProductCount());
		 System.out.println("库存的数量是"+ccspxxByUid.getKcSl());
		 puroderinfo.setWarehouseOrnot("已入库");
		 Date date = new Date();
		 puroderinfo.setLastDate(date);
		 ccspxxByUid.setLastTime(date);
	     purOrderInfoMapper.updateByPrimaryKey(puroderinfo);
	     ccspxxservice.updateCcspxx(ccspxxByUid, null);
	     
	    purproductsservice.delpurproduct(puroderinfo.getProductId());
	     System.out.println("删除的产品id"+puroderinfo.getProductId());
	     
	     List<PurOrderInfo> bypurNumber = purOrderInfoMapper.selectBypurNumber(puroderinfo.getPurNumber());
	     if(bypurNumber.size()==1){
	     for (PurOrderInfo purOrderInfo : bypurNumber) {
	    	
	    	 String warehouseOrnot = purOrderInfo.getWarehouseOrnot();
	    	 System.out.println("是否入库："+warehouseOrnot);
	    	 if(warehouseOrnot.equals("已入库")){
	    		 Long purInfoNumber = purOrderInfo.getPurNumber();
	    		 PurOrder selectByPrimaryKey = purOrderMapper.selectByPrimaryKey(purInfoNumber);
	    		 String r="1";
	    		 long l = Long.parseLong(r);
	    		 selectByPrimaryKey.setPurProgrees(l);
	    		 purorderservice.updateinfo(selectByPrimaryKey);
	    		 
	    	 }
		   }
	     }
	    /* if(bypurNumber.size()>1){
	    	 Iterator<PurOrderInfo> iterator = bypurNumber.iterator();
	    	 while (iterator.hasNext()) {
	    	  for (PurOrderInfo purOrderInfo : bypurNumber)
	    		  { String warehouseOrnot = purOrderInfo.getWarehouseOrnot();
		    	 System.out.println("是否入库："+warehouseOrnot);
		    	 if(warehouseOrnot.equals("已入库")){
		    		 Long purInfoNumber = purOrderInfo.getPurNumber();
		    		 PurOrder selectByPrimaryKey = purOrderMapper.selectByPrimaryKey(purInfoNumber);
		    		 String r="1";
		    		 long l = Long.parseLong(r);
		    		 selectByPrimaryKey.setPurProgrees(l);
		    		 purorderservice.updateinfo(selectByPrimaryKey);
		    		 
		    	 }
		}	}
	    	 
	     }*/
	}
	
	@RequestMapping("/fukuan.do")
	public ModelAndView fukuan(ModelAndView mav, PurOrderInfo puroderinfo) {
		System.out.println("进入付款方法");
		Long purNumber = puroderinfo.getPurNumber();
		System.out.println("获取的采购单号是"+purNumber);
		PurOrder selectByPrimaryKey = purOrderMapper.selectByPrimaryKey(purNumber);
		System.out.println("查询出来的采购订单详情"+selectByPrimaryKey);
		String l="2";
		long m=Long.parseLong(l);
		selectByPrimaryKey.setPayStatus(m);
		Date date = new Date();
		selectByPrimaryKey.setLastDate(date);
		purorderservice.updateinfo(selectByPrimaryKey);
	
		mav.setViewName("redirect:selectinfo.do");
		return mav;
	}
	

}

