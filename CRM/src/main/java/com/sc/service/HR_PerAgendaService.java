package com.sc.service;

import java.util.List;

import com.sc.bean.OOfficePerSche;



//bean的名字是usersDao
public interface HR_PerAgendaService {
	//添加方法
	public void addSchedule(OOfficePerSche sche);
	
    //通过id获取实体类对象
	public OOfficePerSche getScheduleById(String id);
	
	//修改方法
	public void updateSchedule(OOfficePerSche sche);
	
	//删除方法
	public void delSchedule(OOfficePerSche sche);
	
	//查询方法
	public List getAllSchedule(OOfficePerSche sche);

	
}
