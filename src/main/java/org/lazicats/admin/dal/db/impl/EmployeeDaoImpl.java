package org.lazicats.admin.dal.db.impl;

import java.util.List;

import org.lazicats.admin.dal.db.IEmployeeDao;
import org.lazicats.admin.entity.Employee;
import org.lazicats.common.vo.Page;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{

	@Override
	public void create(Employee t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOfBatch(List<Employee> entities) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Employee t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOfBatch(List<Employee> entities) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer delete(Employee entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOfBatch(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(Employee t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOfBatch(List<Employee> entities) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findOneById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findList(List<Employee> entites) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findAllCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findCount(Employee query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByIdSelective(Employee entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee login(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRows(Page page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> pageEmployee(Page page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findEmployeeById(Integer waiterId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delEmployeeById(Integer waiterId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
