package org.lazicats.admin.component;

import org.lazicats.admin.entity.OrderTable;
import org.lazicats.common.vo.ResultPrompt;

/**
 * 通过本接口刷新页面
 * @author gogole
 *
 */
public interface IOrderTableViewComp {
	/***
	 * 开台
	 */
	
	public ResultPrompt insert(OrderTable table);
	
	
}
