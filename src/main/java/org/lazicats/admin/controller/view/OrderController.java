package org.lazicats.admin.controller.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.admin.entity.OrderTable;
import org.lazicats.admin.service.IOderTableService;
import org.lazicats.admin.vo.Account;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.Page;
import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/")
public class OrderController {
	@Autowired
	private IMyOrderService myOrderService;//订单
	@Autowired
	private IOderTableService orderTableService;//开台
	
	
	/***
	 * 跳的后台订单信息维护页面
	 * @throws Exception 
	 */
	@RequestMapping(value="toOrder")
	public String omaintain(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		
		// 合并订单
	//	merge();
		// 查询所有订单信息
		List<MyOrder> myOrderList = myOrderService.findAll();

		// 查询所有开台信息
		List<OrderTable> orderTableList = orderTableService.findAll();
		// 结账
		Account account;
		List<Account> accountList1 = new ArrayList<Account>();
		for (MyOrder mo : myOrderList) {
			for (OrderTable ot : orderTableList) {
				// 判断开台后是否有订餐
				if (ot.getOrderId().equals(mo.getId())) {
					// 订单中商品Id
					String str = mo.getGoodsIds();
					if (LogicUtil.isNotNullAndEmpty(str)) {
						account = new Account();
						account.setMyOrder(mo);
						account.setOrderTable(ot);
						accountList1.add(account);
					}
				}
			}
		}

		// 获取参数第几页
		String pN = request.getParameter("pageNo");
		int pageNo = 1;
		if (LogicUtil.isNotNull(pN)) {
			int pa = Integer.parseInt(pN);
			if (pa > 0) {
				pageNo = Integer.parseInt(pN);
			}

		}
		Page page = null;
		List<Account> accountList = new ArrayList<Account>();
		// 判断accountList1是否为空
		if (accountList1.size() != 0) {
			page = new Page(accountList1.size(), pageNo);
			page.setPageSize(12);
			page.setTotalCount(accountList1.size());
			page.setStartPos((page.getPageNow() - 1) * page.getPageSize());
			Account acc;
			if (pageNo == page.getTotalPageCount()) {
				for (int i = page.getStartPos(); i < page.getTotalCount(); i++) {
					acc = new Account();
					acc = accountList1.get(i);
					accountList.add(acc);
				}
			} else {
				for (int i = page.getStartPos(); i < (page.getPageNow() * page
						.getPageSize()); i++) {
					acc = new Account();
					acc = accountList1.get(i);
					accountList.add(acc);
				}
			}
		} else {
			page = new Page(0, 1);
		}
		model.put("accountList", accountList);
		model.put("page", page);
		return "admin/sys_myOrder";
	}
	
	
}
