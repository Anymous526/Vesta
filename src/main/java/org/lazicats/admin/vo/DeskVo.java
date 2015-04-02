package org.lazicats.admin.vo;

import java.io.Serializable;
/**
 * 对桌位信息包装 开台属性 分页需要的属性
 * @author gogole
 *
 */
public class DeskVo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;//桌的ID编号
	private Integer deskNo;//桌号
	private String deskName;//桌号名
	private Integer bookMark;//是否被订 0否 1已订
	private Integer type;//楼层 0大厅1 一楼 2二楼
	private String description;//描述
	private int pageNo=1;
	private int pageSize=21;
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
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return String
				.format("DeskVo [id=%s, deskNo=%s, deskName=%s, bookMark=%s, type=%s, description=%s, pageNo=%s, pageSize=%s]",
						id, deskNo, deskName, bookMark, type, description,
						pageNo, pageSize);
	}
	
	
	

}
