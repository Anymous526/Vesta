package org.lazicats.admin.dal.db;

import java.util.List;

import org.lazicats.admin.entity.Employee;
import org.lazicats.common.dbaccess.orm.mybatis.IBaseDao;

public interface IEmployeeDao extends IBaseDao<Employee> {
	/**
	 * 员工登录
	 * @param emp
	 * @return
	 */
	public Employee login(String username)throws Exception;
	
	/***
	 * 查询所有员工信息
	 */
	public List<Employee> findAll()throws Exception;
}
