package org.lazicats.website.entity;

import java.io.Serializable;
import java.util.Date;

public class Goods   implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	
	private int id;//商品ID
	private String name;//商品名称
	private int type;//商品类型  1 特色 2主食 3热菜  4 凉菜  5 酒水 6 饮料  7 甜点   
	private String phto;//商品图片地址
	private String introduce;//商品介绍
	private float price;//商品价格
	private  String description;//商品描述
	private  Date   create_time;//商品创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPhto() {
		return phto;
	}
	public void setPhto(String phto) {
		this.phto = phto;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return String
				.format("Goods [id=%s, name=%s, type=%s, phto=%s, introduce=%s, price=%s, description=%s, create_time=%s]",
						id, name, type, phto, introduce, price, description,
						create_time);
	}
	
		
	
	
	
	
}
