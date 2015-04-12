package com.wallet.vesta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单
 * 
 * @author Kevin Sun
 *
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1938121907532962818L;
	private Integer id;
	private String state;
	private Date createTimestamp;
	private List<OrderItem> orderItems;

	public List<OrderItem> getOrderItems() {
		return orderItems == null ? new ArrayList<OrderItem>(0) : orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	private String memberId;
}
