package com.sc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysBranch;
import com.sc.bean.SysDuty;
import com.sc.bean.Users;
import com.sc.service.SysDutyService;

@Controller
@RequestMapping("sysdutyctlr")
public class sysDutyController {
	@Autowired
	SysDutyService sysDutyService;
	//查询职务信息
	@RequestMapping("/list.do")
	public ModelAndView test(ModelAndView mav){
		System.out.println("进来啦！");
		mav.addObject("look", sysDutyService.selectDuty());
		mav.setViewName("gongsi/Products_List");
		return mav;
	}
	//删除职务信息
	@RequestMapping("/del.do")
	public ModelAndView delduty(ModelAndView mav,SysDuty dutId){
		System.out.println("进来删除啦！");
		sysDutyService.delduty(dutId);
		mav.setViewName("redirect:list.do");
		return mav;
	}
	//添加职位信息
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav,SysBranch u) {
		System.out.println("来了四弟！");
		mav.addObject("ls", sysDutyService.selesetSysBranch());
		mav.addObject("cs", sysDutyService.selectSysComoany());
		mav.setViewName("gongsi/goadd");
		return mav;
	}
	//添加职位信息
	@RequestMapping("/updataduty.do")
	public ModelAndView updataduty(ModelAndView mav, SysDuty u) {
		System.out.println("添加信息！");
		Date date = new Date();
		u.setLastTime(date);
		sysDutyService.upadtaduty(u);
		mav.setViewName("redirect:list.do");
		return mav;
	}
	//查询要修改的信息
	@RequestMapping("/upadte.do")
	public ModelAndView upadte(ModelAndView mav,Long dutId) {
		System.out.println("来了四弟！");
		mav.addObject("u",sysDutyService.update(dutId));
		mav.addObject("lss", sysDutyService.selesetSysBranch());
		mav.addObject("css", sysDutyService.selectSysComoany());
		mav.setViewName("gongsi/goadd1");
		return mav;
	}
	//修改信息
	@RequestMapping("/upadtee.do")
	public ModelAndView upadtee(ModelAndView mav,SysDuty u) {
		System.out.println("来了修改！"+u);
		Date date = new Date();
		u.setLastTime(date);
		sysDutyService.updatee(u);
		mav.setViewName("redirect:list.do");
		return mav;
	}
}
