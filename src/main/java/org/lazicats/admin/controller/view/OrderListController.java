package org.lazicats.admin.controller.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.admin.entity.Desk;
import org.lazicats.admin.entity.OrderTable;
import org.lazicats.admin.print.Print;
import org.lazicats.admin.service.IDeskService;
import org.lazicats.admin.service.IOderTableService;
import org.lazicats.admin.vo.Account;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.Page;
import org.lazicats.common.vo.PrintUtil;
import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IMyOrderService;
import org.lazicats.website.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 订单列表
 * 
 * @author gogole
 *
 */
@SuppressWarnings("unused")
@Controller
@Transactional
@RequestMapping(value = "/admin/")
public class OrderListController {
	@Autowired
	private IMyOrderService myOrderService;
	@Autowired
	private IOderTableService orderTableService;

	@Autowired
	private IDeskService deskService;

	/**
	 * 订单列表
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "toorderlist")
	public String toOrderList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
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
		return "admin/orderlist";
	}

	// 取消订单，不能删除订单而是将订单中的商品信息清空
	@RequestMapping(value = "del")
	public String delOrder(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String id = request.getParameter("id");
		MyOrder myOrder = new MyOrder();
		myOrder.setGoodsIds("");
		myOrder.setGoodsNames("");
		myOrder.setGoodsNum(0);
		myOrder.setPrice("");
		myOrder.setGoodsQtys("");
		myOrder.setTotalPrice(0);
		myOrder.setId(id);
		OrderTable ot = orderTableService.findByOrderId(id);
		int deskId = ot.getDeskNo();
		Desk desk = deskService.findDeskById(deskId);
		if (desk.getBookMark() != 3) {
			myOrderService.updateMyOrder(myOrder);
		}
		toOrderList(request, response, model);
		return "admin/orderlist";
	}

	/***
	 * 根据订单id删除对应的信息
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "delOrderList")
	public String delOrderList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String id = request.getParameter("id");
		// 删除订单信息
		myOrderService.deleteMyOrder(id);
		// 删除订单id对应的开台信息
		orderTableService.deleteOrderTable(id);
		toOrderList(request, response, model);
		return "admin/orderlist";
	}

	/**
	 * 打印订单信息
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "printOrder")
	public String printOrder(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		// 获取要打印订单的id
		String id = request.getParameter("id");
		MyOrder myOrder = myOrderService.findById(id);
		// 通过订单id找到对应的开台信息
		OrderTable orderTable = orderTableService.findByOrderId(id);
		// 订单中商品Id
		String str = myOrder.getGoodsIds();
		String[] ids = str.split(",");
		// 订单中商品名称
		String str1 = myOrder.getGoodsNames();
		String[] goodsNames = str1.split(",");
		// 味道
		String taste = myOrder.getGoodsTastes();
		String[] tastes = null;
		if (taste == null) {
		} else {
			tastes = taste.split(",");
		}
		// 订单中商品价格
		String str2 = myOrder.getPrice();
		String[] prices = str2.split(",");
		// 订单中商品数量
		String str3 = myOrder.getGoodsQtys();
		String[] qtys = str3.split(",");
		// 用于存放订单中商品属性
		List<GoodsVo> goodsVoList = new ArrayList<GoodsVo>();
		GoodsVo goodsvo = null;
		for (int i = 0; i < ids.length; i++) {
			goodsvo = new GoodsVo();
			goodsvo.setId(Integer.parseInt(ids[i].trim()));
			goodsvo.setName(goodsNames[i]);
			goodsvo.setPrice(Float.parseFloat(prices[i]));
			goodsvo.setQty(Integer.parseInt(qtys[i]));
			if (taste == null) {
				goodsvo.setTaste("微辣");
			} else {
				if ("1".equals(tastes[i])) {
					goodsvo.setTaste("不辣");
				}
				if ("2".equals(tastes[i])) {
					goodsvo.setTaste("微辣");
				}
				if ("3".equals(tastes[i])) {
					goodsvo.setTaste("辣");
				}
				if ("4".equals(tastes[i])) {
					goodsvo.setTaste(" ");
				}
			}
			goodsVoList.add(goodsvo);

		}
		Account account = new Account();
		account.setMyOrder(myOrder);
		account.setOrderTable(orderTable);
		// 思路是这样 先填充数据，然后生成图片，调用打印机直接打印图片
		Print createImage = new Print();
		String fileLocation = createImage.orderPic(goodsVoList, account);
		String fileimage = createImage.createImage(fileLocation);
		PrintUtil pu = new PrintUtil();
		pu.printNoWindow(fileimage);

		// 打印后更改下单状态
		orderTableService.updateOrderBook(id);

		// 改变开台状态
		deskService.updateEate(orderTable.getDeskNo());

		toOrderList(request, response, model);
		return "admin/orderlist";
	}

	public void merge(){

		//合并同一桌订单
		 
		List<OrderTable>tableList=new ArrayList<OrderTable>();
		MyOrder myorder;
		MyOrder myorderone;
		MyOrder myordertwo;
		MyOrder myordervalue;
		//合并list
		String goodids = "";
		String goodnames="";
		String goodQtys="";
		int goodsNums=0;
		String price="";
		Double totalPrice=0.0;
		String goodsTastes="";
		OrderTable table;
		MyOrder order=new MyOrder();
		List<OrderTable>tableListone=new ArrayList<OrderTable>();
		List<MyOrder> orderListone=new ArrayList<MyOrder>();
		//2合并订单 并更新订单，删除其它订单
		try {
			tableList=orderTableService.findByphone();
	 		
			//1查询同一桌订单个数
			for (int i = 0; i < tableList.size(); i++) {
				 myorder=new MyOrder();
				 myorder=myOrderService.findById(tableList.get(i).getOrderId());
				 goodids=myorder.getGoodsIds();
				 goodnames=myorder.getGoodsNames();
				 goodQtys=myorder.getGoodsQtys();
				 goodsNums=myorder.getGoodsNum();
				 price=myorder.getPrice();
				 totalPrice=myorder.getTotalPrice();
				 goodsTastes=myorder.getGoodsTastes();
				for (int j = i+1; j < tableList.size(); j++) {
					if(tableList.get(i).getDeskNo().equals(tableList.get(j).getDeskNo())){
						myorderone=new MyOrder();
						myorderone=myOrderService.findById(tableList.get(j).getOrderId());
						
							 goodids=goodids+myorderone.getGoodsIds();
							 goodnames=goodnames+myorderone.getGoodsNames();
							 goodQtys=goodQtys+myorderone.getGoodsQtys();
							 goodsNums=goodsNums+myorderone.getGoodsNum();
							 price=price+myorderone.getPrice();
							 totalPrice=totalPrice+myorderone.getTotalPrice();
							 goodsTastes=goodsTastes+myorderone.getGoodsTastes();
						
						
						 //更新商品
						 myordervalue=new MyOrder();
						 myordervalue.setId(myorderone.getId());
						 myordervalue.setOrderId(myorderone.getOrderId());
						 myordervalue.setCreateDate(myorderone.getCreateDate());
						 myordervalue.setGoodsIds(goodids);
						 myordervalue.setGoodsNames(goodnames);
						 myordervalue.setGoodsNum(goodsNums);
						 myordervalue.setGoodsQtys(goodQtys);
						 myordervalue.setGoodsTastes(goodsTastes);
						 myordervalue.setPrice(price);
						 myordervalue.setTotalPrice(totalPrice);
						 myOrderService.updateMyOrder(myordervalue);
						 myordertwo=new MyOrder();
						 myordertwo=myOrderService.findById(myorder.getId());
						 if(myordertwo==null){
							 continue;
						 }else{
							 myOrderService.deleteMyOrder(tableList.get(i).getOrderId());
							 orderTableService.deleteOrderTable(tableList.get(i).getOrderId());
						 }
					
					}else{
						continue;
					}
				}
			}
			System.out.println("ddd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
