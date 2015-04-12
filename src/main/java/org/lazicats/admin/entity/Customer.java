package org.lazicats.admin.entity;

import java.io.Serializable;
import java.util.Date;

/****
 * 顾客信息
 * @author gogole
 *
 */
public class Customer implements Serializable{
	
	private int id;//顾客编号
	private String name;//顾客姓名
	private int sex;//性别：0 男 1 女
	private int age;//年龄
	private String tel;//联系电话
	private String address;//联系地址
	private String createTime;//创建时间
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return String
				.format("Customer [id=%s, name=%s, sex=%s, age=%s, tel=%s, address=%s, createTime=%s]",
						id, name, sex, age, tel, address, createTime);
	}
	
	
	
}
