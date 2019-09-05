package com.sc.service;

import java.util.List;

import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;



public interface HrScheDetailService {

	//查询所有信息详情
	public List<OfficeDetailSms> selectsmsByExample(OfficeDetailSmsExample example);
}
