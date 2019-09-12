package com.sc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysBranch;
import com.sc.bean.SysDuty;
import com.sc.service.SysBranchService;
import com.sc.service.SysComPanyService;

@Controller
@RequestMapping("syBranchctlr")
public class sysBranchController {
	@Autowired
	SysBranchService SysBranchService;
	@Autowired
	SysComPanyService sysComPanyService;
	//查询职务信息
	@RequestMapping("/tiao.do")
	public ModelAndView listpage(ModelAndView mav){
		mav.addObject("branch", SysBranchService.selectSysBranch());
		mav.addObject("as", sysComPanyService.selectComoany());
		mav.setViewName("gongsi/add");
		return mav;
	}
	@RequestMapping("/seBranch.do")
	public ModelAndView addBranch(ModelAndView mav){
		mav.addObject("as", sysComPanyService.selectComoany());
		mav.setViewName("gongsi/goadd7");
		return mav;
	}
	@RequestMapping("/addBranch.do")
	public ModelAndView upBranch(ModelAndView mav,SysBranch u){
		Date date = new Date();
		u.setLastTime(date);
		SysBranchService.addaddBranch(u);
		mav.setViewName("redirect:tiao.do");
		return mav;
}
	@RequestMapping("/delBranch.do")
	public ModelAndView delBranch(ModelAndView mav,SysBranch u){
		SysBranchService.delBranch(u);
		mav.setViewName("redirect:tiao.do");
		return mav;
}
	@RequestMapping("/selectBranch.do")
	public ModelAndView selectBranch(ModelAndView mav,Long secId){
		mav.addObject("select", SysBranchService.selectBranch(secId));
		System.out.println("oo"+ SysBranchService.selectBranch(secId));
		mav.addObject("as", sysComPanyService.selectComoany());
		mav.setViewName("gongsi/eui4");
		return mav;
}
	@RequestMapping("/upBranch.do")
	public ModelAndView upBranch1(ModelAndView mav,SysBranch u){
		Date date = new Date();
		u.setLastTime(date);
		SysBranchService.upBranch(u);
		mav.setViewName("redirect:tiao.do");
		return mav;
}
	@RequestMapping("/detail.do")
	@ResponseBody
	public SysBranch detail(ModelAndView mav,Long dutId) {
		System.out.println("来了四弟111！");
		return SysBranchService.selectBranch(dutId);
	}
}
