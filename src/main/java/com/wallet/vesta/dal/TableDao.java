package com.wallet.vesta.dal;

import java.util.List;

import com.wallet.vesta.domain.Table;

public interface TableDao {
	/**
	 * 
	 * @param table
	 */
	public void insertTable(Table table);

	public void updateTable(Table table);

	public void deleteTable(Table table);

	public Table selectTableById(Integer id);

	public List<Table> selectAllTables();
}
