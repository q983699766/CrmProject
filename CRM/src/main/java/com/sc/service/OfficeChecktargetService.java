package com.sc.service;

import java.util.List;

import com.sc.bean.OfficeChecktarget;

public interface OfficeChecktargetService {
	public List<OfficeChecktarget> selectOfficeChecktargetAll(Long comId);

	public void delOfficeChecktargetById(OfficeChecktarget offchecktarget);

	public void addOfficeChecktarget(OfficeChecktarget offchecktarget);

	public OfficeChecktarget updateById(Long targetId);

	public void update(OfficeChecktarget offchecktarget);
	
	
	
}
