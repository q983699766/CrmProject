package com.sc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		public ModelAndView selectAlldetailSms1 (ModelAndView mav,OfficeDetailSms officeDetailSms){
			System.out.println("进入查询办公短消息详情方法");
			System.out.println("------------"+officeDetailSms);
			 List<OfficeDetailSms> selectsmsByExample1 = hrScheDetailService.selectsmsByExample(null);
			System.out.println("详细信息"+selectsmsByExample1);
			
			return mav;
		}	
		
}
