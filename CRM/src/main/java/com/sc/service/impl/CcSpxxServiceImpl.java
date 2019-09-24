package com.sc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.CcspxxbExample;
import com.sc.bean.PurOrderInfo;
import com.sc.bean.SalDetails;
import com.sc.bean.SalDetailsExample;
import com.sc.bean.SalOrder;
import com.sc.bean.SalOrderExample;
import com.sc.mapper.CcspxxbMapper;
import com.sc.mapper.PurOrderInfoMapper;
import com.sc.mapper.SalDetailsMapper;
import com.sc.mapper.SalOrderMapper;
import com.sc.service.CcSpxxService;
import com.sc.bean.CcspxxbExample.Criteria ;
@Service
public class CcSpxxServiceImpl implements CcSpxxService {

	@Autowired
	CcspxxbMapper ccspxxbMapper;
	@Autowired
	PurOrderInfoMapper purOrderInfoMapper;//采购mapper
	@Autowired
	SalOrderMapper salOrderMapper;//销售mapper
	@Autowired
	SalDetailsMapper salDetailsMapper;//销售详情订单mapper
	
	@Override
	public List<Ccspxxb> selectCcspxx() {
		// TODO Auto-generated method stub
		return ccspxxbMapper.selectByExample(null);
	}

	//添加
	@Override
	public void addCcspxx(Ccspxxb u) {
		
		if(u!=null){
			
			this.ccspxxbMapper.insert(u);
			
		}
		
		
		
	}

	//分页查询所有
	@Override
	public PageInfo<Ccspxxb> selectCcspxxPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
		example.setOrderByClause("PRODUCT_ID DESC");
		List<Ccspxxb> list = ccspxxbMapper.selectByExample(example);
		PageInfo<Ccspxxb> pi = new PageInfo<Ccspxxb>(list);
		return pi;
	}

	
	//删除
	@Override
	public void delCcspxx(Long productId) {
		
		this.ccspxxbMapper.deleteByPrimaryKey(productId);
	}

	//通过id查询
	@Override
	public Ccspxxb selectCcspxxByUid(Long productId) {
		return ccspxxbMapper.selectByPrimaryKey(productId);
			
	}


	//修改
	@Override
	public void updateCcspxx(Ccspxxb u,PurOrderInfo p ) {
		if(u!=null&&u.getProductId()!=null){
			this.ccspxxbMapper.updateByPrimaryKey(u);
		}
		if(p!=null){			
			PurOrderInfo key = purOrderInfoMapper.selectByPrimaryKey(p.getPurInfoNumber());
			key.setWarehouseOrnot("已入库");
			key.setRemarksInfom(p.getRemarksInfom());
			purOrderInfoMapper.updateByPrimaryKey(key);
		}
	}

	//模糊查询
	@Override
	public PageInfo<Ccspxxb> selectmh(Integer pageNum, Integer pageSize, Ccspxxb ccspxx) {
		PageHelper.startPage(pageNum,pageSize);
		CcspxxbExample example = new CcspxxbExample();
		//example.setOrderByClause("PRODUCT_ID DESC");
		if(ccspxx.getSpMc()!=null){
			Criteria criteria = example.createCriteria();
			criteria.andSpMcLike("%"+ccspxx.getSpMc()+"%");
			
		}
			
		List<Ccspxxb> list = ccspxxbMapper.selectByExample(example);
		PageInfo<Ccspxxb> pi = new PageInfo<Ccspxxb>(list);
		return pi;
	}


	@Override
	public List<Ccspxxb> selectByExamplel(Ccspxxb ccspxx) {
		// TODO Auto-generated method stub
		return ccspxxbMapper.selectByExamplel(ccspxx);
	}

	//查询销售单
	@Override
	public PageInfo<SalOrder> selectSalOrder(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		
		SalOrderExample example = new SalOrderExample();
		/*example.setOrderByClause("ORDER_ID");*/		
		List<SalOrder> list = salOrderMapper.selectByExample(example);
		PageInfo<SalOrder> pi = new PageInfo<SalOrder>(list);
		return pi;
	}
	

	//销售模糊查询
	@Override
	public PageInfo<SalOrder> xsmh(Integer pageNum, Integer pageSize, SalOrder salOrder) {
		PageHelper.startPage(pageNum,pageSize);
		SalOrderExample example = new SalOrderExample();
		
		if(salOrder.getOrderState()!=null){
		com.sc.bean.SalOrderExample.Criteria criteria =example.createCriteria();
		criteria.andOrderStateEqualTo(salOrder.getOrderState());
		
		}
		//example.setOrderByClause("PRODUCT_ID DESC");		
		List<SalOrder> list = salOrderMapper.selectByExample(example);
		PageInfo<SalOrder> pi = new PageInfo<SalOrder>(list);
		return pi;
	}
	//销售订单详情
	@Override
	public PageInfo<SalDetails> selectSalDetailsByUid(Integer pageNum, Integer pageSize,Long orderId) {
		
		SalDetailsExample example	=new SalDetailsExample();
		com.sc.bean.SalDetailsExample.Criteria criteria =example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<SalDetails> list = salDetailsMapper.selectByExample(example);
		PageInfo<SalDetails> pi = new PageInfo<SalDetails>(list);
		return pi;
	}

	//出库
	@Override
	public void updaCcspxx(Ccspxxb ccspxxb,SalOrder p) {
	
		if(ccspxxb!=null){
		ccspxxbMapper.updateByPrimaryKey(ccspxxb);
		}
		if(p!=null){
			SalOrder key = salOrderMapper.selectByPrimaryKey(p.getOrderId());
			System.out.println("7777777777"+p.getOrderId());
			key.setOrderOutState(1L);
			salOrderMapper.updateByPrimaryKey(key);
		}
		
		}
	
}