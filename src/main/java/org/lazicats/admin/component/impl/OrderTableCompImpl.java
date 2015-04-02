package org.lazicats.admin.component.impl;

import org.lazicats.admin.component.IOrderTableViewComp;
import org.lazicats.admin.entity.OrderTable;
import org.lazicats.admin.service.IOderTableService;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.ResultPrompt;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.commons.logutil.LogProxy;
/****
 * 开台的视图组件实现类
 * @author gogole
 *
 */
@Service
public class OrderTableCompImpl implements IOrderTableViewComp {
	
	@SuppressWarnings("unused")
	private final static Logger log=LogProxy.getLogger(OrderTableCompImpl.class);
	@Autowired
	private IOderTableService  orderTableService;
	
	@Override
	public ResultPrompt insert(OrderTable table) {
		ResultPrompt resultPrompt=new ResultPrompt();
		try {
			Integer id=orderTableService.insert(table);
			if(LogicUtil.isNotNull(id)){
				resultPrompt.setStatusCode("200");
				resultPrompt.setMessage("操作成功！");
				resultPrompt.setCallbackType("closeCurrent");
				resultPrompt.setNavTabId("admin/totable");
				return resultPrompt;
			}else{
				resultPrompt.setStatusCode("300");
				resultPrompt.setMessage("操作失败!");
				resultPrompt.setCallbackType("closeCurrent");
				resultPrompt.setNavTabId("admin/totable");
				return resultPrompt;
			}
		} catch (Exception e) {
			resultPrompt.setStatusCode("300");
			resultPrompt.setMessage("操作失败!");
			resultPrompt.setCallbackType("closeCurrent");
			resultPrompt.setNavTabId("admin/totable");
			return resultPrompt;
		}
		
	}

}
