package com.sc.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.sc.bean.OfficeChecktarget;
import com.sc.bean.OfficeChecktask;
import com.sc.bean.OfficeGrant;
import com.sc.bean.OfficeTaskdetail;
import com.sc.bean.SysUsers;

public interface OfficeGrantService {

//	public List<OfficeGrant> selectgrantunderme(Long userId, Long comId);

	public List<OfficeChecktask> selectall(Long userId);

	public List<OfficeTaskdetail> selectthisline(Long taskId,Long taskPublisher);

	public List<OfficeTaskdetail> selectre(Long pblishid);

	public void updateisfinish(Long idd);

	public List<OfficeChecktarget> pretargetId();

	public List<SysUsers> prereceiver(Long userId);

	public void fabu(OfficeChecktask off, Long[] lreceiverIds, Long userId);

	public void del(Long taskId, Long userId,Long comId);

	
	
	
	
}
