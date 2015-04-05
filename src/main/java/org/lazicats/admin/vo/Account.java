package org.lazicats.admin.vo;

import java.io.Serializable;

import org.lazicats.admin.entity.OrderTable;
import org.lazicats.website.entity.MyOrder;
/***
 * 用于结账，结合所有开台信息，订单信息
 * @author gogole
 *
 */
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private OrderTable orderTable;
	private MyOrder myOrder;
	public OrderTable getOrderTable() {
		return orderTable;
	}
	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}
	public MyOrder getMyOrder() {
		return myOrder;
	}
	public void setMyOrder(MyOrder myOrder) {
		this.myOrder = myOrder;
	}
	
}
