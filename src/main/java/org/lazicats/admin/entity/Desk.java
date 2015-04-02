package org.lazicats.admin.entity;

import java.io.Serializable;
/***
 * 桌位信息
 * @author gogole
 *
 */
public class Desk implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;//桌的ID编号
	private Integer deskNo;//桌号
	private String deskName;//桌号名
	private Integer bookMark;//是否被订 1否 2已订 3 就餐
	private Integer type;//楼层 1大厅 2二楼
	private String description;//描述
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeskNo() {
		return deskNo;
	}
	public void setDeskNo(Integer deskNo) {
		this.deskNo = deskNo;
	}
	public String getDeskName() {
		return deskName;
	}
	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}
	public Integer getBookMark() {
		return bookMark;
	}
	public void setBookMark(Integer bookMark) {
		this.bookMark = bookMark;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return String
				.format("Desk [id=%s, deskNo=%s, deskName=%s, bookMark=%s, type=%s, description=%s]",
						id, deskNo, deskName, bookMark, type, description);
	}
	
	
}
