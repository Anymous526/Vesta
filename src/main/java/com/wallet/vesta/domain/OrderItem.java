package com.wallet.vesta.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String orderId;
	private String memberId;
	private BigDecimal price;
	private BigDecimal number;

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}
}
