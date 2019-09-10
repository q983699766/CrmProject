package com.sc.controller;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
				
				System.out.println("进入查询方法");
				//添加模型数据
			   mav.addObject("pi", ccSpxxService.selectCcspxxPage(pageNum, pageSize));			   
				//设置视图名称         转发
				mav.setViewName("Ck/splb");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
			
		
		//通过id删除仓库商品列表
			@RequestMapping("/del.do")
			public ModelAndView del(ModelAndView mav,Long productId){
				
				System.out.println("接收到的productId为"+productId);
				ccSpxxService.delCcspxx(productId);
				//重定向到列表方法
				mav.setViewName("redirect:list.do");
				return mav;
			}
			
			//添加
			@RequestMapping("/add.do")
			public ModelAndView add(ModelAndView mav , Ccspxxb u ){
				
				System.out.println("进入添加方法"+u);
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
			public ModelAndView selectmh(ModelAndView mav,
					@RequestParam(defaultValue="1")Integer pageNum,
					@RequestParam(defaultValue="5")Integer pageSize,Ccspxxb ccspxx){
				
				System.out.println("进入查询供应商信息方法"+ccspxx);
			
				mav.addObject("pi", ccSpxxService.selectmh(pageNum, pageSize, ccspxx));
				System.out.println( ccSpxxService.selectmh(pageNum, pageSize, ccspxx));
			    mav.setViewName("Ck/splb");
				
			    return mav;
			}
			
			//修改
			@RequestMapping("/updateccspxx.do")			
			public ModelAndView updateccspxx(ModelAndView mav,
					Ccspxxb u){ 
				System.out.println("修改的的用户信息是："+u);
				Date date = new Date();
				u.setLastTime(date);
				ccSpxxService.updateCcspxx(u);		
				mav.setViewName("redirect:list.do");
				return mav;
			}
			
			//通过id查询
			@RequestMapping("/select.do")
			@ResponseBody
			public Ccspxxb selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
				System.out.println("进入查看弹层页面");
				String productId = req.getParameter("productId");
				System.out.println(productId);
				Long uid =(long) Integer.parseInt(productId);
				System.out.println("获取到的用户编号为:"+uid);
				Ccspxxb byUid = ccSpxxService.selectCcspxxByUid(uid);
				System.out.println("查出的用户为"+byUid);
				return byUid;
				
			}
			
			
}


