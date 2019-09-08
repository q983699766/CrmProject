package com.sc.controller;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.Ccspxxb;
import com.sc.service.CcSpxxService;

@Controller//注册成bean对象
@RequestMapping("/ccspxxctlr")
public class CcCkSpxxbController {
	@Autowired
	CcSpxxService ccSpxxService ;
	//1.分页查看仓库商品列表（以测试）
			@RequestMapping("/list.do")
			public ModelAndView list(ModelAndView mav,
					@RequestParam(defaultValue="1")Integer pageNum,
					@RequestParam(defaultValue="5")Integer pageSize ){
				
				System.out.println("aaaaaaa");
				//添加模型数据
			   mav.addObject("pi", ccSpxxService.selectCcspxxPage(pageNum, pageSize));
			   
				//设置视图名称         转发
				mav.setViewName("Ck/splb");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
			
		
		//通过id删除仓库商品列表
			@RequestMapping("/del.do")
			public ModelAndView del(ModelAndView mav,Long productId){
				
				System.out.println("接收到的fwid为"+productId);
				ccSpxxService.delCcspxx(productId);
				//重定向到列表方法
				mav.setViewName("redirect:list.do");
				return mav;
			}
			
			//添加
			@RequestMapping("/add.do")
			public ModelAndView add(ModelAndView mav , Ccspxxb u ){
				
				System.out.println("aaaaaaa"+u);
				Date date = new Date();
				u.setLastTime(date);
				
				//添加模型数据
			    ccSpxxService.addCcspxx(u);
			   
				//设置视图名称         转发
				mav.setViewName("redirect:list.do");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
			
		//模糊查询
			@RequestMapping("mh.do")
			public ModelAndView mh(ModelAndView mav,Ccspxxb ccspxx){
				
				System.out.println("aaaaaaa");
				//添加模型数据
			   mav.addObject("pi", ccSpxxService.selectCcspxx(ccspxx));
			   
				//设置视图名称         转发
				mav.setViewName("redirect:list.do");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
			
			
			
}
