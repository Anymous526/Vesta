package org.lazicats.admin.service;

import java.util.List;

import org.lazicats.admin.entity.Customer;
import org.lazicats.common.vo.Page;

/***
 * 顾客信息接口
 * @author gogole
 *
 */
public interface ICustomerService {
	
	/***
	 * 查询所有顾客信息
	 */
	public List<Customer> findAll() throws Exception;
	
	
	/**
	 * 获取查询条件的后顾客信息记录数
	 */
	public Integer countRows(Page page)throws Exception;
	
	
	
	
	/***
	 * 分页查询顾客信息
	 */
	public List<Customer> pageCustomer(Page page)throws Exception;
	
	
	/***
	 * 添加顾客信息
	 */
	public void addCustomer(Customer customer)throws Exception;
	
	/***
	 * 根据id查询顾客信息
	 */
	public Customer findCustomerById(Integer id)throws Exception;
	
	/***
	 * 根据id修改顾客信息
	 */
	public void updateCustomer(Customer customer)throws Exception;
	
	/**
	 * 通过id删除顾客信息
	 */
	public void delCustomerById(Integer id)throws Exception;


	
	
	
}
