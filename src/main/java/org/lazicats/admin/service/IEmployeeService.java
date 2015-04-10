package org.lazicats.admin.service;

import java.util.List;

import org.lazicats.admin.entity.Employee;

public interface IEmployeeService {
	/**
	 * 员工登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Employee login(String username)throws Exception;
	
	/***
	 * 查询所有员工信息
	 */
	public List<Employee> findAll()throws Exception;
}
