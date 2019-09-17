package com.sc.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

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

import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.bean.SysUsersExample;
import com.sc.bean.SysUsersExample.Criteria;
import com.sc.bean.SysUsersRole;
import com.sc.bean.SysUsersRoleExample;
import com.sc.mapper.SysUsersMapper;
import com.sc.mapper.SysUsersRoleMapper;
import com.sc.service.RolesService;
import com.sc.service.UsersService;

@Controller
@RequestMapping("usersctlr")
public class UsersController {
	
	@Autowired
	UsersService UsersService;
	
	@Autowired
	SysUsersMapper SysUsersMapper;
	
	@Autowired
	RolesService RolesService;
	
	@Autowired
	SysUsersRoleMapper SysUsersRoleMapper;
	
	@RequestMapping("/update.do")
	public ModelAndView update111(ModelAndView mav, HttpSession session , HttpServletRequest req, SysUsers user, Long[] roleId){
		
		/*String uname = user.getUserName();
		SysUsersExample sysUsersExample = new SysUsersExample();
		Criteria c = sysUsersExample.createCriteria();
		c.andUserNameEqualTo(uname);
		
		List<SysUsers> list3 = SysUsersMapper.selectByExample(sysUsersExample);
		
		if(list3.size() == 0){
			Date date = new Date();
			user.setLastTime(date);
			
			SysUsers u = (SysUsers)session.getAttribute("nowuser");
			
			Long uid = u.getUserId();
			
			UsersService.updateUserRole(user, roleId, uid);
			mav.addObject("ok", "1");
		}else if(list3.size() ==1){
			if(list3.get(0).getUserId() == user.getUserId()){
				Date date = new Date();
				user.setLastTime(date);
				
				SysUsers u = (SysUsers)session.getAttribute("nowuser");
				
				Long uid = u.getUserId();
				
				UsersService.updateUserRole(user, roleId, uid);
				mav.addObject("ok", "1");
			}
			mav.addObject("ok", "2");
			
		}else {
			mav.addObject("ok", "2");
		}*/
		
		SysUsers u = (SysUsers)session.getAttribute("nowuser");
		
		Long uid = u.getUserId();
		
		SysUsersRoleExample sysUsersRoleExample = new SysUsersRoleExample();
		com.sc.bean.SysUsersRoleExample.Criteria c = sysUsersRoleExample.createCriteria();
		c.andUserIdEqualTo(uid);
		List<SysUsersRole> list = SysUsersRoleMapper.selectByExample(sysUsersRoleExample);
		
		
		if(list.isEmpty()){
			for (Long long1 : roleId) {
				if(long1 == 1){
					Integer ok=3;
					mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
					return mav;
					}
				}
		}else{
			for (SysUsersRole sysUsersRole : list) {
				if(sysUsersRole.getRoleId() == 1){
					Date date = new Date();
					user.setLastTime(date);
					
					UsersService.updateUserRole(user, roleId, uid);
					Integer ok=1;
					
					mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
					return mav;
				}
			}
			for (Long long1 : roleId) {
				if(long1 == 1){
					Integer ok=3;
					mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
					return mav;
					}
				}
			
		}
		Date date = new Date();
		user.setLastTime(date);
		
		UsersService.updateUserRole(user, roleId, uid);
		Integer ok=1;
		
		mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
		return mav;
	
		
	}
	
