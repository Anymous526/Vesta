package com.wallet.vesta.biz;

import java.util.List;

import com.wallet.vesta.domain.Table;

public interface TableManager {

	/**
	 * 插入一个餐桌
	 * 
	 * @param table
	 */
	public void createTable(Table table);

	/**
	 * 更新一个餐桌
	 * 
	 * @param table
	 */
	public void updateTable(Table table);

	/**
	 * 删除一个餐桌
	 * 
	 * @param table
	 */
	public void deleteTable(Table table);

	/**
	 * 根据 ID查询 Table
	 * 
	 * @param id
	 * @return
	 */
	public Table findTableById(Integer id);

	/**
	 * 查询所有的Table
	 * 
	 * @return
	 */
	public List<Table> findAllTables();

}
