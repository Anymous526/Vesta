package org.lazicats.website.entity;

import java.util.List;

/**
 * 订单内容
 * 
 * @author Amos
 *
 */

public class AppOrderVO {
	private String orderNo;// 订单
	private String deskNo;// 桌号
	private String rensu;
	private String time;// 下单时间
	private String totalPrice;//总价
	private List<AppGoodVO>list;//菜品
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getDeskNo() {
		return deskNo;
	}
	public void setDeskNo(String deskNo) {
		this.deskNo = deskNo;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<AppGoodVO> getList() {
		return list;
	}
	public void setList(List<AppGoodVO> list) {
		this.list = list;
	}
	
	public String getRensu() {
		return rensu;
	}
	public void setRensu(String rensu) {
		this.rensu = rensu;
	}
	@Override
	public String toString() {
		return "AppOrderVO [orderNo=" + orderNo + ", deskNo=" + deskNo
				+ ", rensu=" + rensu + ", time=" + time + ", totalPrice="
				+ totalPrice + ", list=" + list + "]";
	}
	
	
	
}
