package com.sc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeSms;
import com.sc.bean.SalConper;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;
import com.sc.service.ConperService;
import com.sc.service.HrScheService;

@Controller
@RequestMapping("detail")
public class HR_ScheduleController1 {

	@Autowired
	ConperService conperService;
	
	@Autowired
	HrScheService hrScheService;
	
	//查询所有客户--销售经理可以进
	/*@RequestMapping("/custom.do")
	public ModelAndView custom(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize,
			SalCustomInfo sal){
		System.out.println("11用户进来了！！");
		mav.addObject("pi", conperService.selectSalCustomInfoPage(pageNum, pageSize,sal));
		mav.setViewName("custom/conper");
		return mav;	
	}*/
	
	//通过id查询出所有用户
	//*****id不能重复
	@RequestMapping("/selectsmsById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public OfficeSms selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
		String smsId = req.getParameter("smsId");
		Long uid =(long) Integer.parseInt(smsId);
		System.out.println("获取到的用户编号为:"+uid);
		
		OfficeSms selectById = hrScheService.selectById(uid);
		Long comId = selectById.getComId();
		Long smsSender = selectById.getSmsSender();
		
		SysCOMPANY seleCOMById = hrScheService.seleCOMById(comId);
		SysUsers seleuserById = hrScheService.seleuserById(smsSender);
		
		//SalCustomInfo custom = conperService.selectById(uid);
		selectById.setSyscompany(seleCOMById);
		selectById.setSysUsers(seleuserById);
		
		System.out.println("查出的用户为"+selectById);
		return selectById;
	}

	
	/*//发送信息
	@RequestMapping("/addsmsInfo.do")
	public ModelAndView addsmsInfo(ModelAndView mav,HttpServletRequest req,
			SalCustomInfo sal,OfficeSms officeSms,OfficeDetailSms officeDetailSms) throws IllegalStateException, IOException{
		Date date = new Date();
		System.out.println("进入发送信息！！————————————————————————");
		System.out.println(officeSms+"+"+officeDetailSms);
		String smssend = req.getParameter("smssend");
		String smshidle = req.getParameter("smshidle");
		String smsreciver = req.getParameter("smsreciver");
		String companyid = req.getParameter("companyid");
		String smsdetail1 = req.getParameter("smsdetail1");
		
		//System.out.println(smsdetail1+"--");
		
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
		officeDetailSms.setReceiverId(Long.valueOf(smsreciver));
		officeDetailSms.setSmsState("0");
		//根据发送者id查找接收者公司 
		SysUsers seleuserById2 = hrScheService.seleuserById(Long.valueOf(smsreciver));
		officeDetailSms.setComId(seleuserById2.getComId());
		officeDetailSms.setLastTime(date);
		hrScheService.adddetailsms(officeDetailSms);
		
		System.out.println("-------"+"++++++"+officeSms+officeDetailSms);
		mav.setViewName("redirect:Office/selectdetailinfo.do");
		return mav;
	}*/
	
	//删除客户信息
		/*@RequestMapping("/delSalCustomInfo.do")
		public ModelAndView delSalCustomInfo(ModelAndView mav,SalCustomInfo sal){
			System.out.println("删除的用户信息是："+sal);
			conperService.delSalCustomInfo(sal);
			//重定向到列表方法
			mav.setViewName("redirect:./custom.do");
			return mav;
		}
	*/
	//修改客户信息
		/*@RequestMapping("/updateSalCustomInfo.do")
		public ModelAndView updateFwxx(ModelAndView mav,SalCustomInfo sal){
			System.out.println("sal的数据为："+sal);
			conperService.updateSalCustomInfo(sal);
			mav.setViewName("redirect:./custom.do");
			return mav;
		}
		*/
	//从a标签“联系人”跳转到联系人页面查看所有信息
		/*@RequestMapping("/gotoConper.do")
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
		*/
		
		//添加联系人信息
		@RequestMapping("/selectsmsuser.do")
		@ResponseBody
		public List<SysUsers> selectsmsuser(ModelAndView mav,SysUsers sysUsers,
				SalConper con) throws IllegalStateException, IOException{
			System.out.println("进入查询用户");
			
			List<SysUsers> user = hrScheService.selectuserByExample(null);
			return user;
		}
		
		
		
		//添加联系人信息
				@RequestMapping("/selectsmsbyid.do")
				@ResponseBody
				public OfficeSms selectsmsbyid(ModelAndView mav,SysUsers sysUsers,HttpServletRequest req,
						SalConper con) throws IllegalStateException, IOException{
					String detailId = req.getParameter("detailId");
					System.out.println("获得的detailId为：==="+detailId);
					long l = Long.parseLong(detailId);
					OfficeDetailSms selectdetailsmsById = hrScheService.selectdetailsmsById(l);
					Long smsId = selectdetailsmsById.getSmsId();
					OfficeSms selectById = hrScheService.selectById(smsId);
					//Long smsSender = selectById.getSmsSender();
					//System.out.println("发送者smsSender为：===="+smsSender);
					
					
					//List<SysUsers> user = hrScheService.selectuserByExample(null);
					return selectById;
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
