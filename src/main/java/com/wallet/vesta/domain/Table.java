package com.wallet.vesta.domain;

import java.io.Serializable;

/**
 * 餐桌
 * 
 * @author Kevin Sun
 */
public class Table implements Serializable {

	private static final long serialVersionUID = -4802112426217808315L;

	private Integer id;
	private String name;
	private String location;
	private String state;
	private Order order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
