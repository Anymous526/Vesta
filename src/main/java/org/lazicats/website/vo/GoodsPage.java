package org.lazicats.website.vo;

import java.io.Serializable;
import java.util.Date;

import org.lazicats.common.vo.Page;

public class GoodsPage extends Page implements Serializable{

	public GoodsPage(int totalCount, int pageNow) {
		super(totalCount, pageNow);
	}
	private static final long serialVersionUID = 1L;
	/**
	public GoodsPage(int totalCount, int pageNow,int type) {
		this.totalCount=totalCount;
		this.pageNow=pageNow;
		this.type=type;
		
	}
	*/
	private int totalCount; // 总的记录条数
	private int pageNow = 1; // 当前页数
	private int id;//商品ID
	private String name;//商品名称
	private int type;//商品类型  1 特色 2主食 3热菜  4 凉菜  5 酒水 6 饮料  7 甜点   
	private String phto;//商品图片地址
	private String introduce;//商品介绍
	private float price;//商品价格
	private  String description;//商品描述
	private  Date   create_time;//商品创建时间
	
	
	private int startPos; // 开始位置，从0开始
	private int pageSize=21;

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
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartPos() {
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	
	
	
	
	
	

}
