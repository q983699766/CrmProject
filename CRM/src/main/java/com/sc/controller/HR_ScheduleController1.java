package com.sc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;
import com.sc.bean.OfficeDetailSmsExample.Criteria;
import com.sc.bean.OfficeSms;
import com.sc.bean.SalConper;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysUsers;
import com.sc.mapper.OfficeDetailSmsMapper;
import com.sc.service.ConperService;
import com.sc.service.HrScheDetailService;
import com.sc.service.HrScheService;

@Controller
@RequestMapping("detail")
public class HR_ScheduleController1 {

	@Autowired
	ConperService conperService;
	
	@Autowired
	HrScheService hrScheService;
	
	@Autowired
	HrScheDetailService hrScheDetailService;
	
	@Autowired
	OfficeDetailSmsMapper OfficeDetailSmsMapper;
	
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
	public OfficeSms selectById(ModelAndView mav,HttpServletRequest req,OfficeDetailSms officeDetailSms) throws IllegalStateException, IOException {
		
		
		
		//String smsId = req.getParameter("smsId");
		String detail = req.getParameter("detail");
		Long did =(long) Integer.parseInt(detail);
		System.out.println("获取到的用户编号为:"+did+"-"+officeDetailSms);
		
		//查看detail详细信息
		OfficeDetailSms selectdetailsmsById = hrScheService.selectdetailsmsById(did);
		officeDetailSms.setDetailId(selectdetailsmsById.getDetailId());
		officeDetailSms.setSmsState("1");
		hrScheDetailService.updatestate(officeDetailSms);
		System.out.println("更新后的officeDetailSms"+officeDetailSms);
		
		//获得smsID
		Long uid = selectdetailsmsById.getSmsId();
		//通过smsID得到sms信息
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

	
	
	
	
	
	//修改客户信息
		/*@RequestMapping("/updateSalCustomInfo.do")
		public ModelAndView updateFwxx(ModelAndView mav,SalCustomInfo sal){
			System.out.println("sal的数据为："+sal);
			conperService.updateSalCustomInfo(sal);
			mav.setViewName("redirect:./custom.do");
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
		
		
		//我的未读信息个数
		@RequestMapping("/countunread.do")
		public ModelAndView countunread(ModelAndView mav, HttpSession session){
			System.out.println("进入查找");
			SysUsers user = (SysUsers)session.getAttribute("nowuser");
			Long uid = user.getUserId();
			
			//OfficeDetailSmsExample officeDetailSmsExample = new OfficeDetailSmsExample();
			//Criteria c = officeDetailSmsExample.createCriteria();
			//c.andSmsStateEqualTo("0");
			//c.andReceiverIdEqualTo(uid);
			
			//List<OfficeDetailSms> selectByExample = OfficeDetailSmsMapper.selectByExample(officeDetailSmsExample);
			//Integer num = selectByExample.size();
			Integer num = hrScheDetailService.countnum(uid);
			session.setAttribute("num",num );
			//mav.addObject("num", num);
			mav.setViewName("wanchenglong/smsdetail");
			return mav;
		}
		
		
}
