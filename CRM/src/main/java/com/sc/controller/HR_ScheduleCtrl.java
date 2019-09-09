package com.sc.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.bean.OOfficePerSche;
import com.sc.service.HR_PerAgendaService;

@Controller
@Scope("prototype")
@RequestMapping("schedule")
public class HR_ScheduleCtrl {
   
	@Resource
	private HR_PerAgendaService hR_PerAgendaServiceImp;
	
	
	// 个人日程列表（分页查询）
	@RequestMapping("/list.do") //请求路径是schedule/list.action
	@ResponseBody
	public List list(OOfficePerSche sche,HttpSession session){
		System.out.println("start:"+sche.getStart()+"-----end:"+sche.getEnd());
		
		
		//---需要获取用户id和公司id---start
		sche.setUid("1");
		sche.setCid("1");
		//---需要获取用户id和公司id---end
		
		System.out.println("=====对象信息list====="+sche);
		List list = hR_PerAgendaServiceImp.getAllSchedule(sche);
		System.out.println(list);
		return list;
	}
	
	
	@RequestMapping("/addsche.do")
	@ResponseBody
	public String addsche(@RequestBody OOfficePerSche sche,HttpSession session){
		System.out.println("=====对象信息add====="+sche);
		System.out.println("=====对象信息session====="+session);
		
		
		
		//---需要获取用户id和公司id---start
		sche.setUid("1");
		sche.setCid("1");
		//---需要获取用户id和公司id---end
		
		sche.setAllDay("0");
		sche.setTopic("dasd");//主题暂时为'dasd'
		sche.setLasttime(new Date().toLocaleString());
		
		hR_PerAgendaServiceImp.addSchedule(sche);
		System.out.println("---Id:"+sche.getId());
		
		return sche.getId();
	}
	
	
	@RequestMapping("/updatesche.do")
	@ResponseBody
	public void updatesche(@RequestBody OOfficePerSche sche,HttpSession session){
		System.out.println("=====对象信息update====="+sche);
		
		
		
		//---需要获取用户id和公司id---start
		sche.setUid("1");
		sche.setCid("1");
		//---需要获取用户id和公司id---end
		
		sche.setAllDay("0");
		sche.setTopic("dasd");//主题暂时为'dasd'
		sche.setLasttime(new Date().toLocaleString());
		
		hR_PerAgendaServiceImp.updateSchedule(sche);
		
	}
	
	@RequestMapping("/deletesche.do")
	@ResponseBody
	public void deletesche(@RequestBody OOfficePerSche sche){
		System.out.println("=====对象信息delete====="+sche);
		hR_PerAgendaServiceImp.delSchedule(sche);
	}
	
	
}
