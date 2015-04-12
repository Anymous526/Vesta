package com.wallet.vesta.dal.mybatis;

import java.util.List;

import com.wallet.vesta.dal.BaseDao;
import com.wallet.vesta.dal.TableDao;
import com.wallet.vesta.domain.Table;

/**
 * 
 * @author Kevin Sun
 *
 */
public class MyBatisTableDao extends BaseDao implements TableDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9175745134283752909L;

	@Override
	public void insertTable(Table table) {

	}

	@Override
	public void updateTable(Table table) {

	}

	@Override
	public void deleteTable(Table table) {

	}

	@Override
	public Table selectTableById(Integer id) {
		return this.getSqlSession().selectOne("");
	}

	@Override
	public List<Table> selectAllTables() {
		return this.getSqlSession().selectList("");
	}

}
