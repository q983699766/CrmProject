package com.sc.controller;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.OfficeChecktarget;
import com.sc.bean.OfficeTaskdetail;
import com.sc.bean.SysUsers;
import com.sc.bean.Users;
import com.sc.service.OfficeChecktargetService;
import com.sc.service.OfficeGrantService;
import com.sc.service.UsersService;

@Controller  //注册成bean对象
@RequestMapping("/officeg.do")  //请求映射,officeg表示officegrantcontroller,任务授权关系，可以设置最顶层上级为0的用户，
public class OfficeGrantController {
	
	@Autowired
	OfficeGrantService officeGrantService;
	
	@RequestMapping("/list.do")
	public ModelAndView list(ModelAndView mav,HttpServletRequest req,HttpServletResponse resp) {
//		SysUsers nowuser = (SysUsers)req.getSession().getAttribute("nowuser");
		
		// 查询出改用户的所有下级，在他的一个公司内进行查询，总公司的人员公司编号为空，则进行查询所有分公司的授权关系返给视图层，进行显示
//		mav.addObject("list",officeGrantService.selectgrantunderme(nowuser.getUserId(),nowuser.getComId()));//传入两个参数，我的编号作为上级编号和公司编号
		
		// 查出考核任务表所有数据
		mav.addObject("list",officeGrantService.selectall());
		mav.setViewName("fyx/officegrant");//响应视图名称：路径/web-inf/
		return mav;
	}
	
	@RequestMapping("/listthisline.do")
	@ResponseBody
	public List<OfficeTaskdetail> listthisline(HttpServletRequest req) {
		String taskIds = req.getParameter("taskId");
		Long taskId = Long.valueOf(taskIds);
		
		List<OfficeTaskdetail> selectthisline = officeGrantService.selectthisline(taskId);
		req.getSession().setAttribute("getthisline", selectthisline);
		return selectthisline;
	}
	
	@RequestMapping("/listre.do")
	@ResponseBody
	public List<OfficeTaskdetail> listre(HttpServletRequest req) {
		String Ids = req.getParameter("id");
		Long pblishid = Long.valueOf(Ids);
		
		List<OfficeTaskdetail> selectre = officeGrantService.selectre(pblishid);
		req.getSession().setAttribute("getre", selectre);
		return selectre;
	}
	
	/*
	@RequestMapping("/listjson.do")
	@ResponseBody
	public List<Users> listjson() {
		
		return usersService.selectUsers();
	}*/
	/*
	@RequestMapping("/listofficechecktargetallpage.do")
	public ModelAndView listpage(ModelAndView mav,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize) {
		
		mav.addObject("pi", officeChecktargetService.selectUsersPage(pageNum, pageSize, null));
		
		mav.setViewName("users/listpage");//响应视图名称：路径/web-inf/
		return mav;
	}
	*/
	/*
	@RequestMapping("/delofficechecktarget.do")
	public ModelAndView del(ModelAndView mav,OfficeChecktarget offchecktarget) {
		officeChecktargetService.delOfficeChecktargetById(offchecktarget);
		
		mav.setViewName("redirect:listofficechecktargetall.do");
		return mav;
	}
	
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav,Users u) {
		mav.setViewName("users/add");
		return mav;
	}
	*/
	/*
	@RequestMapping("/addofficechecktarget.do")
	public ModelAndView add(ModelAndView mav,OfficeChecktarget offchecktarget,HttpServletRequest req) {
//		System.out.println("jinrutianjiafangfa");
		SysUsers nowuser = (SysUsers)req.getSession().getAttribute("nowuser");
//		System.out.println(nowuser.toString());
//		System.out.println(offchecktarget.toString());
		if(offchecktarget!=null && offchecktarget.getCheckTarget()!=null && offchecktarget.getRemark()!=null) {
			
			offchecktarget.setComId(nowuser.getComId());
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			offchecktarget.setLastTime(new Date());
			officeChecktargetService.addOfficeChecktarget(offchecktarget);
		}
		
		mav.setViewName("redirect:listofficechecktargetall.do");
		return mav;
	}
	
	@RequestMapping("/goupdateofficechecktarget.do")
	@ResponseBody
	public OfficeChecktarget goupdate(OfficeChecktarget offchecktarget) {
		return officeChecktargetService.updateById(offchecktarget.getTargetId());
//		mav.addObject("u", user);
//		mav.setViewName("users/update");
//		return mav;
	}
	
	@RequestMapping("/updateofficechecktarget.do")
	@ResponseBody
	public void update(ModelAndView mav,HttpServletRequest req,OfficeChecktarget offchecktarget) {
		SysUsers nowuser = (SysUsers)req.getSession().getAttribute("nowuser");
		if(offchecktarget!=null && offchecktarget.getCheckTarget()!=null && offchecktarget.getRemark()!=null) {
			offchecktarget.setLastTime(new Date());
			offchecktarget.setComId(nowuser.getComId());
			officeChecktargetService.update(offchecktarget);
		}
		
//		mav.setViewName("redirect:listofficechecktargetall.do");
//		return mav;
	}
	*/
	/*
	@RequestMapping("/download.do")
	public void download(String fileName,HttpServletResponse resp,HttpServletRequest req) throws IOException {
		//设置响应头
		resp.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		
		String realPath=req.getServletContext().getRealPath("upload");
		
		InputStream is=new FileInputStream(realPath+"/"+fileName);
		
		ServletOutputStream os = resp.getOutputStream();
		
		byte[] buffer=new byte[1024*1024];
		while(is.read(buffer)!=-1) {
			os.write(buffer);
		}
		os.flush();
		os.close();
		is.close();
	}
	
	*/
}