	@RequestMapping("/selectById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public SysUsers selectById(ModelAndView mav , HttpServletRequest req){
		String shiidstr = req.getParameter("userId");
		Long userId =(long) Integer.parseInt(shiidstr);
		System.out.println("获取到的用户编号为:"+userId);
		SysUsers user = UsersService.selectById(userId);
		System.out.println("************"+user.getRoles());
		return user;
	}
	
	
	@RequestMapping("/add.do")
	public ModelAndView update(ModelAndView mav , HttpSession session, HttpServletRequest req, SysUsers user, Long[] roleId){
		SysUsers us = (SysUsers)session.getAttribute("nowuser");
		Long uid = us.getUserId();
		Date date = new Date();
		user.setLastTime(date);
		
		SysUsersRoleExample sysUsersRoleExample = new SysUsersRoleExample();
		com.sc.bean.SysUsersRoleExample.Criteria c1 = sysUsersRoleExample.createCriteria();
		c1.andUserIdEqualTo(uid);
		List<SysUsersRole> list = SysUsersRoleMapper.selectByExample(sysUsersRoleExample);
		
		for (SysUsersRole sysUsersRole : list) {
			if(sysUsersRole.getRoleId()==1){
				String uname = user.getUserName();
				SysUsersExample sysUsersExample = new SysUsersExample();
				Criteria c = sysUsersExample.createCriteria();
				c.andUserNameEqualTo(uname);
				
				List<SysUsers> list3 = SysUsersMapper.selectByExample(sysUsersExample);
				
				if(list3.isEmpty()){
				UsersService.addUser(user);
				
				String userName = user.getUserName();
				
				SysUsers u = UsersService.selectByName(userName);
				Long userId = u.getUserId();
				for (Long rId : roleId) {
					
				SysUsersRole sysUsersRole1 = new SysUsersRole();
				sysUsersRole1.setLastTime(date);
				sysUsersRole1.setOperatorId(uid);
				sysUsersRole1.setRoleId(rId);
				sysUsersRole1.setUserId(userId);
				
				SysUsersRoleMapper.insert(sysUsersRole1);
				}
					Integer ok=1;
					mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
					return mav;
				}else{
					Integer ok=2;
					mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
					return mav;
				}
			}
		}
		for (Long l : roleId) {
			if(l==1){
				Integer ok=3;
				mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
				return mav;
			}
		}
		
		String uname = user.getUserName();
		SysUsersExample sysUsersExample = new SysUsersExample();
		Criteria c = sysUsersExample.createCriteria();
		c.andUserNameEqualTo(uname);
		
		List<SysUsers> list3 = SysUsersMapper.selectByExample(sysUsersExample);
		
		if(list3.isEmpty()){
		UsersService.addUser(user);
		
		String userName = user.getUserName();
		
		SysUsers u = UsersService.selectByName(userName);
		Long userId = u.getUserId();
		for (Long rId : roleId) {
			
		SysUsersRole sysUsersRole = new SysUsersRole();
		sysUsersRole.setLastTime(date);
		sysUsersRole.setOperatorId(uid);
		sysUsersRole.setRoleId(rId);
		sysUsersRole.setUserId(userId);
		
		SysUsersRoleMapper.insert(sysUsersRole);
		}
			Integer ok=1;
			mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
			return mav;
		}else{
			Integer ok=2;
			mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
			return mav;
		}
	}
	
	
	@RequestMapping("/del.do")
	public ModelAndView delById(ModelAndView mav , HttpServletRequest req, Long userId,HttpSession session){
		
		SysUsers u = (SysUsers)session.getAttribute("nowuser");		
		Long uid = u.getUserId();
		
		SysUsersRoleExample sysUsersRoleExample = new SysUsersRoleExample();
		com.sc.bean.SysUsersRoleExample.Criteria c = sysUsersRoleExample.createCriteria();
		c.andUserIdEqualTo(uid);
		List<SysUsersRole> list = SysUsersRoleMapper.selectByExample(sysUsersRoleExample);
		
		SysUsersRoleExample sysUsersRoleExample2 = new SysUsersRoleExample();
		com.sc.bean.SysUsersRoleExample.Criteria createCriteria = sysUsersRoleExample2.createCriteria();
		createCriteria.andUserIdEqualTo(userId);
		List<SysUsersRole> selectByExample = SysUsersRoleMapper.selectByExample(sysUsersRoleExample2);
		
		for (SysUsersRole sysUsersRole : list) {
			if(sysUsersRole.getRoleId() == 1){
				UsersService.delUser(userId);
				
				Integer ok = 1;
				mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
				return mav;
			}
		}
		for (SysUsersRole sysUsersRole : selectByExample) {
			if(sysUsersRole.getRoleId() == 1){
				Integer ok=3;
				mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
				return mav;
			}
		}
		
		UsersService.delUser(userId);
		
		Integer ok = 1;
		mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
		return mav;
	}
	
	
	@RequestMapping("/updatesta.do")
	public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req, Long userId ,HttpSession session){
		
		SysUsers u = (SysUsers)session.getAttribute("nowuser");		
		Long uid = u.getUserId();
		
		SysUsersRoleExample sysUsersRoleExample = new SysUsersRoleExample();
		com.sc.bean.SysUsersRoleExample.Criteria c = sysUsersRoleExample.createCriteria();
		c.andUserIdEqualTo(uid);
		List<SysUsersRole> list = SysUsersRoleMapper.selectByExample(sysUsersRoleExample);
		
		SysUsersRoleExample sysUsersRoleExample2 = new SysUsersRoleExample();
		com.sc.bean.SysUsersRoleExample.Criteria createCriteria = sysUsersRoleExample2.createCriteria();
		createCriteria.andUserIdEqualTo(userId);
		List<SysUsersRole> selectByExample = SysUsersRoleMapper.selectByExample(sysUsersRoleExample2);
		
		for (SysUsersRole sysUsersRole : list) {
			if(sysUsersRole.getRoleId() == 1){
				SysUsers user = UsersService.selectById(userId);
				String userState = user.getUserState();		
				if(userState.equals("0")){
					user.setUserState("1");
					Date date = new Date();
					user.setLastTime(date);
					UsersService.updateUser(user);			
				}else{
					user.setUserState("0");
					Date date = new Date();
					user.setLastTime(date);
					UsersService.updateUser(user);
				}		
				Integer ok = 1;
				mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
				return mav;
			}
		}
		for (SysUsersRole sysUsersRole : selectByExample) {
			if(sysUsersRole.getRoleId() == 1){
				Integer ok=3;
				mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
				return mav;
			}
		}
		
		SysUsers user = UsersService.selectById(userId);
		String userState = user.getUserState();		
		if(userState.equals("0")){
			user.setUserState("1");
			Date date = new Date();
			user.setLastTime(date);
			UsersService.updateUser(user);			
		}else{
			user.setUserState("0");
			Date date = new Date();
			user.setLastTime(date);
			UsersService.updateUser(user);
		}		
		Integer ok = 1;
		mav.setViewName("redirect:../usersctlr/getlist1.do?ok="+ok);
		return mav;
	}
	
	
	@RequestMapping("/getlist1.do")
	public ModelAndView updateUserSta(ModelAndView mav , HttpServletRequest req
			, HttpSession session,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,Integer ok){
		
		
		
		List<SysRole> list2 = RolesService.getRoleList();
		
		mav.addObject("users", UsersService.selectUsersPage(pageNum, pageSize));
		mav.addObject("roles", list2);
		mav.addObject("ok", ok);
		mav.setViewName("permission/users");
		return mav;
	
	}
}
