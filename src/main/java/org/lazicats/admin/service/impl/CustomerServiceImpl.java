package org.lazicats.admin.service.impl;

import java.util.List;

import org.lazicats.admin.dal.db.ICustomerDao;
import org.lazicats.admin.entity.Customer;
import org.lazicats.admin.service.ICustomerService;
import org.lazicats.common.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/***
 * 顾客信息实现
 * @author gogole
 *
 */
@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;
	
	/***
	 * 查询所有顾客信息
	 */
	@Override
	public List<Customer> findAll() throws Exception {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}
	
	/**
	 * 获取查询条件的后桌位信息记录数
	 */
	@Override
	public Integer countRows(Page page) throws Exception {
		// TODO Auto-generated method stub
		return customerDao.countRows(page);
	}

	
	
	/***
	 * 分页查询顾客信息
	 */
	@Override
	public List<Customer> pageCustomer(Page page) throws Exception {
		// TODO Auto-generated method stub
		return customerDao.pageCustomer(page);
	}
	
	
	
	/***
	 * 添加顾客信息
	 */
	@Override
	public void addCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);
	}
	
	
	/***
	 * 根据id查询顾客信息
	 */
	@Override
	public Customer findCustomerById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return customerDao.findCustomerById(id);
	}
	
	/***
	 * 根据id修改顾客信息
	 */
	@Override
	public void updateCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(customer);
	}
	
	/**
	 * 通过id删除顾客信息
	 */
	@Override
	public void delCustomerById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		customerDao.delCustomerById(id);
		
	}
	
	
	
}
