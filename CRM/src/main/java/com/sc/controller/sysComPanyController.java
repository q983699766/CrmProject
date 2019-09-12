package com.sc.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysBranch;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysComoany;
import com.sc.service.SysComPanyService;

@Controller
@RequestMapping("sycompanyctlr")
public class sysComPanyController {
	@Autowired
	SysComPanyService sysComPanyService;
	//查询职务信息
	@RequestMapping("/list.do")
	public ModelAndView test(ModelAndView mav){
		System.out.println("部门进来了！"+sysComPanyService.selectComoany());
		mav.addObject("selectComoany",sysComPanyService.selectComoany());
		mav.setViewName("gongsi/syscompany");
		return mav;
	}
	@RequestMapping("/del.do")
	public ModelAndView delcompany(ModelAndView mav, SysCOMPANY u){
		sysComPanyService.delComoany(u);
		mav.setViewName("redirect:list.do");
		return mav;
	}
	@RequestMapping("/goadd.do")
	public ModelAndView goodadd(ModelAndView mav){
		mav.setViewName("gongsi/goadd3");
		return mav;
	}
	@RequestMapping("/goadde.do")
	public ModelAndView goodadde(ModelAndView mav ,SysCOMPANY u){
		Date date = new Date();
		u.setLastTime(date);
		System.out.println("要添加公司信息"+u);
		sysComPanyService.addComoany(u);
		mav.setViewName("redirect:list.do");
		return mav;
	}
	@RequestMapping("/update.do")
	public ModelAndView upadte(ModelAndView mav ,Long comId){
		System.out.println("修改信息！"+sysComPanyService.updateComoany(comId));
		mav.addObject("update", sysComPanyService.updateComoany(comId));
		mav.setViewName("gongsi/eui2");
		return mav;
	}
		@RequestMapping("/updatee.do")
		public ModelAndView upadtee(ModelAndView mav ,SysCOMPANY u){
			Date date = new Date();
			u.setLastTime(date);
		sysComPanyService.upComoany(u);
		mav.setViewName("redirect:list.do");
		return mav;
	}
		@RequestMapping("/detail.do")
		@ResponseBody
		public SysCOMPANY detail(ModelAndView mav,Long dutId) {
			System.out.println("来了四弟111！");
			return sysComPanyService.updateComoany(dutId);
		}
}
