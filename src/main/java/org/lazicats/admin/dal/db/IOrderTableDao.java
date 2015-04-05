package org.lazicats.admin.dal.db;

import java.util.List;

import org.lazicats.admin.entity.OrderTable;
import org.lazicats.common.dbaccess.orm.mybatis.IBaseDao;

public interface IOrderTableDao extends IBaseDao<OrderTable>{
	/***
	 * 开台
	 */
	public void addorder(OrderTable order)throws Exception;
	
	
	/***
	 * 查询所有开台信息
	 */
	
	public List<OrderTable> findAll()throws Exception;
	
	/***
	 * 根据订单号查询开台信息
	 */
	public OrderTable findByOrderId(String orderId)throws Exception;
	
	public OrderTable findBydesknophone(Integer deskId)throws Exception;
	
	
	/***
	 * 根据deskId查询对应的所有订单信息
	 */
	public List<OrderTable> findByDeskId(Integer deskId)throws Exception;
	/***
	 * 根据phone,orderBook查询手机订单
	 */
	public List<OrderTable> findByphone()throws Exception;
	
	/**
	 * 根据订单号更改开台结账状态
	 * @param orderId
	 * @throws Exception
	 */
	public void updateCheckOut(String orderId)throws Exception;
	
	
	/***
	 * 打印订单后，更改下单状态
	 */
	public void updateOrderBook(String orderId)throws Exception;


	
	/**
	 * 根据订单id删除开台信息
	 */
	public void deleteOrderTable(String orderId)throws Exception;
	
}
