package com.sc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.bean.CcCkxxb;
import com.sc.bean.Ccspxxb;
import com.sc.service.CcCkxxbService;

@Controller//注册成bean对象
@RequestMapping("/ccckxxctlr")
public class CcCkxxbController {

	@Autowired
	CcCkxxbService ccCkxxbService;
	//1.分页查看仓库商品列表（以测试）
			@RequestMapping("/ck.do")
			public ModelAndView ck(ModelAndView mav,
					@RequestParam(defaultValue="1")Integer pageNum,
					@RequestParam(defaultValue="5")Integer pageSize ){
				
				System.out.println("aaaaaaa");
				//添加模型数据
			   mav.addObject("pi", ccCkxxbService.selectCcCcxxPage(pageNum, pageSize));
			   
				//设置视图名称         转发
				mav.setViewName("Ck/cclb");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
				return mav;
			}
	
			
		//添加
		@RequestMapping("/add.do")
		
		public ModelAndView add(ModelAndView mav , CcCkxxb u ){
			
			System.out.println("aaaaaaa"+u);
			Date date = new Date();
			u.setLastTime(date);
			
			//添加模型数据
			ccCkxxbService.addCcCkxx(u);
		   
			//设置视图名称         转发
			mav.setViewName("redirect:ck.do");//响应的视图名称，路径是：/WEB-INF/users/list.jsp
			return mav;
		}
	
		//删除
		@RequestMapping("/del.do")
		public ModelAndView del(ModelAndView mav,Long uid){
			
			System.out.println("接收到的fwid为"+uid);
			ccCkxxbService.delCcCkxx(uid);
			//重定向到列表方法
			mav.setViewName("redirect:ck.do");
			return mav;
		}
		
		//批量删除
		@RequestMapping("/sc.do")
		public ModelAndView del(ModelAndView mav,HttpServletRequest req){
			  String [] xx=req.getParameterValues("bb");			 
			    for (int i = 0; i < xx.length; i++) {
			    	 long l = Long.parseLong(xx[i]);
			    	 System.out.println("你要删除的数据："+l);
			    	
					
					ccCkxxbService.delCcCkxx(l);
				}
				//重定向到列表方法
				mav.setViewName("redirect:ck.do");
				return mav;
			}
		
		
		//通过id查询
		@RequestMapping("/select.do")
		@ResponseBody
		public CcCkxxb selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
			System.out.println("进入查看弹层页面");
			String ckBh = req.getParameter("ckBh");		
			
			Long uid =(long) Integer.parseInt(ckBh);
			System.out.println("获取到的用户编号为:"+uid);
			CcCkxxb byUid = ccCkxxbService.selectCcCkxxbByUid(uid);
			System.out.println("查出的用户为"+byUid);
			return byUid;
			
		}
		
		//修改查询出来的信息
		@RequestMapping("/updatecckcxx.do")			
		public ModelAndView updatecckcxx(ModelAndView mav,
				CcCkxxb u){ 
			System.out.println("修改的的用户信息是："+u);
			Date date = new Date();
			u.setLastTime(date);
			ccCkxxbService.updateCcCkxx(u);		
			mav.setViewName("redirect:ck.do");
			return mav;
		}
		
		
		//通过仓库id 查询属于该仓库的商品
		@RequestMapping("/select1.do")
		public ModelAndView select1(ModelAndView mav,HttpServletRequest req,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="5")Integer pageSize) throws IllegalStateException, IOException {
			String ckBh = req.getParameter("ckBh");	
			System.out.println("777777777777"+ckBh);
			Long uid =(long) Integer.parseInt(ckBh);			
			CcCkxxb byUid = ccCkxxbService.selectCcCkxxbByUid(uid);
			PageInfo<Ccspxxb> pi = ccCkxxbService.selectbyckidPage(pageNum, pageSize, byUid.getCkBh());//selectbyckid(byUid.getCkBh());		
			byUid.setCcspxxb(pi.getList());			
			mav.addObject("aa", byUid);
			System.out.println("f:"+pi.getFirstPage());
		
			mav.addObject("ckBh",ckBh);
			mav.addObject("pi",pi);
			mav.setViewName("Ck/splb2");
			return mav;
		}
		
		//模糊查询
		@RequestMapping("/mh.do")
		public ModelAndView selectmh(ModelAndView mav,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="5")Integer pageSize,CcCkxxb ccCkxxb){
			
			System.out.println("进入查询供应商信息方法"+ccCkxxb);
		
			mav.addObject("pi", ccCkxxbService.selectmh(pageNum, pageSize, ccCkxxb));
			String ckM = ccCkxxb.getCkM();
			System.out.println("6666666666666666"+ckM);
			mav.addObject("CKM",ckM);
		    mav.setViewName("Ck/cclb");
			
		    return mav;
		}
}
