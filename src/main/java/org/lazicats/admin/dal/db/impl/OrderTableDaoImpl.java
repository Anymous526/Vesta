package org.lazicats.admin.dal.db.impl;

import java.util.List;

import org.lazicats.admin.dal.db.IOrderTableDao;
import org.lazicats.admin.entity.OrderTable;
import org.lazicats.common.basecomponent.exception.DaoException;
import org.lazicats.common.dbaccess.orm.mybatis.constants.MapperId;
import org.lazicats.common.dbaccess.orm.mybatis.constants.Message;
import org.lazicats.common.dbaccess.orm.mybatis.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class OrderTableDaoImpl extends BaseDaoImpl<OrderTable> implements IOrderTableDao {

	/**
	 * 添加开台信息
	 */
	@Override
	public void addorder(OrderTable order) {
		Assert.notNull(order);
		try {
			/*if (StringUtils.isBlank(entity.getId()))
				entity.setId(generateId());*/
			sqlSessionTemplate.insert(getSqlName(MapperId.SQL_INSERT_ORDER), order);
		} catch (Exception e) {
			throw new DaoException(String.format(Message.INSERT_FAILED, getSqlName(MapperId.SQL_INSERT)), e);
		}
	}
	
	@Override
	public List<OrderTable> findByphone() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/***
	 * 
	 */
	@Override
	public OrderTable findByOrderId(String orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/****
	 * 根据桌号查询所有对应的订单号
	 */
	
	@Override
	public List<OrderTable> findByDeskId(Integer deskId) throws Exception {
		
		return null;
	}
	
	/***
	 * 根据订单id清空
	 */
	@Override
	public void updateCheckOut(String orderId) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/***
	 * 根据订单id删除对应的开台信息
	 */
	@Override
	public void deleteOrderTable(String orderId) throws Exception {
		
		
	}

	@Override
	public void updateOrderBook(String orderId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderTable findBydesknophone(Integer deskId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
