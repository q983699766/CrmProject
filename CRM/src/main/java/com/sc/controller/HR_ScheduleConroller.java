package com.sc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeSms;
import com.sc.bean.SalCustomInfo;
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

	
	
			//查询所有供应商信息状态
			@RequestMapping("/selectreaded.do")
			public ModelAndView selectreaded (ModelAndView mav,OfficeSms officeSms,HttpSession session,OfficeDetailSms officeDetailSms,HttpServletRequest req,
					@RequestParam(defaultValue="1")Integer pageNum,
					@RequestParam(defaultValue="5")Integer pageSize){
				
				System.out.println("得到的数据为：--"+officeSms);
				String read = req.getParameter("read");
				System.out.println("进入查询办公短消息方法"+read);
				
				//session.setAttribute("nowuser", sysusers);
				SysUsers sysUsers = (SysUsers)session.getAttribute("nowuser");
				Long userId = sysUsers.getUserId();
				String userName = sysUsers.getUserName();
				System.out.println("本用户ID"+userId+"本用户名字"+userName);
			   //查出客户信息表的信息
				PageInfo<OfficeDetailSms> selectByExample = hrScheService.selectreaded(pageNum, pageSize,null,userId,officeSms,read);
				
				//System.out.println("set好公司信息后的新信息表"+selectByExample);

				mav.addObject("smsinfo", selectByExample);
				
				mav.setViewName("wanchenglong/guestbook");
				
				return mav;
				
				
			}	
			
	
		
		
	//查询所有供应商信息
		@RequestMapping("/selectinfo.do")
		public ModelAndView selectAllSms (ModelAndView mav,OfficeSms officeSms,HttpSession session,OfficeDetailSms officeDetailSms,HttpServletRequest req,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="5")Integer pageSize){
			System.out.println("进入查询办公短消息方法");
			String smsHeadline = req.getParameter("smsHeadline");
			System.out.println("得到的数据为：--"+smsHeadline);
			System.out.println("得到的数据为：--"+officeSms);
			
			//session.setAttribute("nowuser", sysusers);
			SysUsers sysUsers = (SysUsers)session.getAttribute("nowuser");
			Long userId = sysUsers.getUserId();
			String userName = sysUsers.getUserName();
			System.out.println("本用户ID"+userId+"本用户名字"+userName);
		   //查出客户信息表的信息
			PageInfo<OfficeDetailSms> selectByExample = hrScheService.selectByExample(pageNum, pageSize,null,userId,smsHeadline,officeSms);
			
			//System.out.println("set好公司信息后的新信息表"+selectByExample);

			mav.addObject("smsinfo", selectByExample);
			
			mav.setViewName("wanchenglong/guestbook");
			
			return mav;
			
			
		}	
		
		
		//查询所有详细信息
		@RequestMapping("/selectdetailinfo.do")
		public ModelAndView selectAlldetailSms1 (ModelAndView mav,OfficeDetailSms officeDetailSms,OfficeSms officeSms,HttpServletRequest req,HttpSession session,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="5")Integer pageSize){
			
			System.out.println("进入查询办公短消息详情方法");
			System.out.println("------------"+officeDetailSms+"++++++++"+officeSms);
			String smsHeadline = req.getParameter("smsHeadline");
			System.out.println("得到的数据为：--"+smsHeadline);
			System.out.println("得到的数据为：--"+officeSms);
			
			SysUsers sysUsers = (SysUsers)session.getAttribute("nowuser");
			Long smssend = sysUsers.getUserId();
			  PageInfo<OfficeDetailSms> selectsmsByExample = hrScheDetailService.selectsmsByExample(pageNum, pageSize,null,smsHeadline,smssend,officeSms);
			  
			//System.out.println("详细信息"+selectsmsByExample1);

			/*for (OfficeDetailSms officeDetailSms2 : selectsmsByExample1) {
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
			}*/
			
			//System.out.println("set后的信息為："+selectsmsByExample1);
			//分页
			//PageHelper.startPage(pageNum, pageSize);
			//PageInfo<OfficeDetailSms> pi=new PageInfo<OfficeDetailSms>(selectsmsByExample1);
			
			mav.addObject("smsdetailinfo", selectsmsByExample);
			mav.addObject("smsHeadline", smsHeadline);
			
			mav.setViewName("wanchenglong/smsdetail");
			return mav;
		}	
		
		
		
		//设置状态
		@RequestMapping("/Officestate.do")
		@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
		public ModelAndView selectById(ModelAndView mav,HttpServletRequest req,OfficeDetailSms officeDetailSms) throws IllegalStateException, IOException {
			System.out.println("进入状态改变");
			 String idd = req.getParameter("id");
			System.out.println("获取到的用户编号为:"+idd);
			System.out.println("officeDetailSms1---"+officeDetailSms);
			
			 //Long l=(long) Integer.parseInt(idd);
			long l = Long.parseLong(idd);
			OfficeDetailSms selesmsByid = hrScheDetailService.selesmsByid(l);
			System.out.println("selesmsByid"+selesmsByid);
			if(selesmsByid.getSmsState().equals("1")){
				
				System.out.println("-------已阅览");
				officeDetailSms.setDetailId(selesmsByid.getDetailId());
				officeDetailSms.setSmsState("0");
				System.out.println("officeDetailSms2---"+officeDetailSms);
			}
			
			if(selesmsByid.getSmsState().equals("0")){
				
				System.out.println("-------未阅览");
				officeDetailSms.setDetailId(selesmsByid.getDetailId());
				officeDetailSms.setSmsState("1");
				System.out.println("officeDetailSms2---"+officeDetailSms);
			}
			
			
			hrScheDetailService.updatestate(officeDetailSms);
			//OfficeDetailSms selesmsByid = hrScheDetailService.selesmsByid(Long.valueOf(id));
			//System.out.println("-----"+selesmsByid);
			//officeDetailSms.setDetailId(Long.valueOf(id));
			//officeDetailSms.setSmsState(sta);
			//hrScheDetailService.updatesmsById(officeDetailSms);
	//		SalCustomInfo custom = conperService.selectById(uid);
			
			mav.setViewName("redirect:./selectdetailinfo.do");
			return mav;
			

		}
		
		
		
		
		//设置我的状态
				@RequestMapping("/selectmysmsById.do")
				@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
				public ModelAndView selectmysmsById(ModelAndView mav,HttpServletRequest req,OfficeDetailSms officeDetailSms) throws IllegalStateException, IOException {
					System.out.println("进入状态改变==========-");
					 String idd = req.getParameter("id");
					System.out.println("获取到的用户编号为:"+idd);
					System.out.println("officeDetailSms1---"+officeDetailSms);
					
					 //Long l=(long) Integer.parseInt(idd);
					long l = Long.parseLong(idd);
					OfficeDetailSms selesmsByid = hrScheDetailService.selesmsByid(l);
					System.out.println("selesmsByid"+selesmsByid);
					if(selesmsByid.getSmsState().equals("1")){
						
						System.out.println("-------已阅览");
						officeDetailSms.setDetailId(selesmsByid.getDetailId());
						officeDetailSms.setSmsState("0");
						System.out.println("officeDetailSms2---"+officeDetailSms);
					}
					
					if(selesmsByid.getSmsState().equals("0")){
						
						System.out.println("-------未阅览");
						officeDetailSms.setDetailId(selesmsByid.getDetailId());
						officeDetailSms.setSmsState("1");
						System.out.println("officeDetailSms2---"+officeDetailSms);
					}
					
					
					hrScheDetailService.updatestate(officeDetailSms);
					//OfficeDetailSms selesmsByid = hrScheDetailService.selesmsByid(Long.valueOf(id));
					//System.out.println("-----"+selesmsByid);
					//officeDetailSms.setDetailId(Long.valueOf(id));
					//officeDetailSms.setSmsState(sta);
					//hrScheDetailService.updatesmsById(officeDetailSms);
			//		SalCustomInfo custom = conperService.selectById(uid);
					
					mav.setViewName("redirect:./selectinfo.do");
					return mav;
					

				}
				
				
		
		
		
		//发送信息
		@RequestMapping("/addsmsInfo.do")
		public ModelAndView addsmsInfo(ModelAndView mav,HttpServletRequest req,HttpSession session,
				SalCustomInfo sal,OfficeSms officeSms,OfficeDetailSms officeDetailSms, Long[] id) throws IllegalStateException, IOException{
			Date date = new Date();
			System.out.println("进入发送信息！！————————————————————————");
			System.out.println("333333333333333333"+id);
			
			
			for (Long long1 : id) {
				System.out.println("4444444444--"+long1);
				
				//session.setAttribute("nowuser", sysusers);
				SysUsers sysUsers = (SysUsers)session.getAttribute("nowuser");
				Long smssend = sysUsers.getUserId();
				
				System.out.println(officeSms+"+"+officeDetailSms);
				//String smssend = req.getParameter("smssend");
				String smshidle = req.getParameter("smshidle");
				//String smsreciver = req.getParameter("smsreciver");
				//String companyid = req.getParameter("companyid");
				String smsdetail1 = req.getParameter("smsdetail1");
				
				officeSms.setSmsHeadline(smshidle);
				officeSms.setSmsContent(smsdetail1);
				officeSms.setSmsSender(Long.valueOf(smssend));
				//根据发送者id查找发送者公司 
				SysUsers seleuserById = hrScheService.seleuserById(Long.valueOf(smssend));
				officeSms.setComId(seleuserById.getComId());
				officeSms.setLastTime(date);
				//System.out.println(officeSms+"-------------------");
				//System.out.println(date);
				hrScheService.addsmsInfo(officeSms);
				
				System.out.println("新取到的smsid---------"+officeSms.getSmsId());
				officeDetailSms.setSmsId(officeSms.getSmsId());
				officeDetailSms.setReceiverId(long1);
				officeDetailSms.setSmsState("0");
				//根据发送者id查找接收者公司 
				SysUsers seleuserById2 = hrScheService.seleuserById(long1);
				officeDetailSms.setComId(seleuserById2.getComId());
				officeDetailSms.setLastTime(date);
				hrScheService.adddetailsms(officeDetailSms);
				
				System.out.println("-------"+long1+"+++++++"+officeSms+officeDetailSms);
			}
			
			
			mav.setViewName("redirect:./selectdetailinfo.do");
			return mav;
		}
		
		
		
		
		
		
		//回复信息
				@RequestMapping("/replacesmsInfo.do")
				public ModelAndView replacesmsInfo(ModelAndView mav,HttpServletRequest req,HttpSession session,
						SalCustomInfo sal,OfficeSms officeSms,OfficeDetailSms officeDetailSms) throws IllegalStateException, IOException{
					Date date = new Date();
					System.out.println("进入回复信息！！————————————————————————");
					String detail11 = req.getParameter("detail11");
					System.out.println("得到的detail11为：==="+detail11);
					
					//for (Long long1 : id) {
						//System.out.println("4444444444--"+long1);
						
						//session.setAttribute("nowuser", sysusers);
						SysUsers sysUsers = (SysUsers)session.getAttribute("nowuser");
						Long smssend = sysUsers.getUserId();
						
						//System.out.println(officeSms+"+"+officeDetailSms);
						//String smssend = req.getParameter("smssend");
						String smshidle = req.getParameter("smshidle");
						//String smsreciver = req.getParameter("smsreciver");
						//String companyid = req.getParameter("companyid");
						String smsdetail1 = req.getParameter("smsdetail1");
						
						officeSms.setSmsHeadline(smshidle);
						officeSms.setSmsContent(smsdetail1);
						officeSms.setSmsSender(Long.valueOf(smssend));
						//根据发送者id查找发送者公司 
						SysUsers seleuserById = hrScheService.seleuserById(Long.valueOf(smssend));
						officeSms.setComId(seleuserById.getComId());
						officeSms.setLastTime(date);
						//System.out.println(officeSms+"-------------------");
						//System.out.println(date);
						hrScheService.addsmsInfo(officeSms);
						
						System.out.println("新取到的smsid---------"+officeSms.getSmsId());
						officeDetailSms.setSmsId(officeSms.getSmsId());
						officeDetailSms.setReceiverId(Long.valueOf(detail11));
						officeDetailSms.setSmsState("0");
						//根据发送者id查找接收者公司 
						SysUsers seleuserById2 = hrScheService.seleuserById(Long.valueOf(detail11));
						officeDetailSms.setComId(seleuserById2.getComId());
						officeDetailSms.setLastTime(date);
						hrScheService.adddetailsms(officeDetailSms);
						
						System.out.println("-------"+Long.valueOf(detail11)+"+++++++"+officeSms+officeDetailSms);
					//}
					
					
					mav.setViewName("redirect:./selectinfo.do");
					return mav;
				}
		
		//删除详细信息
		@RequestMapping("/delsmsInfo.do")
		public ModelAndView delSalCustomInfo(ModelAndView mav,OfficeDetailSms officeDetailSms,HttpServletRequest req){
					//System.out.println("---------删除的用户信息是1："+officeDetailSms);
					String detailId = req.getParameter("detailId");
					//System.out.println("得到的详情ID：++++"+detailId);
					//officeDetailSms.setDetailId(Long.valueOf(detailId));
					System.out.println("---------删除的用户信息是2："+officeDetailSms);
					
					//开始
					OfficeDetailSms selesmsBybean = hrScheDetailService.selesmsBybean(officeDetailSms);
					System.out.println("获得的短消息详情++++"+selesmsBybean);
					
					Long smsId = selesmsBybean.getSmsId();
					hrScheDetailService.deldetailsmsInfo(officeDetailSms);
					hrScheDetailService.delsmsInfo(smsId);
					//结束
					
					//重定向到列表方法
					mav.setViewName("redirect:./selectdetailinfo.do");
					return mav;
				}
		
		
		//删除详细信息
				@RequestMapping("/delmysmsInfo.do")
				public ModelAndView delmysmsInfo(ModelAndView mav,OfficeDetailSms officeDetailSms,HttpServletRequest req){
							//System.out.println("---------删除的用户信息是1："+officeDetailSms);
							String detailId = req.getParameter("detailId");
							//System.out.println("得到的详情ID：++++"+detailId);
							//officeDetailSms.setDetailId(Long.valueOf(detailId));
							System.out.println("---------删除的用户信息是2："+officeDetailSms);
							
							//开始
							OfficeDetailSms selesmsBybean = hrScheDetailService.selesmsBybean(officeDetailSms);
							System.out.println("获得的短消息详情++++"+selesmsBybean);
							
							Long smsId = selesmsBybean.getSmsId();
							hrScheDetailService.deldetailsmsInfo(officeDetailSms);
							hrScheDetailService.delsmsInfo(smsId);
							//结束
							
							//重定向到列表方法
							mav.setViewName("redirect:./selectinfo.do");
							return mav;
						}
				
				
				
				
		
		//批量删除信息
		  @RequestMapping("/delallaa.do")
			public ModelAndView delall(ModelAndView mav,HttpServletRequest req){
			  String [] xx=req.getParameterValues("test11");
			  System.out.println("-----------"+xx);
			  System.out.println("进入删除3333333333333333");
			  if(xx==null||xx.length==0){
				  System.out.println("数组为空");
				  mav.setViewName("redirect:./selectdetailinfo.do");
					return mav;
			  }else{
			    for (int i = 0; i < xx.length; i++) {
			    	 long l = Long.parseLong(xx[i]);
			    	 System.out.println("111111111111"+l);
			    	 OfficeDetailSms selesmsBybean = hrScheDetailService.selesmsByid(l);
						System.out.println("获得的短消息详情++++"+selesmsBybean);
						Long smsId = selesmsBybean.getSmsId();
						
						hrScheDetailService.deldetailsmsbyid(l);
						hrScheDetailService.delsmsInfo(smsId);
			    	
					
				}
				//重定向到列表方法
				mav.setViewName("redirect:./selectdetailinfo.do");
				return mav;
			  }
			}
		
		
		
		  
		//批量删除我的信息
		  @RequestMapping("/delmyallaa.do")
			public ModelAndView delmyall(ModelAndView mav,HttpServletRequest req){
			  String [] xx=req.getParameterValues("test111");
			  System.out.println("-----------我的"+xx);
			  System.out.println("进入删除3333333333333333");
			  if(xx==null||xx.length==0){
				  mav.setViewName("redirect:./selectinfo.do");
					return mav;
			  }else{
			    for (int i = 0; i < xx.length; i++) {
			    	 long l = Long.parseLong(xx[i]);
			    	 System.out.println("111111111111"+l);
			    	 OfficeDetailSms selesmsBybean = hrScheDetailService.selesmsByid(l);
						System.out.println("获得的短消息详情++++"+selesmsBybean);
						Long smsId = selesmsBybean.getSmsId();
						
						hrScheDetailService.deldetailsmsbyid(l);
						hrScheDetailService.delsmsInfo(smsId);
			    	
					
				}
				//重定向到列表方法
				mav.setViewName("redirect:./selectinfo.do");
				return mav;
			  }
			}
		
		
		
		
}
