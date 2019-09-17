package com.sc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.CcCkxxb;
import com.sc.bean.PurOrderInfo;
import com.sc.service.PurProductsInfoService;

@Controller//注册成bean对象
@RequestMapping("/cgxqctlr")
public class PurProductsInfoController {

	@Autowired
	PurProductsInfoService purProductsInfoService;
	//1.分页查看采购商品列表（以测试）
			@RequestMapping("/ck.do")
			
			public ModelAndView ck(ModelAndView mav,
					@RequestParam(defaultValue="1")Integer pageNum,
					@RequestParam(defaultValue="5")Integer pageSize,Long purInfoNumber ){
				
				System.out.println("aaaaaaa"+purInfoNumber);
				//添加模型数据
			   mav.addObject("pi", purProductsInfoService.selectPurOrderInfo(pageNum, pageSize,purInfoNumber));  
				//设置视图名称         转发
				mav.setViewName("Ck/cgxq");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
			
		
			//通过id查询
			@RequestMapping("/select.do")
			@ResponseBody
			public PurOrderInfo selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
				System.out.println("进入查看弹层页面");
				String purInfoNumber = req.getParameter("purInfoNumber");
				Long uid=(long)Integer.parseInt(purInfoNumber);				
				System.out.println("获取到的用户编号为:"+uid);
				PurOrderInfo byUid = purProductsInfoService.selctPurOrderInfoByid(uid);
				System.out.println("查出的用户为"+byUid);
				return byUid;
				
			}
			
}
