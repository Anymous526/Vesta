package org.lazicats.admin.service.impl;

import java.util.List;

import org.lazicats.admin.dal.db.IEmployeeDao;
import org.lazicats.admin.entity.Employee;
import org.lazicats.admin.service.IEmployeeService;
import org.lazicats.common.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;
	/**
	 * 员工登录的实现
	 * @throws Exception 
	 */
	@Override
	public Employee login(String username) throws Exception {
		return employeeDao.login(username);
	}
	
	/***
	 * 查询所有员工信息
	 */
	@Override
	public List<Employee> findAll() throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}
	
	/**
	 * 获取查询条件的后员工信息记录数
	 */
	@Override
	public Integer countRows(Page page) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.countRows(page);
	}
	
	/***
	 * 分页查询员工信息
	 */
	@Override
	public List<Employee> pageEmployee(Page page) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.pageEmployee(page);
	}
	
	
	/**
	 * 新添加员工信息
	 */
	@Override
	public void addEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		employeeDao.addEmployee(employee);
		
	}
	
	/***
	 * 通过id 查询员工信息
	 */
	@Override
	public Employee findEmployeeById(Integer waiterId) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.findEmployeeById(waiterId);
	}
	
	/***
	 * 通过id修改员工信息
	 */
	@Override
	public void updateEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
		
	}
	/***
	 * 通过id删除员工信息
	 */
	@Override
	public void delEmployeeById(Integer waiterId) throws Exception {
		// TODO Auto-generated method stub
		employeeDao.delEmployeeById(waiterId);
		
	}

	
}
