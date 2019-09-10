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
import com.sc.bean.SysUsers;
import com.sc.bean.Users;
import com.sc.service.OfficeChecktargetService;
import com.sc.service.UsersService;

@Controller  //注册成bean对象
@RequestMapping("/officecc.do")  //请求映射,officecc表示officechecktargetcontroller
public class OfficeChecktargetController {
	
	@Autowired
	OfficeChecktargetService officeChecktargetService;
	
	@RequestMapping("/listofficechecktargetall.do")
	public ModelAndView list(ModelAndView mav,HttpServletRequest req) {
//		SysUsers nowuser = (SysUsers)req.getSession().getAttribute("nowuser");
		mav.addObject("list",officeChecktargetService.selectOfficeChecktargetAll());
		
		mav.setViewName("fyx/officechecktargetall");//响应视图名称：路径/web-inf/
		return mav;
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
	
	@RequestMapping("/delofficechecktarget.do")
	public ModelAndView del(ModelAndView mav,OfficeChecktarget offchecktarget) {
		officeChecktargetService.delOfficeChecktargetById(offchecktarget);
		
		mav.setViewName("redirect:listofficechecktargetall.do");
		return mav;
	}
	/*
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav,Users u) {
		mav.setViewName("users/add");
		return mav;
	}
	*/
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
