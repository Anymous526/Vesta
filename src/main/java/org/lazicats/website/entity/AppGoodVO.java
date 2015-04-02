package org.lazicats.website.entity;


public class AppGoodVO {
	
	private String goodId;
	private String goodName;// 菜品名称
	private String goodNum;// 商品数量
	private String goodprice;// 商品价格
	private String goodTaste;//商品味道
	
	

	public String getGoodTaste() {
		return goodTaste;
	}

	public void setGoodTaste(String goodTaste) {
		this.goodTaste = goodTaste;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(String goodNum) {
		this.goodNum = goodNum;
	}

	public String getGoodprice() {
		return goodprice;
	}

	public void setGoodprice(String goodprice) {
		this.goodprice = goodprice;
	}

	@Override
	public String toString() {
		return String.format(
				"AppGoodVO [goodId=%s, goodName=%s, goodNum=%s, goodprice=%s]",
				goodId, goodName, goodNum, goodprice);
	}

	

}
