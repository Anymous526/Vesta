package org.lazicats.website.entity;

import java.io.Serializable;
import java.util.Date;
import org.lazicats.common.basecomponent.utils.BeanUtils;
public class MyOrder extends BeanUtils implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String id;//我的订单Id
	private int orderId;//订单Id
	private String goodsIds;//商品Id
	private String goodsNames;//顾客选定商品名
	private String goodsQtys;//各选定商品数量
	private String goodsTastes;//各商品味道
	private int goodsNum;//商品数量
	private String price;//商品价格
	private double totalPrice;//总价格
	private String createDate;//订单创建时间
	
	
	
	
	
	public String getGoodsTastes() {
		return goodsTastes;
	}
	public void setGoodsTastes(String goodsTastes) {
		this.goodsTastes = goodsTastes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getGoodsIds() {
		return goodsIds;
	}
	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}
	public String getGoodsNames() {
		return goodsNames;
	}
	public void setGoodsNames(String goodsNames) {
		this.goodsNames = goodsNames;
	}
	public String getGoodsQtys() {
		return goodsQtys;
	}
	public void setGoodsQtys(String goodsQtys) {
		this.goodsQtys = goodsQtys;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return String
				.format("MyOrder [id=%s, orderId=%s, goodsIds=%s, goodsNames=%s, goodsQtys=%s, goodsNum=%s, price=%s, totalPrice=%s, createDate=%s]",
						id, orderId, goodsIds, goodsNames, goodsQtys, goodsNum,
						price, totalPrice, createDate);
	}
	
	
	

}
