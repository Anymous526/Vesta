package org.lazicats.admin.entity;

import java.io.Serializable;
/***
 * 员工信息表
 * @author gogole
 *
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer waiterId;//员工编号
	
	private String waiterName;//员工名
	private Integer sex;//性别 0男 1女
	private Integer age;//年龄
	private String tel;//联系电话
	private String address;//联系地址
	private int deptNo;// 部门
	private int auth;//权限
	private String waiterPassword;//密码
	private String createTime;//入职时间
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public String getWaiterPassword() {
		return waiterPassword;
	}
	public void setWaiterPassword(String waiterPassword) {
		this.waiterPassword = waiterPassword;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return String
				.format("Employee [waiterId=%s, waiterName=%s, sex=%s, age=%s, tel=%s, address=%s, deptNo=%s, auth=%s, waiterPassword=%s, createTime=%s]",
						waiterId, waiterName, sex, age, tel, address, deptNo,
						auth, waiterPassword, createTime);
	}
	
	
	
	

}
