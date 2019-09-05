package com.sc.controller;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

import com.sc.bean.Users;
import com.sc.service.OfficeChecktargetService;
import com.sc.service.UsersService;

@Controller  //注册成bean对象
@RequestMapping("/officecc.do")  //请求映射,officecc表示officechecktargetcontroller
public class OfficeChecktargetController {
	
	@Autowired
	OfficeChecktargetService officeChecktargetService;
	
	@RequestMapping("/listofficechecktargetall.do")
	public ModelAndView list(ModelAndView mav) {
		
		mav.addObject("list",officeChecktargetService.selectOfficeChecktargetAll());
		
		mav.setViewName("fyx/officechecktargetall");//响应视图名称：路径/web-inf/
		return mav;
	}
	/*
	@RequestMapping("/listjson.do")
	@ResponseBody
	public List<Users> listjson() {
		
		return usersService.selectUsers();
	}
	
	@RequestMapping("/listpage.do")
	public ModelAndView listpage(ModelAndView mav,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="5")Integer pageSize) {
		
		mav.addObject("pi", usersService.selectUsersPage(pageNum, pageSize, null));
		
		mav.setViewName("users/listpage");//响应视图名称：路径/web-inf/
		return mav;
	}
	
	@RequestMapping("/del.do")
	public ModelAndView del(ModelAndView mav,Users u) {
		usersService.delUsers(u);
		
		mav.setViewName("redirect:listpage.do");
		return mav;
	}
	
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav,Users u) {
		mav.setViewName("users/add");
		return mav;
	}
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav,Users u,MultipartFile files,HttpServletRequest req) throws IllegalStateException, IOException {
		if(files!=null && !StringUtils.isEmpty(files.getOriginalFilename())) {//对象不为空，对象的原始的字符串不为空
			String path = req.getSession().getServletContext().getRealPath("upload");
			String oldname=files.getOriginalFilename();//原文件名称
			String extend=oldname.substring(oldname.lastIndexOf("."));
			String newname=System.currentTimeMillis()+extend;
			System.out.println("新文件名称"+newname);
			
			File f=new File(path+"/"+newname);//构建目的地文件对象
			files.transferTo(f);//拷贝文件
			
			u.setPic(newname);
		}
		usersService.addUsers(u);
		mav.setViewName("redirect:listpage.do");
		return mav;
	}
	
	@RequestMapping("/goupdate.do")
	public ModelAndView goupdate(ModelAndView mav,Users u) {
		Users user = usersService.getUserById(u.getUid());
		mav.addObject("u", user);
		mav.setViewName("users/update");
		return mav;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav,MultipartFile files,HttpServletRequest req,Users u) throws IllegalStateException, IOException {
		
		if(files!=null && !StringUtils.isEmpty(files.getOriginalFilename())) {//对象不为空，对象的原始的字符串不为空
			String path = req.getSession().getServletContext().getRealPath("upload");
			String oldname=files.getOriginalFilename();//原文件名称
			String extend=oldname.substring(oldname.lastIndexOf("."));
			String newname=System.currentTimeMillis()+extend;
			System.out.println("新文件名称"+newname);
			
			File f=new File(path+"/"+newname);//构建目的地文件对象
			files.transferTo(f);//拷贝文件
			
			u.setPic(newname);
		}
		usersService.updateUsers(u);
		
		mav.setViewName("redirect:listpage.do");
		return mav;
	}
	
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
