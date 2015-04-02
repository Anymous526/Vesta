package org.lazicats.website.service;

import java.util.List;

import org.lazicats.common.vo.Page;
import org.lazicats.website.entity.MyOrder;

public interface IMyOrderService {
	/**
	 * 生成用户订单
	 * @param myOrder
	 * @return
	 * @throws Exception
	 */
	public Integer addMyOrder(MyOrder myOrder)throws Exception;
	
	/**
	 * 根据ID获取订单信息
	 */
	 public MyOrder findById(String id) throws Exception;
	 
	 /***
	  * 开台后，订餐修改订单信息
	  */
	 public void updateMyOrder(MyOrder myOrder)throws Exception;
	 
	 
	 /***
	  * 查询所有订单信息
	  */
	public List<MyOrder> findAll()throws Exception;
	
	/***
	 * 根据ID删除我的订单信息
	 */
	public void deleteMyOrder(String id)throws Exception;
	
	
	/**
	 * 获取查询条件的后桌位信息记录数
	 */
	public Integer countRows(Page page)throws Exception;
	
	
	/***
	 * 条件查询分页
	 */
	public List<MyOrder> pageMyOrder(Page page)throws Exception;
	
	
	
}
