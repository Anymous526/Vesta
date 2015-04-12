package org.lazicats.admin.service;

import java.util.List;

import org.lazicats.admin.entity.Employee;
import org.lazicats.common.vo.Page;

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
	
	
	/**
	 * 获取查询条件的后员工信息记录数
	 */
	public Integer countRows(Page page)throws Exception;
	
	/***
	 * 分页查询员工信息
	 */
	public List<Employee> pageEmployee(Page page)throws Exception;
	
	/***
	 * 添加员工信息
	 */
	public void addEmployee(Employee employee)throws Exception;
	
	/***
	 * 根据id查询员工信息
	 */
	public Employee findEmployeeById(Integer waiterId)throws Exception;
	
	/***
	 * 根据id修改顾客信息
	 */
	public void updateEmployee(Employee employee)throws Exception;
	
	
	/**
	 * 通过id删除顾客信息
	 */
	public void delEmployeeById(Integer waiterId)throws Exception;
	
}
