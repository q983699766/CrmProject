package com.sc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.SysPermission;
import com.sc.bean.SysPermissionColumn;
import com.sc.bean.SysPermissionColumnExample;
import com.sc.bean.SysPermissionExample;
import com.sc.bean.SysPermissionExample.Criteria;
import com.sc.bean.SysPermissionRole;
import com.sc.bean.SysPermissionRoleExample;
import com.sc.bean.SysRole;
import com.sc.bean.SysUsers;
import com.sc.mapper.SysPermissionColumnMapper;
import com.sc.mapper.SysPermissionMapper;
import com.sc.mapper.SysPermissionRoleMapper;
import com.sc.service.PermissionService;
import com.sc.service.RolesService;
import com.sc.service.impl.PermServiceImpl;

@Controller
@RequestMapping("permisctlr")
public class PermissionController {
	
	@Autowired
	SysPermissionMapper SysPermissionMapper;
		
	@Autowired
	PermissionService PermissionService;
	
	@Autowired
	RolesService RolesService;
	
	@Autowired
	SysPermissionColumnMapper SysPermissionColumnMapper;
	
	@Autowired
	SysPermissionRoleMapper SysPermissionRoleMapper;
	
	
	@RequestMapping("/delpermcol.do")
	public ModelAndView delPermCol(ModelAndView mav , HttpSession session, 
			HttpServletRequest req, String colname){
		Integer ok = null;
		if(colname == ""){
			ok= 4;
			
		}else{
			
			SysPermissionExample sysPermissionExample = new SysPermissionExample();
			Criteria c2 = sysPermissionExample.createCriteria();
			c2.andPermissionColumnEqualTo(colname);
			
			List<SysPermission> selectByExample = SysPermissionMapper.selectByExample(sysPermissionExample);
			if(selectByExample.isEmpty()){
				ok=1;
				SysPermissionColumnExample sysPermissionColumnExample = new SysPermissionColumnExample();
				com.sc.bean.SysPermissionColumnExample.Criteria c = sysPermissionColumnExample.createCriteria();
				c.andColumnNameEqualTo(colname);
				SysPermissionColumnMapper.deleteByExample(sysPermissionColumnExample);
			}else{
				ok=5;
			}
		}
		
		mav.setViewName("redirect:../permisctlr/getPermission.do?ok="+ok);
		return mav;
	}
	
	
	@RequestMapping("/getPermByCol.do")
	public ModelAndView getPermByCol(ModelAndView mav , HttpSession session, 
			HttpServletRequest req, String columnName,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		
		if(columnName!=""){
		if(columnName.equals("all")){
			PageInfo<SysPermission> list = PermissionService.selectUsersPage(pageNum, pageSize);
			mav.addObject("list", list);
		}else{
			List<SysPermission> list = PermissionService.getPermListByCol(columnName);
			PageInfo<SysPermission> pi = new PageInfo<SysPermission>(list);
			mav.addObject("list", pi);
		}
		
		List<SysRole> list2 = RolesService.getRoleList();
		mav.addObject("roles", list2);
		List<SysPermissionColumn> list3 = PermissionService.getColumn();
		mav.addObject("col", list3);
		List<SysPermission> permList = PermissionService.getPermList();
		mav.addObject("permList", permList);
		mav.addObject("colName", columnName);
		mav.setViewName("permission/user_role");
		return mav;
		}
		PageInfo<SysPermission> list = PermissionService.selectUsersPage(pageNum, pageSize);
		mav.addObject("list", list);
		
		List<SysRole> list2 = RolesService.getRoleList();
		mav.addObject("roles", list2);
		List<SysPermissionColumn> list3 = PermissionService.getColumn();
		mav.addObject("col", list3);
		
		List<SysPermission> permList = PermissionService.getPermList();
		mav.addObject("permList", permList);
		mav.addObject("colName", columnName);
		mav.setViewName("permission/user_role");
		return mav;
	}
	
	
	@RequestMapping("/addpermcol.do")
	public ModelAndView addPermCol(ModelAndView mav , HttpSession session, HttpServletRequest req, SysPermissionColumn col){
		
		Integer ok = null;
		
		String cname = col.getColumnName();
		SysPermissionColumnExample sysPermissionExample = new SysPermissionColumnExample();
		com.sc.bean.SysPermissionColumnExample.Criteria c = sysPermissionExample.createCriteria();
		c.andColumnNameEqualTo(cname);
		
		List<SysPermissionColumn> list4 = SysPermissionColumnMapper.selectByExample(sysPermissionExample);
		
		if(list4.isEmpty()){
		
			Date date = new Date();
			col.setLastTime(date);
			
			PermissionService.addPermcol(col);
			ok=1;
		}else{
			ok=3;
		}
		
		mav.setViewName("redirect:../permisctlr/getPermission.do?ok="+ok);
		return mav;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav , HttpSession session, HttpServletRequest req, SysPermission perm, Long[] roleId, Long colId){
		
		Integer ok = null;
		String pname = perm.getPermissionName();
		SysPermissionExample sysPermExample = new SysPermissionExample();
		Criteria c = sysPermExample.createCriteria();
		c.andPermissionNameEqualTo(pname);
		
		List<SysPermission> list3 = SysPermissionMapper.selectByExample(sysPermExample);
		
		if(list3.size() == 0){
			SysUsers user = (SysUsers)session.getAttribute("nowuser");
			Long userId = user.getUserId();
			
			SysPermissionColumn col = SysPermissionColumnMapper.selectByPrimaryKey(colId);
			perm.setPermissionColumn(col.getColumnName());
			
			Date date = new Date();
			perm.setLastTime(date);
			
			PermissionService.updatePerm(perm, roleId, userId);
			ok=1;
		}else if(list3.size() ==1){
			if(list3.get(0).getPermissionId() == perm.getPermissionId()){
				SysUsers user = (SysUsers)session.getAttribute("nowuser");
				Long userId = user.getUserId();
				
				SysPermissionColumn col = SysPermissionColumnMapper.selectByPrimaryKey(colId);
				perm.setPermissionColumn(col.getColumnName());
				
				Date date = new Date();
				perm.setLastTime(date);
				
				PermissionService.updatePerm(perm, roleId, userId);
				ok=1;
			}else {
				ok=1;
			}
			
		}else {
			ok=2;
		}
		
		
		mav.setViewName("redirect:../permisctlr/getPermission.do?ok="+ok);
		return mav;
	}
	
