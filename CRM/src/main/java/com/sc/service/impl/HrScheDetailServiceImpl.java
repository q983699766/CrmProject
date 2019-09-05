package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;
import com.sc.mapper.OfficeDetailSmsMapper;
import com.sc.service.HrScheDetailService;

@Service
public class HrScheDetailServiceImpl implements HrScheDetailService {

	@Autowired 
	OfficeDetailSmsMapper officeDetailSmsMapper;
	
	@Override
	public List<OfficeDetailSms> selectsmsByExample(OfficeDetailSmsExample example) {
		
		return this.officeDetailSmsMapper.selectByExample(null);
	}


}
