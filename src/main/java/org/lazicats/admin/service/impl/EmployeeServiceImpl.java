package org.lazicats.admin.service.impl;

import java.util.List;

import org.lazicats.admin.dal.db.IEmployeeDao;
import org.lazicats.admin.entity.Employee;
import org.lazicats.admin.service.IEmployeeService;
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

	
}
