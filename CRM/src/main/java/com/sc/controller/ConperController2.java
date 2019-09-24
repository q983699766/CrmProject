package com.sc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.bean.SalBleed;
import com.sc.bean.SalConper;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SalCustomInfoExample;
import com.sc.bean.SalCustomInfoExample.Criteria;
import com.sc.bean.SalFeedback;
import com.sc.bean.SalRecord;
import com.sc.bean.SysUsers;
import com.sc.service.ConperService;

@Controller
@RequestMapping("conctlr")
public class ConperController2 {

	@Autowired
	ConperService conperService;
	//查询所有客户
	@RequestMapping("/custom.do")
	public ModelAndView custom(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize,
			@RequestParam(defaultValue="")String message,
			SalCustomInfo sal){
		System.out.println("11用户进来了！！");
		
		if("".equals(message)){
			PageInfo<SalCustomInfo> selectSalCustomInfoPage = conperService.selectSalCustomInfoPage(pageNum, pageSize, sal);
			System.out.println("总条数"+selectSalCustomInfoPage.getTotal());
			mav.addObject("pi", selectSalCustomInfoPage);
			
		}else{
			PageInfo<SalCustomInfo> selectSalCustomInfoMessage = conperService.selectSalCustomInfoMessage(pageNum, pageSize,message);
			System.out.println("*******"+selectSalCustomInfoMessage.getTotal());
			mav.addObject("pi", selectSalCustomInfoMessage);
		}
		mav.addObject("message", message);
		
		mav.setViewName("custom/conper");
		return mav;	
	}
	
	//查询所有暂缓流失客户
	@RequestMapping("/lose.do")
	public ModelAndView lose(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize,
			@RequestParam(defaultValue="")String message,
			SalCustomInfo sal){
		System.out.println("11用户进来了！！");
		
		if("".equals(message)){
			PageInfo<SalCustomInfo> selectLosePage = conperService.selectLosePage(pageNum, pageSize, sal);
			System.out.println(selectLosePage.getList());
			mav.addObject("pi", conperService.selectLosePage(pageNum, pageSize,sal));
			
		}else{
			PageInfo<SalCustomInfo> selectLoseMessage = conperService.selectLoseMessage(pageNum, pageSize,message);
			System.out.println(selectLoseMessage.getTotal());
			mav.addObject("pi", selectLoseMessage);
		}
		mav.addObject("message", message);
		
		mav.setViewName("custom/lose");
		return mav;	
	}
	
	//通过id查询出所有用户
	//*****id不能重复
	@RequestMapping("/selectById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public SalCustomInfo selectById(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
		String customId = req.getParameter("customId");
		Long uid =(long) Integer.parseInt(customId);
		System.out.println("获取到的用户编号为:"+uid);
		SalCustomInfo custom = conperService.selectById(uid);
		
		System.out.println("查出的用户为"+custom);
		return custom;
	}

	
	//添加用户信息
	@RequestMapping("/addSalCustomInfo.do")
	public ModelAndView addSalCustomInfo(ModelAndView mav,
			SalCustomInfo sal) throws IllegalStateException, IOException{
		Date date = new Date();
		sal.setLastTime(date);
		sal.setCustomState("正在合作");
		System.out.println("进入到添加控制器了！！");
		System.out.println(sal.getNextcontactTime());
		conperService.addSalCustomInfo(sal);
		mav.setViewName("redirect:./custom.do");
		return mav;
	}
	
	//删除客户信息
		@RequestMapping("/delSalCustomInfo.do")
		public ModelAndView delSalCustomInfo(ModelAndView mav,SalCustomInfo sal){
			System.out.println("删除的用户信息是："+sal);
			conperService.delSalCustomInfo(sal);
			//重定向到列表方法
			mav.setViewName("redirect:./custom.do");
			return mav;
		}
		
	//批量删除
		@RequestMapping("/delAll.do")
		public ModelAndView delAll(ModelAndView mav,SalCustomInfo sal,HttpServletRequest req){
			System.out.println("jingru888888888");
			String[] values = req.getParameterValues("box");
			System.out.println("111111111"+values);
			for (int i = 0; i < values.length; i++) {
				long parseLong = Long.parseLong(values[i]);
				conperService.delAll(parseLong);	
			}
			//重定向到列表方法
			mav.setViewName("redirect:./custom.do");
			return mav;
		}
		
	
	//修改客户信息
		@RequestMapping("/updateSalCustomInfo.do")
		public ModelAndView updateFwxx(ModelAndView mav,SalCustomInfo sal){
			System.out.println("sal的数据为："+sal);
			conperService.updateSalCustomInfo(sal);
			mav.setViewName("redirect:./custom.do");
			return mav;
		}
		
