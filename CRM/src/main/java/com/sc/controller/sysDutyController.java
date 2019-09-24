package com.sc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysBranch;
import com.sc.bean.SysDuty;
import com.sc.service.SysDutyService;

@Controller
@RequestMapping("sysdutyctlr")
public class sysDutyController {
	@Autowired
	SysDutyService sysDutyService;
	//查询职务信息
	@RequestMapping("/listpage.do")
	public ModelAndView listpage(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize){
		//添加模型数据
	    mav.addObject("pi", sysDutyService.selectUsersPage(pageNum, pageSize, null));//循环${pi.list}  ${pi.pageNum}
	    mav.addObject("ls", sysDutyService.selesetSysBranch());
		mav.addObject("cs", sysDutyService.selectSysComoany());
		//设置视图名称
		mav.setViewName("gongsi/sysduty");//响应的视图名称，路径是：/WEB-INF/users/listpage.jsp
		return mav;
	}
	@RequestMapping("/list.do")
	//@ResponseBody
	public ModelAndView list(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="5")Integer limit){
	//	Map<String, Object>
	//List<SysDuty> selectDuty = sysDutyService.selectDuty();
	//PageInfo<SysDuty> selectUsersPage = sysDutyService.selectUsersPage(page, limit,null);
	/*HashMap<String, Object> hashMap = new HashMap<String, Object>();
	hashMap.put("status", 200);
	hashMap.put("message", "");
	hashMap.put("total", selectDuty.size());
	hashMap.put("rows", selectDuty);*/
		System.out.println("1111111111111111111111111111111111111");
		mav.setViewName("gongsi/layui");
		return mav;
	}
	
	@RequestMapping("/listui.do")
	@ResponseBody
	public Map<String, Object> listui(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="5")Integer limit,SysDuty k){
	List<SysDuty> selectDuty = sysDutyService.selectDuty();
	HashMap<String, Object> hashMap = new HashMap<String, Object>();
	hashMap.put("status", 200);
	hashMap.put("message", "");
	hashMap.put("total", selectDuty.size());
	hashMap.put("rows", selectDuty);
 	return hashMap;
	}
	
	//删除职务信息
	@RequestMapping("/del.do")
	public ModelAndView delduty(ModelAndView mav,SysDuty dutId){
		System.out.println("进来删除啦！");
		sysDutyService.delduty(dutId);
		mav.setViewName("redirect:listpage.do");
		return mav;
	}

	//添加职位信息
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav,SysBranch u) {
		System.out.println("来了四弟！");
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
		mav.setViewName("redirect:listpage.do");
		return mav;
	}
	//查询要修改的信息
	@RequestMapping("/upadte.do")
	public ModelAndView upadte(ModelAndView mav,Long dutId) {
		System.out.println("来了四弟！");
		mav.addObject("u",sysDutyService.update(dutId));
		mav.addObject("lss", sysDutyService.selesetSysBranch());
		mav.addObject("css", sysDutyService.selectSysComoany());
		mav.setViewName("gongsi/eui");
		return mav;
	}
	
	//查询要修改的信息
	@RequestMapping("/detail.do")
	@ResponseBody
	public SysDuty detail(ModelAndView mav,Long dutId,SysDuty u) {
		System.out.println("来了四弟111！"+dutId);
		return sysDutyService.update(dutId);
	}
	
	//修改信息
	@RequestMapping("/upadtee.do")
	public ModelAndView upadtee(ModelAndView mav,SysDuty u) {
		System.out.println("来了修改！"+u);
		Date date = new Date();
		u.setLastTime(date);
		sysDutyService.updatee(u);
		mav.setViewName("redirect:listpage.do");
		return mav;
	}

}
