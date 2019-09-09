package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.OOfficePerSche;
import com.sc.mapper.OOfficePerScheMapper;
import com.sc.service.HR_PerAgendaService;

@Service
public class HR_PerAgendaServiceImp  implements HR_PerAgendaService{
	
	@Autowired
	OOfficePerScheMapper oofficePerScheMapper;
   
	//添加方法
	public void addSchedule(OOfficePerSche sche){
		oofficePerScheMapper.addSchedule(sche);
	}
	
	
    //通过id获取实体类对象
	public OOfficePerSche getScheduleById(String id){
		return oofficePerScheMapper.getScheduleById(id);
	}
	
	//修改方法
	public void updateSchedule(OOfficePerSche sche){
		oofficePerScheMapper.updateSchedule(sche);
	}
	
	//删除方法
	public void delSchedule(OOfficePerSche sche){
		oofficePerScheMapper.delSchedule(sche);
	}
	
	//查询方法
	public List getAllSchedule(OOfficePerSche sche){
		return oofficePerScheMapper.getAllSchedule(sche);
	}
	
}
