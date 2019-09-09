package com.sc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysEmpuser;
import com.sc.service.SysComPanyService;
import com.sc.service.SysDutyService;
import com.sc.service.SysEmpuserService;

@Controller
@RequestMapping("sysEmpuser")
public class sysEmpuserController {
	@Autowired
	SysEmpuserService sysEmpuserService;
	@Autowired
	SysComPanyService  sysComPanyService;
	@Autowired
	SysDutyService sysDutyService;
	//查询职务信息
	@RequestMapping("/list.do")
	public ModelAndView listpage(ModelAndView mav){
		//设置视图名称
		mav.addObject("Empuser", sysEmpuserService.selectSysEmpuser());
		mav.setViewName("gongsi/empuser");
		mav.addObject("com", sysComPanyService.selectComoany());
		mav.addObject("coom", sysDutyService.selectDuty());
		return mav;
	}
	@RequestMapping("/list1.do")
	public ModelAndView list1(ModelAndView mav){
		//设置视图名称
		mav.setViewName("gongsi/goadd5");
		return mav;
	}
	@RequestMapping("/delEmpuser.do")
	public ModelAndView delEmpuser(ModelAndView mav,SysEmpuser u){
		//设置视图名称
		sysEmpuserService.delSysEmpuser(u);
		mav.setViewName("redirect:list.do");
		return mav;
	}
	@RequestMapping("/selectEmpuser.do")
	public ModelAndView selectEmpuser(ModelAndView mav,Long empId){
		//设置视图名称
		mav.addObject("se", sysEmpuserService.updateSysEmpuser(empId));
		mav.addObject("m", sysComPanyService.selectComoany());
		mav.setViewName("gongsi/eui3");
		return mav;
	}
	@RequestMapping("/detail.do")
	@ResponseBody
	public SysEmpuser detail(ModelAndView mav,Long dutId) {
		System.out.println("来了11111111！"+dutId);
		return  sysEmpuserService.updateSysEmpuser(dutId);
	}
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav, MultipartFile files, HttpServletRequest req, SysEmpuser u)
			throws IllegalStateException, IOException {
		System.out.println("来了文件2！" + u);
		if (files != null && !StringUtils.isEmpty(files.getOriginalFilename())) {
			String path = req.getSession().getServletContext().getRealPath("upload");
			String oldname = files.getOriginalFilename();
			String extend = oldname.substring(oldname.lastIndexOf("."));
			String uname = System.currentTimeMillis() + extend;
			System.out.println("文件" + uname);
			File f = new File(path + "/" + uname);
			files.transferTo(f);
			u.setEmpPrice(uname);
		}
		Date date = new Date();
		u.setLastTime(date);
		sysEmpuserService.update(u);// 视图名称，路径是是：/web-inf/test.jsp
		mav.setViewName("redirect:list.do");
		return mav;
	}

	@RequestMapping("/add.do")
	public ModelAndView upload(ModelAndView mav, MultipartFile files, HttpServletRequest req, SysEmpuser u)
			throws IllegalStateException, IOException {
		System.out.println("来了文件！" + u);
		if (files != null && !StringUtils.isEmpty(files.getOriginalFilename())) {
			String path = req.getSession().getServletContext().getRealPath("upload");
			String oldname = files.getOriginalFilename();
			String extend = oldname.substring(oldname.lastIndexOf("."));
			String uname = System.currentTimeMillis() + extend;
			System.out.println("文件" + uname);
			File f = new File(path + "/" + uname);
			files.transferTo(f);
			u.setEmpPrice(uname);
		}
		Date date = new Date();
		u.setLastTime(date);
		sysEmpuserService.addSysEmpuser(u);// 视图名称，路径是是：/web-inf/test.jsp
		mav.setViewName("redirect:list.do");
		return mav;
	}

	// 下载
	@RequestMapping("/xz.do")
	public ResponseEntity<byte[]> download(HttpServletRequest req,String empPrice) throws IOException {
		String path = req.getServletContext().getRealPath("/upload/");
		System.out.println("路径：" + path);
		File file = new File(path + File.separator + empPrice);
		HttpHeaders headers = new HttpHeaders();
		String down = new String(empPrice.getBytes("utf-8"), "iso-8859-1");
		headers.setContentDispositionFormData("attachment", down);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

	}
	
}
