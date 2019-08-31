package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.SysDuty;
import com.sc.mapper.SysDutyMapper;
import com.sc.service.SysDutyService;


@Service
public class SysDutyServiceImpl implements SysDutyService {

	@Autowired
	SysDutyMapper sysdutymapper;

	@Override
	public List<SysDuty> selectDuty() {
	
		return this.sysdutymapper.selectByExample(null);
	}
	
	
}
