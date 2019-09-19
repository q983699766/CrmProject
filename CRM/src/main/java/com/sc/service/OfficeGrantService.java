package com.sc.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.OfficeChecktarget;
import com.sc.bean.OfficeChecktask;
import com.sc.bean.OfficeGrant;
import com.sc.bean.OfficeTaskdetail;

public interface OfficeGrantService {

//	public List<OfficeGrant> selectgrantunderme(Long userId, Long comId);

	public List<OfficeChecktask> selectall();

	public List<OfficeTaskdetail> selectthisline(Long taskId);

	public List<OfficeTaskdetail> selectre(Long pblishid);

	
	
	
	
}