	//从a标签“联系人”跳转到联系人页面查看所有信息
		@RequestMapping("/gotoConper.do")
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
		
		
		//添加联系人信息
		@RequestMapping("/addSalConper.do")
		public ModelAndView addSalConper(ModelAndView mav,
				SalConper con) throws IllegalStateException, IOException{
			Date date = new Date();
			con.setLastTime(date);
			Long customId = con.getCustomId();
			con.setCustomId(customId);
			System.out.println("获取到的客户ID为："+customId);
			System.out.println("进入到添加控制器了！！");
			conperService.addSalConper(con);
			SalCustomInfo custom = conperService.selectById(customId);
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
		
		
		//删除联系人
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
		
		
		//从a标签“查看联系记录”跳转到联系记录页面查看所有信息
				@RequestMapping("/gotoRecord.do")
				public ModelAndView gotoRecord(ModelAndView mav,HttpServletRequest req){
					String conperId = req.getParameter("conperId");
					Long uid =(long) Integer.parseInt(conperId);
					System.out.println("获取到的联系人编号为:"+uid);
					SalConper conper =  conperService.selectSalConById(uid);
					Long id = conper.getConperId();
					List<SalRecord> list =  conperService.selectrecordById(id);
					conper.setSalrecord(list);
					mav.addObject("record",conper);
					mav.setViewName("custom/record");
					
					return mav;
				}
				
				
				//添加联系记录
				@RequestMapping("/addSalRecord.do")
				public ModelAndView addSalRecord(ModelAndView mav,
						SalRecord rec) throws IllegalStateException, IOException{
					Date date = new Date();
					rec.setLastTime(date);
					Long conperId = rec.getCustomId();
					rec.setCustomId(conperId);
					System.out.println("获取到的联系人ID为："+conperId);
					System.out.println("进入到添加控制器了！！");
					conperService.addSalRecord(rec);
					SalConper conper =  conperService.selectSalConById(conperId);
					Long id = conper.getConperId();
					List<SalRecord> list =  conperService.selectrecordById(id);
					conper.setSalrecord(list);
					mav.addObject("record",conper);
					mav.setViewName("custom/record");
					
					return mav;
				}
				
			//删除联系记录
				@RequestMapping("delSalRecord.do")
				public ModelAndView delSalRecord(ModelAndView mav,SalRecord rec){
					System.out.println("删除的信息是："+rec);
					conperService.delSalRecord(rec);
					SalConper conper =  conperService.selectSalConById(rec.getRecordId());
					Long id = conper.getConperId();
					List<SalRecord> list =  conperService.selectrecordById(id);
					conper.setSalrecord(list);
					mav.addObject("record",conper);
					mav.setViewName("custom/record");
					
					return mav;
					
				}
				
				
				//通过客户ID查询所有反馈记录--分页
				@RequestMapping("/feedback.do")
				public ModelAndView feedback(ModelAndView mav,
						@RequestParam(defaultValue="1")Integer pageNum,
						@RequestParam(defaultValue="5")Integer pageSize,
						Long customId){
					System.out.println("11用户进来了！！");
					mav.addObject("customId",customId);
					mav.addObject("pi", conperService.selectSalFeedbackById(pageNum, pageSize,customId));
					mav.setViewName("custom/feedback");
					return mav;	
				}
		
				//通过优先级来模糊查询反馈记录--分页
				@RequestMapping("/back.do")
				public ModelAndView back(ModelAndView mav,
						@RequestParam(defaultValue="1")Integer pageNum,
						@RequestParam(defaultValue="5")Integer pageSize,
						String pri){
					System.out.println("222用户进来了！！");
					mav.addObject("pi", conperService.selectSalFeedbackByPri(pageNum, pageSize,pri));
					mav.setViewName("custom/feedback");
					return mav;	
				}
				
				
				
				
				//添加反馈记录
				
				@RequestMapping("/addSalFeedback.do")
				public ModelAndView addSalFeedback(ModelAndView mav,
						SalFeedback feedback,HttpSession session) throws IllegalStateException, IOException{
					Date date = new Date();
					feedback.setLastTime(date);
					String ll="1";
					Long l=Long.valueOf(ll);
					feedback.setComId(l);
					Long CustomId = feedback.getCustomId();
					feedback.setCustomId(CustomId);
					SysUsers users = (SysUsers) session.getAttribute("nowuser");
					Long userId = users.getUserId();
					feedback.setHeadId(userId);
					System.out.println("获取到的客户ID为："+CustomId);
					System.out.println("进入到反馈添加控制器了！！");
					conperService.addSalFeedback(feedback);						
					mav.setViewName("redirect:./feedback.do?customId="+CustomId);
					
					return mav;
				}
				
				//删除反馈记录
				@RequestMapping("delSalFeedback.do")
				public ModelAndView delSalFeedback(ModelAndView mav,SalFeedback feedback){
					System.out.println("删除的信息是："+feedback);
					conperService.delSalFeedback(feedback);
					Long CustomId = feedback.getCustomId();
					feedback.setCustomId(CustomId);
					System.out.println("获取到的客户ID为："+CustomId);
					System.out.println("进入到反馈删除控制器了！！");
					mav.setViewName("redirect:./feedback.do?customId="+CustomId);
					return mav;
					
				}	
				
		//查询单条流失信息返回到弹层中
				@RequestMapping("/goaddSalBleed.do")
				@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
				public Long goaddSalBleed(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
					String customId = req.getParameter("customId");
					System.out.println("未转圜"+customId);
					Long uid =Long.parseLong(customId);
					return uid;
				}	
				
				
		//添加流失记录
		
				@RequestMapping("/addSalBleed.do")
				public ModelAndView addSalBleed(ModelAndView mav,
						SalBleed bleed,HttpSession session,HttpServletRequest req) throws IllegalStateException, IOException{
					System.out.println("000000000000000000000"+bleed);
					System.out.println("进入流失控制器了！！");
					Date date = new Date();
					bleed.setLastTime(date);
					String ll="1";
					Long l=Long.valueOf(ll);				
					bleed.setComId(l);
					Long operatorId = bleed.getOperatorId();
					System.out.println("&&&&"+operatorId);
					bleed.setOperatorId(operatorId);
					String customId = req.getParameter("customId");
					Long uid =(long) Integer.parseInt(customId);
					System.out.println("获取到的用户编号为:"+uid);
					System.out.println("进入到反馈添加控制器了！！");
					conperService.addSalBleed(bleed);
					mav.setViewName("redirect:./lose.do?customId="+customId+"&userId="+operatorId);
					
					return mav;
				}	
		//ajax获取流失信息
				@RequestMapping("/selectByCustomId.do")
				@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
				public SalBleed selectByCustomId(ModelAndView mav,HttpServletRequest req) throws IllegalStateException, IOException {
					String customId = req.getParameter("customId");
					Long uid =(long) Integer.parseInt(customId);
					System.out.println("获取到的客户编号为:"+uid);
					SalBleed bleed = conperService.selectByCustomId(uid);
					
					System.out.println("查出的流失内容为"+bleed);
					return bleed;
				}
				
				
		//修改流失情况
				@RequestMapping("/updateSalBleed.do")
				public ModelAndView updateSalBleed(ModelAndView mav,SalBleed bleed){
					System.out.println("sal的数据为："+bleed);
					conperService.updateSalBleed(bleed);
					mav.setViewName("redirect:./lose.do");
					return mav;
				}
				
		//修改客户信息
		@RequestMapping("/updateSalCustom.do")
		public ModelAndView updateSalCustom(ModelAndView mav,HttpServletRequest req,Long customId) throws IllegalStateException, IOException{
			
			System.out.println("获取到的客户编号为:"+customId);
			SalCustomInfo customInfo = conperService.selectById(customId);
			customInfo.setCustomState("已经流失");
			conperService.updateSalCustomInfo(customInfo);
			mav.setViewName("redirect:./lose.do");
			return mav;
		}
		
		
		@RequestMapping("/updateCustom.do")
		public ModelAndView updateCustom(ModelAndView mav,HttpServletRequest req,Long customId) throws IllegalStateException, IOException{
			
			System.out.println("获取到的客户编号为:"+customId);
			SalCustomInfo customInfo = conperService.selectById(customId);
			customInfo.setCustomState("正在合作");
			conperService.updateSalCustomInfo(customInfo);
			mav.setViewName("redirect:./lose.do");
			return mav;
		}
			
						
}
