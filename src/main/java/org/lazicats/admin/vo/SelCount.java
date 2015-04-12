package org.lazicats.admin.vo;

import java.io.Serializable;

import org.lazicats.admin.entity.Desk;
import org.lazicats.admin.entity.Employee;
import org.lazicats.admin.entity.OrderTable;
import org.lazicats.website.entity.MyOrder;

/***
 * 销售额实体
 * @author gogole
 *
 */
public class SelCount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderTable orderTable;
	private MyOrder myOrder;
	private Employee employee;
	private Desk desk;
	public Desk getDesk() {
		return desk;
	}
	public void setDesk(Desk desk) {
		this.desk = desk;
	}
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return String.format(
				"SelCount [orderTable=%s, myOrder=%s, employee=%s, desk=%s]",
				orderTable, myOrder, employee, desk);
	}
	
	
}
