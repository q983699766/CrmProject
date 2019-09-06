package com.sc.service;

import java.util.List;

import com.sc.bean.OfficeChecktarget;

public interface OfficeChecktargetService {
	public List<OfficeChecktarget> selectOfficeChecktargetAll();

	public void delOfficeChecktargetById(OfficeChecktarget offchecktarget);
	
	
	
}
