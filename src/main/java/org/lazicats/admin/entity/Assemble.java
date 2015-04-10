package org.lazicats.admin.entity;
/**
 * 员工页面组装 work.ftl
 * @author Amos
 *
 */
public class Assemble {

	private String name;//顾客选定商品名
	private String nameone;//各选定商品数量
	private float price;//各商品味道
	private float priceone;//商品价格
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameone() {
		return nameone;
	}
	public void setNameone(String nameone) {
		this.nameone = nameone;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPriceone() {
		return priceone;
	}
	public void setPriceone(float priceone) {
		this.priceone = priceone;
	}

	
}
