package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.OrderGoodsMessageBean;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SalDetails;
import com.sc.bean.SalDetailsExample;
import com.sc.bean.SalGoodsDetailsPageBean;
import com.sc.bean.SalOrder;
import com.sc.bean.SalOrderExample;
import com.sc.bean.SalOrderExample.Criteria;
import com.sc.mapper.CcspxxbMapper;
import com.sc.mapper.SalCustomInfoMapper;
import com.sc.mapper.SalDetailsMapper;
import com.sc.mapper.SalOrderMapper;
import com.sc.mapper.SysCOMPANYMapper;
import com.sc.mapper.SysUsersMapper;
import com.sc.service.SalMessageService;

@Service
public class SalMessageServiceImpl<E> implements SalMessageService {
	
	@Autowired
	SalOrderMapper som;
	
	@Autowired
	SysUsersMapper sum;
	
	@Autowired
	SalCustomInfoMapper scim;
	
	@Autowired
	SysCOMPANYMapper scm;
	
	@Autowired
	CcspxxbMapper cm;
	
	@Autowired
	SalDetailsMapper sdm;
	
	@Autowired
	SalCustomInfoMapper sci;
	
	@Override
	public float totalMoney() {
		return som.totalMoney();
	}

	@Override
	public int orderCount() {
		return som.orderCount();
	}

	@Override
	public int successOrderCount() {
		return som.successOrderCount();
	}

	@Override
	public int failOrderCount() {
		return som.failOrderCount();
	}

	@Override
	public float totalRebate() {
		return som.totalRebate();
	}

	@Override
	public int[] orderCountGroupByMonth() {
		int orderCount[] = new int[12];
		for(int i = 1;i <= 12;i++){
			orderCount[i-1] = som.orderCountGroupByMonth(i);
		}
		return orderCount;
	}

	@Override
	public int[] waitPayOrderCountGroupByMonth() {
		int waitPayOrderCount[] = new int[12];
		for(int i = 1;i <= 12;i++){
			waitPayOrderCount[i-1] = som.waitPayOrderCountGroupByMonth(i);
		}
		return waitPayOrderCount;
	}

	@Override
	public int[] havePayOrderCountGroupByMonth() {
		int havePayOrderCount[] = new int[12];
		for(int i = 1;i <= 12;i++){
			havePayOrderCount[i-1] = som.havePayOrderCountGroupByMonth(i);
		}
		return havePayOrderCount;
	}

	@Override
	public int[] waitPutOrderCountGroupByMonth() {
		int waitPutOrderCount[] = new int[12];
		for(int i = 1;i <= 12;i++){
			waitPutOrderCount[i-1] = som.waitPutOrderCountGroupByMonth(i);
		}
		return waitPutOrderCount;
	}


	@Override
	public PageInfo<SalOrder> selectSalOrder(Integer pageNum, Integer pageSize) {
		String orderBy = "LAST_TIME DESC";
		PageHelper.startPage(pageNum, pageSize,orderBy);
		//PageHelper.startPage(pageNum, pageSize);
		List<SalOrder> selectByExample = som.selectByExample(null);
		PageInfo<SalOrder> pageInfo = new PageInfo<SalOrder>(selectByExample);
		List<SalOrder> list = pageInfo.getList();
		for (SalOrder salOrder : list) {
			salOrder.setUser(sum.selectByPrimaryKey(salOrder.getUserId()));
			salOrder.setCustom(scim.selectByPrimaryKey(salOrder.getCustomId()));
			salOrder.setCompany(scm.selectByPrimaryKey(salOrder.getComId()));;
		}
		pageInfo.setList(list);
		return pageInfo;
	}

	@Override
	public PageInfo<SalOrder> selectSalOrderLike(Integer pageNum, Integer pageSize, String type, String message) {
		//String orderBy = "LAST_TIME DESC";
		//PageHelper.startPage(pageNum, pageSize, orderBy);
		PageHelper.startPage(pageNum, pageSize);
		List<SalOrder> SalOrderList = null;
		if("0".equals(type)){
			SalOrderExample salOrderExample = new SalOrderExample();
			Criteria qbc = salOrderExample.createCriteria();
			qbc.andInvoiceNumberEqualTo(message);
			SalOrderList = som.selectByExample(salOrderExample);
		}else{
			SalOrderList = som.selectByLike(message);
		}
		
		PageInfo<SalOrder> pageInfo = new PageInfo<SalOrder>(SalOrderList);
		List<SalOrder> list = pageInfo.getList();
		for (SalOrder salOrder : list) {
			salOrder.setUser(sum.selectByPrimaryKey(salOrder.getUserId()));
			salOrder.setCustom(scim.selectByPrimaryKey(salOrder.getCustomId()));
			salOrder.setCompany(scm.selectByPrimaryKey(salOrder.getComId()));;
		}
		pageInfo.setList(list);
		return pageInfo;
	}
	
	@Override
	public void delSalOrderBykey(Long orderid) {
		som.deleteByPrimaryKey(orderid);
	}

