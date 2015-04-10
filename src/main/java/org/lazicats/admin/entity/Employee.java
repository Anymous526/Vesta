package org.lazicats.admin.entity;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer waiterId;//员工编号
	
	private String waiterName;//员工名
	private String waiterPassword;//密码
	public Integer getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}
	public String getWaiterName() {
		return waiterName;
	}
	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}
	public String getWaiterPassword() {
		return waiterPassword;
	}
	public void setWaiterPassword(String waiterPassword) {
		this.waiterPassword = waiterPassword;
	}
	@Override
	public String toString() {
		return String.format(
				"Employee [waiterId=%s, waiterName=%s, waiterPassword=%s]",
				waiterId, waiterName, waiterPassword);
	}
	
	
	

}