	@RequestMapping("/addperm.do")
	public ModelAndView addperm(ModelAndView mav , HttpSession session, HttpServletRequest req, SysPermission perm, String columnName){
		
		Integer ok;
		String pname = perm.getPermissionName();
		SysPermissionExample sysPermissionExample = new SysPermissionExample();
		Criteria c = sysPermissionExample.createCriteria();
		c.andPermissionNameEqualTo(pname);
		
		List<SysPermission> selectByExample = SysPermissionMapper.selectByExample(sysPermissionExample);
		
		if(selectByExample.isEmpty()){
			Date date = new Date();
			
			perm.setLastTime(date);
			perm.setPermissionColumn(columnName);
			
			PermissionService.addPerm(perm);
			ok= 1;
		}else{
			/*mav.addObject("ok", "2");*/
			ok=2;
		}
		
		mav.setViewName("redirect:../permisctlr/getPermission.do?ok="+ok);
		return mav;
	}
	
	@RequestMapping("/selectById.do")
	@ResponseBody//比如异步获取json数据，加上@responsebody后，会直接返回json数据
	public SysPermission selectById(ModelAndView mav , HttpServletRequest req){
		String shiidstr = req.getParameter("permId");
		Long permId =(long) Integer.parseInt(shiidstr);
		
		SysPermission perm = PermissionService.selectById(permId);
		
		return perm;
	}
	
	
	@RequestMapping("/reset.do")
	public ModelAndView reset(ModelAndView mav , HttpSession session, HttpServletRequest req){
		
		PermissionService.reset();
		
		
		Integer ok = 1;
		mav.setViewName("redirect:../permisctlr/getPermission.do?ok="+ok);
		return mav;
	}
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav , HttpSession session, HttpServletRequest req, Long role, Long[] perm){
		SysUsers user = (SysUsers)session.getAttribute("nowuser");
		Long userId = user.getUserId();
		
		SysPermissionRoleExample sysPermissionRoleExample = new SysPermissionRoleExample();
		com.sc.bean.SysPermissionRoleExample.Criteria createCriteria = sysPermissionRoleExample.createCriteria();
		createCriteria.andRoleIdEqualTo(role);
		System.out.println("***********777777777"+perm[0]);
		SysPermissionRoleMapper.deleteByExample(sysPermissionRoleExample);
		
		Date date = new Date();
		for (Long l1 : perm) {
			SysPermissionRole PR = new SysPermissionRole();
			PR.setLastTime(date);
			PR.setPermissionId(l1);
			PR.setRoleId(role);
			PR.setOperatorId(userId);
			System.out.println("***********777777777"+PR);
			PermissionService.roleAddPerm(PR);
		}
		
		Long pId = (long)154;
		
		SysPermissionRole PR = new SysPermissionRole();
		PR.setLastTime(date);
		PR.setPermissionId(pId);
		PR.setRoleId(role);
		PR.setOperatorId(userId);
		PermissionService.roleAddPerm(PR);
		
		Integer ok = 1;
		mav.setViewName("redirect:../permisctlr/getPermission.do?ok="+ok);
		return mav;
	}
	
	
	@RequestMapping("/del.do")
	public ModelAndView del(ModelAndView mav , HttpServletRequest req, Long permId){
		PermissionService.delPerm(permId);
		
		
		Integer ok = 1;
		mav.setViewName("redirect:../permisctlr/getPermission.do?ok="+ok);
		return mav;
	}
	
	
		@RequestMapping("/getPermission.do")
		public ModelAndView getUserInfo(ModelAndView mav , HttpServletRequest req,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="10")Integer pageSize,Integer ok){
			
			PageInfo<SysPermission> list = PermissionService.selectUsersPage(pageNum, pageSize);
			mav.addObject("list", list);
			List<SysRole> list2 = RolesService.getRoleList();
			mav.addObject("roles", list2);
			List<SysPermissionColumn> list3 = PermissionService.getColumn();
			mav.addObject("col", list3);
			mav.addObject("ok", ok);
			
			List<SysPermission> permList = PermissionService.getPermList();
			mav.addObject("permList", permList);
			
			mav.setViewName("permission/user_role");
			return mav;
		}
	}
