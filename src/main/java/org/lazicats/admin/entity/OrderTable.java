package org.lazicats.admin.entity;

import java.io.Serializable;
import java.util.Date;

import org.lazicats.website.entity.MyOrder;
/***
 * 后台开台记录
 * @author gogole
 *
 */

public class OrderTable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;//后台订单ID
	private String orderId;//顾客订单号
	private Integer deskNo;//桌编号
	private String tel;//顾客电话
	private Integer waiterId;//服务员ID
	private Integer clientNo;//顾客人数
	private Double payment;//定金
	private Integer phone;//是否手机订单 0否 1是
	private Integer vip;//是否vip 0否 1 是	
	private Integer checkOut;//是否结账 0代表否 1代表是
	private String remark;//后台订单备注
	private String createTime;//订单创建时间
	private Integer orderBook;//是否下单 0 否 1是 
	private MyOrder myOrder;
	
	
	public Integer getOrderBook() {
		return orderBook;
	}
	public void setOrderBook(Integer orderBook) {
		this.orderBook = orderBook;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getDeskNo() {
		return deskNo;
	}
	public void setDeskNo(Integer deskNo) {
		this.deskNo = deskNo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}
	public Integer getClientNo() {
		return clientNo;
	}
	public void setClientNo(Integer clientNo) {
		this.clientNo = clientNo;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getVip() {
		return vip;
	}
	public void setVip(Integer vip) {
		this.vip = vip;
	}
	public Integer getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Integer checkOut) {
		this.checkOut = checkOut;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public MyOrder getMyOrder() {
		return myOrder;
	}
	public void setMyOrder(MyOrder myOrder) {
		this.myOrder = myOrder;
	}
	@Override
	public String toString() {
		return String
				.format("OrderTable [id=%s, orderId=%s, deskNo=%s, tel=%s, waiterId=%s, clientNo=%s, payment=%s, phone=%s, vip=%s, checkOut=%s, remark=%s, createTime=%s, myOrder=%s]",
						id, orderId, deskNo, tel, waiterId, clientNo, payment,
						phone, vip, checkOut, remark, createTime, myOrder);
	}
	
	

	
}
