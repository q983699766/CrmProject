package com.sc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeSms;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;
import com.sc.service.HrScheDetailService;
//import com.sc.service.HrScheDetailService;
//import com.sc.service.HrScheDetailService;
import com.sc.service.HrScheService;

@Controller
@RequestMapping("/Office")
public class HR_ScheduleConroller {
	
	@Autowired
	HrScheService hrScheService;
	
	@Autowired
	HrScheDetailService hrScheDetailService;

	
	
		
		
	//查询所有供应商信息
		@RequestMapping("/selectinfo.do")
		public ModelAndView selectAllSms (ModelAndView mav,OfficeSms officeSms,HttpSession session){
			System.out.println("进入查询办公短消息方法");
		   //查出客户信息表的信息
			List<OfficeSms> selectByExample = hrScheService.selectByExample(null);

			for (OfficeSms officeSms2 : selectByExample) {
				System.out.println(officeSms2.getComId());
				System.out.println(officeSms2.getSmsSender());
				
				Long comId = officeSms2.getComId();
				Long smsSender = officeSms2.getSmsSender();
				
				
				SysCOMPANY gsb = hrScheService.seleCOMById(comId);
				SysUsers seleuserById = hrScheService.seleuserById(smsSender);
				
				System.out.println("根据公司id查处的一条公司信息"+gsb+"--"+seleuserById);
				officeSms2.setSyscompany(gsb);
				officeSms2.setSysUsers(seleuserById);
				
			}
			
			System.out.println("set好公司信息后的新信息表"+selectByExample);

			mav.addObject("smsinfo", selectByExample);
			
			mav.setViewName("wanchenglong/guestbook");
			
			return mav;
			
			
		}	
		
		
		//查询所有供应商详细信息
		@RequestMapping("/selectdetailinfo.do")
		public ModelAndView selectAlldetailSms1 (ModelAndView mav,OfficeDetailSms officeDetailSms,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="5")Integer pageSize){
			
			System.out.println("进入查询办公短消息详情方法");
			System.out.println("------------"+officeDetailSms);
			  List<OfficeDetailSms> selectsmsByExample1 = hrScheDetailService.selectsmsByExample(null);
			  
			System.out.println("详细信息"+selectsmsByExample1);

			for (OfficeDetailSms officeDetailSms2 : selectsmsByExample1) {
				Long smsId = officeDetailSms2.getSmsId();
				Long receiverId = officeDetailSms2.getReceiverId();
				Long comId = officeDetailSms2.getComId();
				
				SysCOMPANY seleCOMById = hrScheDetailService.seleCOMById(comId);
				OfficeSms selesmsById = hrScheDetailService.selesmsById(smsId);
				SysUsers seleuserById = hrScheDetailService.seleuserById(receiverId);
				
				System.out.println(seleCOMById);
				officeDetailSms2.setSyscompany(seleCOMById);
				officeDetailSms2.setSysUsers(seleuserById);
				officeDetailSms2.setOfficeSms(selesmsById);
				
				
			}
			
			System.out.println("set后的信息為："+selectsmsByExample1);
			//分页
			PageHelper.startPage(pageNum, pageSize);
			PageInfo<OfficeDetailSms> pi=new PageInfo<OfficeDetailSms>(selectsmsByExample1);
			
			mav.addObject("smsdetailinfo", pi);
			
			mav.setViewName("wanchenglong/smsdetail");
			return mav;
		}	
		
		
		
		//设置状态
		@RequestMapping("/Officestate.do")
		@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
		public String selectById(ModelAndView mav,HttpServletRequest req,OfficeDetailSms officeDetailSms) throws IllegalStateException, IOException {
			System.out.println("进入状态改变");
			 String id = req.getParameter("id");
			 String sta = req.getParameter("sta");
			
			System.out.println("获取到的用户编号为:"+id);
			System.out.println("获取到的用户状态为:"+sta);
			
			officeDetailSms.setDetailId(Long.valueOf(id));
			officeDetailSms.setSmsState(sta);
			
			hrScheDetailService.updatesmsById(officeDetailSms);
	//		SalCustomInfo custom = conperService.selectById(uid);
			
			return "redirect:/Office/selectdetailinfo.do";
			

		}
		
		
		
}
