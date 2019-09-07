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

import com.sc.bean.SalConper;
import com.sc.bean.SalCustomInfo;
import com.sc.service.ConperService;

@Controller
@RequestMapping("conctlr")
public class ConperController2 {

	@Autowired
	ConperService conperService;
	//查询所有客户--销售经理可以进
	@RequestMapping("/custom.do")
	public ModelAndView custom(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize,
			SalCustomInfo sal){
		System.out.println("11用户进来了！！");
		mav.addObject("pi", conperService.selectSalCustomInfoPage(pageNum, pageSize,sal));
		mav.setViewName("custom/conper");
		return mav;	
	}
	
	//通过id查询出所有用户
	//*****id不能重复
	@RequestMapping("/selectById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public SalCustomInfo selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
		String customId = req.getParameter("customId");
		Long uid =(long) Integer.parseInt(customId);
		System.out.println("获取到的用户编号为:"+uid);
		SalCustomInfo custom = conperService.selectById(uid);
		
		System.out.println("查出的用户为"+custom);
		return custom;
	}

	
	//添加用户信息
	@RequestMapping("/addSalCustomInfo.do")
	public ModelAndView addSalCustomInfo(ModelAndView mav,
			SalCustomInfo sal) throws IllegalStateException, IOException{
		Date date = new Date();
		sal.setLastTime(date);
		sal.setCustomState("正在合作");
		System.out.println("进入到添加控制器了！！");
		System.out.println(sal.getNextcontactTime());
		conperService.addSalCustomInfo(sal);
		mav.setViewName("redirect:./custom.do");
		return mav;
	}
	
	//删除客户信息
		@RequestMapping("/delSalCustomInfo.do")
		public ModelAndView delSalCustomInfo(ModelAndView mav,SalCustomInfo sal){
			System.out.println("删除的用户信息是："+sal);
			conperService.delSalCustomInfo(sal);
			//重定向到列表方法
			mav.setViewName("redirect:./custom.do");
			return mav;
		}
	
	//修改客户信息
		@RequestMapping("/updateSalCustomInfo.do")
		public ModelAndView updateFwxx(ModelAndView mav,SalCustomInfo sal){
			System.out.println("sal的数据为："+sal);
			conperService.updateSalCustomInfo(sal);
			mav.setViewName("redirect:./custom.do");
			return mav;
		}
		
	//从a标签“联系人”跳转到联系人页面查看所有信息
		@RequestMapping("/gotoConper.do")
		public ModelAndView gotoConper(ModelAndView mav,HttpServletRequest req){
			String customId = req.getParameter("customId");
			Long uid =(long) Integer.parseInt(customId);
			System.out.println("获取到的用户编号为:"+uid);
			SalCustomInfo custom = conperService.selectById(uid);
			Long id = custom.getCustomId();
			List<SalConper> list = conperService.selectconperById(id);
			custom.setSalconper(list);

			for (SalConper salConper : list) {
				System.out.println("查询出来的联系人信息是"+salConper);
			}
			mav.addObject("conper",custom );
			mav.setViewName("custom/bleed");
			
			return mav;
		}
		
		
		//添加联系人信息
		@RequestMapping("/addSalConper.do")
		public ModelAndView addSalConper(ModelAndView mav,
				SalConper con) throws IllegalStateException, IOException{
			Date date = new Date();
			con.setLastTime(date);
			Long customId = con.getCustomId();
			con.setCustomId(customId);
			System.out.println("获取到的客户ID为："+customId);
			System.out.println("进入到添加控制器了！！");
			conperService.addSalConper(con);
			SalCustomInfo custom = conperService.selectById(customId);
			Long id = custom.getCustomId();
			List<SalConper> list = conperService.selectconperById(id);
			custom.setSalconper(list);

			for (SalConper salConper : list) {
				System.out.println("查询出来的联系人信息是"+salConper);
			}
			mav.addObject("conper",custom );
			mav.setViewName("custom/bleed");
			
			return mav;
		}
	
		//修改联系人信息
		@RequestMapping("/updateSalConper.do")
		public ModelAndView updateSalConper(ModelAndView mav,SalConper con){
//			System.out.println("sal的数据为："+con);
//			Long customId = con.getCustomId();
//			con.setCustomId(customId);
			conperService.updateSalConper(con);
			SalCustomInfo custom = conperService.selectById(con.getCustomId());
			Long id = custom.getCustomId();
			List<SalConper> list = conperService.selectconperById(id);
			custom.setSalconper(list);

			for (SalConper salConper : list) {
				System.out.println("查询出来的联系人信息是"+salConper);
			}
			mav.addObject("conper",custom );
			mav.setViewName("custom/bleed");
			
			return mav;
		}
		
		
		//通过id查询出联系人的所有信息
		//*****id不能重复
		@RequestMapping("/selectSalConperById.do")
		@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
		public SalConper selectSalConperById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
			String conperId = req.getParameter("conperId");
			Long uid =(long) Integer.parseInt(conperId);
			System.out.println("获取到的用户编号为:"+uid);
			SalConper conper = conperService.selectSalConperById(uid);
			System.out.println("获取的联系人ID："+conper.getConperId());  
			System.out.println("查出的用户信息为"+conper);
			return conper;
		}
		
		
		//删除客户信息
		@RequestMapping("/delSalConper.do")
		public ModelAndView delSalConper(ModelAndView mav,SalConper con){
			System.out.println("删除的用户信息是："+con);
			conperService.delSalConper(con);
			SalCustomInfo custom = conperService.selectById(con.getCustomId());
			Long id = custom.getCustomId();
			List<SalConper> list = conperService.selectconperById(id);
			custom.setSalconper(list);

			for (SalConper salConper : list) {
				System.out.println("查询出来的联系人信息是"+salConper);
			}
			mav.addObject("conper",custom );
			mav.setViewName("custom/bleed");
			
			return mav;
		}
		
		
}
