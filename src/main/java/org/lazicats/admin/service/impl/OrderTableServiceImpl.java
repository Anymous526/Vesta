package org.lazicats.admin.service.impl;

import java.util.List;
import org.lazicats.admin.dal.db.IOrderTableDao;
import org.lazicats.admin.entity.OrderTable;
import org.lazicats.admin.service.IOderTableService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huaxia.commons.logutil.LogProxy;
@Service("orderTableService")
public class OrderTableServiceImpl implements IOderTableService {
	@SuppressWarnings("unused")
	private final static Logger log=LogProxy.getLogger(OrderTableServiceImpl.class);
	
	@Autowired
	private IOrderTableDao orderTableDao;
	/**
	 * 开台
	 * @throws Exception 
	 */
	@Override
	public Integer insert(OrderTable table) throws Exception {
		
		orderTableDao.addorder(table);
		return table.getId();
	}
	
	
	/***
	 * 查询所有开台信息
	 */
	@Override
	public List<OrderTable> findAll() throws Exception {
		return orderTableDao.findAll();
	}

	/***
	 * 根据订单号查询开台信息
	 */
	@Override
	public OrderTable findByOrderId(String orderId) throws Exception {
		
		return orderTableDao.findByOrderId(orderId);
	}

	/***
	 * 根据桌号查询对应的所有订单
	 */
	@Override
	public List<OrderTable> findByDeskId(Integer deskId) throws Exception {
		
		return orderTableDao.findByDeskId(deskId);
	}
	
	@Override
	public List<OrderTable> findByphone() throws Exception {
		// TODO Auto-generated method stub
		return orderTableDao.findByphone();
	}

	/***
	 * 根据订单号更改开台结账状态
	 */
	@Override
	public void updateCheckOut(String orderId) throws Exception {
		orderTableDao.updateCheckOut(orderId);
		
	}
	

	/***
	 * 打印订单后，更改下单状态
	 */
	@Override
	public void updateOrderBook(String orderId) throws Exception {
		orderTableDao.updateOrderBook(orderId);
		
	}
	
	
	
	
	
	/***
	 * /**
	 * 根据订单id删除开台信息
	 */
	@Override
	public void deleteOrderTable(String orderId) throws Exception {
		orderTableDao.deleteOrderTable(orderId);
	}


	@Override
	public OrderTable findBydesknophone(Integer deskId) throws Exception {
		// TODO Auto-generated method stub
		return orderTableDao.findBydesknophone(deskId);
	}

}
