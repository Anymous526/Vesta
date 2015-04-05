package org.lazicats.website.service.impl;

import java.util.List;

import org.lazicats.common.vo.Page;
import org.lazicats.website.dal.db.IMyOrderDao;
import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MyOrderServiceImpl implements IMyOrderService {
	@Autowired
	private IMyOrderDao myOrderDao;
	
	
	/**
	 * 生成一个我的订单，并返回我的订单ID
	 */
	@Override
	public Integer addMyOrder(MyOrder myOrder) throws Exception {
		
		return myOrderDao.addMyOrder(myOrder);
		
	}

	/***
	 * 根据ID获取订单信息
	 */
	@Override
	public MyOrder findById(String id) throws Exception {
		return myOrderDao.findById(id);
	}
	
	/***
	 * 修改订单信息
	 */
	@Override
	public void updateMyOrder(MyOrder myOrder) throws Exception {
		
		myOrderDao.updateMyOrder(myOrder);
	}
	
	/***
	 * 查询所有订单信息
	 */
	@Override
	public List<MyOrder> findAll() throws Exception {
		
		return myOrderDao.findAll();
	}
	
	/****
	 * 根据我的订单ID删除订单信息
	 */
	@Override
	public void deleteMyOrder(String id) throws Exception {
		myOrderDao.deleteMyOrder(id);
		
	}
	
	/**
	 * 获取查询条件的后桌位信息记录数
	 */
	@Override
	public Integer countRows(Page page) throws Exception {
		// TODO Auto-generated method stub
		return myOrderDao.countRows(page);
	}
	
	/***
	 * 条件查询分页
	 */
	@Override
	public List<MyOrder> pageMyOrder(Page page) throws Exception {
		// TODO Auto-generated method stub
		return myOrderDao.pageMyOrder(page);
	}

	
	
	
	
	
	
	
	
	
}