	@Override
	public void sendSalOrderBykey(Long orderid) {
		SalOrder record = som.selectByPrimaryKey(orderid);
		record.setOrderState(4l);
		som.updateByPrimaryKey(record);
	}

	

	@Override
	public String[] selectSPLB() {
		return som.selectSPLB();
	}

	@Override
	public List<Ccspxxb> selectSPXX(String type, String message) {
		return som.selectSPXX(type,message);
	}

	@Override
	public Ccspxxb selectSPXXBykey(Long id) {
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public List<SalCustomInfo> selectCustom() {
		return sci.selectByExample(null);
	}

	@Override
	public SalOrder salCreateOrder(OrderGoodsMessageBean goods,Long userid) {
		Date date = new Date();
		String invoiceNumber = String.valueOf(System.currentTimeMillis());
		SalCustomInfo selectByPrimaryKey = sci.selectByPrimaryKey(goods.getCustomId());
		Long comId = selectByPrimaryKey.getComId();
		String remark = goods.getRemark();
		SalOrder salOrder = new SalOrder(null, date, invoiceNumber, userid, goods.getCustomId(), goods.getTotalM(), 0l, 0l, 0l,remark,comId,date);
		//插入订单信息
		som.insert(salOrder);
		//查出新订单信息
		SalOrderExample salOrderExample = new SalOrderExample();
		Criteria qbc = salOrderExample.createCriteria();
		qbc.andInvoiceNumberEqualTo(invoiceNumber);
		List<SalOrder> selectByExample = som.selectByExample(salOrderExample);
		SalOrder order = selectByExample.get(0);
		//插入商品信息
		 SalGoodsDetailsPageBean[] list = goods.getList();
		 for (SalGoodsDetailsPageBean sgp : list) {
			 SalDetails salDetails = new SalDetails(null, order.getOrderId(), sgp.getId(),sgp.getNum(), sgp.getMoney(), remark, comId, date);
			 sdm.insert(salDetails);
		}
		//查询出新添加的商品信息
		SalDetailsExample salDetailsExample = new SalDetailsExample();
		com.sc.bean.SalDetailsExample.Criteria createCriteria = salDetailsExample.createCriteria();
		createCriteria.andOrderIdEqualTo(order.getOrderId());
		List<SalDetails> salDetails = sdm.selectByExample(salDetailsExample);
		for (SalDetails salDetails2 : salDetails) {
			salDetails2.setProduct(cm.selectByPrimaryKey(salDetails2.getProductId()));
		}
		//完善订单信息
		order.setSalDetailsList(salDetails);
		order.setUser(sum.selectByPrimaryKey(order.getUserId()));
		order.setCustom(scim.selectByPrimaryKey(order.getCustomId()));
		order.setCompany(scm.selectByPrimaryKey(order.getComId()));
		return order;
	}

	@Override
	public SalOrder selsalOrder(Long orderid) {
		//查询订单基本信息
		SalOrder order = som.selectByPrimaryKey(orderid);
		//查询出订单下的商品信息
		SalDetailsExample salDetailsExample = new SalDetailsExample();
		com.sc.bean.SalDetailsExample.Criteria createCriteria = salDetailsExample.createCriteria();
		createCriteria.andOrderIdEqualTo(orderid);
		List<SalDetails> salDetails = sdm.selectByExample(salDetailsExample);
		for (SalDetails salDetails2 : salDetails) {
			salDetails2.setProduct(cm.selectByPrimaryKey(salDetails2.getProductId()));
		}
		//完善订单信息
		order.setSalDetailsList(salDetails);
		order.setUser(sum.selectByPrimaryKey(order.getUserId()));
		order.setCustom(scim.selectByPrimaryKey(order.getCustomId()));
		order.setCompany(scm.selectByPrimaryKey(order.getComId()));
		return order;
	}

	@Override
	public SalOrder salOrderUpdate(OrderGoodsMessageBean goods) {
		Date date = new Date();
		//更新订单总金额
		SalOrder selectByPrimaryKey = som.selectByPrimaryKey(goods.getOrderId());
		selectByPrimaryKey.setSalMoney(goods.getTotalM());
		som.updateByPrimaryKey(selectByPrimaryKey);
		//更新商品信息
		SalDetailsExample salDetailsExample = new SalDetailsExample();
		com.sc.bean.SalDetailsExample.Criteria qbc = salDetailsExample.createCriteria();
		qbc.andOrderIdEqualTo(goods.getOrderId());
		sdm.deleteByExample(salDetailsExample);
		SalGoodsDetailsPageBean[] list = goods.getList();
		for (SalGoodsDetailsPageBean sgp : list) {
			SalDetails salDetails = new SalDetails(null, goods.getOrderId(), sgp.getId(), sgp.getNum(), sgp.getMoney(),selectByPrimaryKey.getRemark() , selectByPrimaryKey.getComId(),date);
			sdm.insert(salDetails);
		}
		//返回订单信息
		return selsalOrder(goods.getOrderId());
	}

	@Override
	public void delSalOrders(Long[] orderid) {
		for (Long long1 : orderid) {
			delSalOrderBykey(long1);
		}
	}

}
