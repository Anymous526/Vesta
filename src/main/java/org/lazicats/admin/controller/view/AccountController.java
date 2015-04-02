package org.lazicats.admin.controller.view;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.google.gson.Gson;
/***
 * 结账页面处理
 * @author gogole
 *
 */
@Controller
@RequestMapping(value="/admin/")
@Transactional
public class AccountController {
	@Autowired
	private IMyOrderService myOrderService;
	@Autowired
	private IOderTableService orderTableService;
	
	@Autowired
	private IDeskService deskService;
	/***
	 * 转到结账页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="toaccount")
	public String toAccount(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		//查询所有订单信息
		List<MyOrder> myOrderList=myOrderService.findAll();
		//查询所有开台信息
		List<OrderTable> orderTableList=orderTableService.findAll();
		//结账
		Account account=null;
		List<Account> accountList1=new ArrayList<Account>();
		for(MyOrder mo:myOrderList){
			for(OrderTable ot:orderTableList){
				//判断开台后是否有订餐,并且没有结账
				if(ot.getOrderId().equals(mo.getId())&&ot.getCheckOut()==0){
					//订单中商品Id
					String str=mo.getGoodsIds();
					if(LogicUtil.isNotNullAndEmpty(str)){
					account=new Account();
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
			int pa=Integer.parseInt(pN);
			if(pa>0){
				pageNo=Integer.parseInt(pN);
			}
			
		}
		List<Account> accountList = new ArrayList<Account>();
		Page page=null;
		if(accountList1.size()!=0){
			 page = new Page(accountList1.size(), pageNo);
			page.setTotalCount(accountList1.size());
			page.setStartPos((page.getPageNow()-1)*page.getPageSize());
			Account acc;
			if(pageNo ==page.getTotalPageCount()){
				for (int i = page.getStartPos(); i <page.getTotalCount(); i++) {
					acc=new Account();
					acc=accountList1.get(i);
					accountList.add(acc);
				}
			}else{
				for (int i = page.getStartPos(); i <(page.getPageNow()*page.getPageSize()); i++) {
					acc=new Account();
					acc=accountList1.get(i);
					accountList.add(acc);
				}
			}		
		}else{
			page=new Page(0,1);
		}
		
		model.put("accountList", accountList);
		model.put("page", page);
		return "admin/account";
	}
	
	
	
	/***
	 * 根据订单号查询结账所需要的信息
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="account")
	public void account(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String  orderId=request.getParameter("id");
		
		//int id=Integer.parseInt(orderId);
		//根据orderId查询订单信息
		MyOrder myOrder=myOrderService.findById(orderId);
		//根据orderId查询开台信息
		OrderTable orderTable=orderTableService.findByOrderId(orderId);
		
		//订单中商品Id
		String str=myOrder.getGoodsIds();
		String[] ids=str.split(",");
		//订单中商品名称
		String str1=myOrder.getGoodsNames();
		String[] goodsNames=str1.split(",");
		//商品味道
		String taste=myOrder.getGoodsTastes();
		String[] tastes = null;
		if(taste==null){
		}else{
			tastes=taste.split(",");
		}
		//订单中商品价格
		String str2=myOrder.getPrice();
		String[] prices=str2.split(",");
		//订单中商品数量
		String str3=myOrder.getGoodsQtys();
		String[] qtys=str3.split(",");
		//用于存放订单中商品属性
		List<GoodsVo> goodsVoList=new ArrayList<GoodsVo>();
		GoodsVo goodsvo=null;
		for(int i=0;i<ids.length;i++){
			goodsvo=new GoodsVo();
			goodsvo.setId(Integer.parseInt(ids[i].trim()));
			goodsvo.setName(goodsNames[i]);
			goodsvo.setPrice(Float.parseFloat(prices[i]));
			goodsvo.setQty(Integer.parseInt(qtys[i]));
			if(taste==null){
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
		
		Gson gson=new Gson();
		String result=gson.toJson(goodsVoList);
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
		
	
	
	}	
	
	/***
	 * 对桌号对应的myorder进行结账，结账完毕后，更改桌号的状态,打印结账单
	 * @throws Exception 
	 */
	@RequestMapping(value="checkout")
	public String checkOut(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		//如果桌号对应的订单号都已结账，则更改桌号状态为正常
		//更改当前订单状态为结账
		String oid=request.getParameter("orderId");
		//int orderId=Integer.parseInt(oid);
		orderTableService.updateCheckOut(oid);
		System.out.println("orderId:"+oid);
		//(1)查询桌号的所有订单
		String di=request.getParameter("deskNo");
		Integer deskId=Integer.parseInt(di);
		
		boolean flag=true;
		List<OrderTable> ots=orderTableService.findByDeskId(deskId);
		for(OrderTable ot:ots){
			if(ot.getCheckOut()==1){
				flag=true;
			}else{
				flag=false;
				break;
			}
		}
		//当桌号对应的所有订单都已结账，更改桌位状态
		if(flag==true){
			deskService.updateRest(deskId);
		}
		
		//------------------打印结账单----------------------------------------
				MyOrder myOrder=myOrderService.findById(oid);
				//通过订单id找到对应的开台信息
				OrderTable orderTable=orderTableService.findByOrderId(oid);
				//订单中商品Id
				String str=myOrder.getGoodsIds();
				String[] ids=str.split(",");
				//订单中商品名称
				String str1=myOrder.getGoodsNames();
				String[] goodsNames=str1.split(",");
				//订单中商品价格
				String str2=myOrder.getPrice();
				String[] prices=str2.split(",");
				//订单中商品数量
				String str3=myOrder.getGoodsQtys();
				String[] qtys=str3.split(",");
				//用于存放订单中商品属性
				List<GoodsVo> goodsVoList=new ArrayList<GoodsVo>();
				GoodsVo goodsvo=null;
				for(int i=0;i<ids.length;i++){
					goodsvo=new GoodsVo();
					goodsvo.setId(Integer.parseInt(ids[i].trim()));
					goodsvo.setName(goodsNames[i]);
					goodsvo.setPrice(Float.parseFloat(prices[i]));
					goodsvo.setQty(Integer.parseInt(qtys[i]));
					goodsVoList.add(goodsvo);
					
				}
				Account account=new Account();
				account.setMyOrder(myOrder);
				account.setOrderTable(orderTable);
				// 先填充数据，然后生成图片，调用打印机直接打印图片
				Print createImage=new Print();
				String fileLocation=createImage.graphicsGeneration(goodsVoList, account);
				String fileimage= createImage.createImage(fileLocation);
				PrintUtil pu=new PrintUtil();
				pu.printNoWindow(fileimage);

		toAccount(request, response, model);
		return "admin/account";
	}
	
	
	/**
	 * 打印结账单
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="printaccount")
	public String printAccount(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception{
		String id=request.getParameter("id");
		System.out.println(id);
		//----------------------------------------------------------
		MyOrder myOrder=myOrderService.findById(id);
		//通过订单id找到对应的开台信息
		OrderTable orderTable=orderTableService.findByOrderId(id);
		//订单中商品Id
		String str=myOrder.getGoodsIds();
		String[] ids=str.split(",");
		//订单中商品名称
		String str1=myOrder.getGoodsNames();
		String[] goodsNames=str1.split(",");
		//订单中商品价格
		String str2=myOrder.getPrice();
		String[] prices=str2.split(",");
		//订单中商品数量
		String str3=myOrder.getGoodsQtys();
		String[] qtys=str3.split(",");
		//用于存放订单中商品属性
		List<GoodsVo> goodsVoList=new ArrayList<GoodsVo>();
		GoodsVo goodsvo=null;
		for(int i=0;i<ids.length;i++){
			goodsvo=new GoodsVo();
			goodsvo.setId(Integer.parseInt(ids[i].trim()));
			goodsvo.setName(goodsNames[i]);
			goodsvo.setPrice(Float.parseFloat(prices[i]));
			goodsvo.setQty(Integer.parseInt(qtys[i]));
			goodsVoList.add(goodsvo);
			
		}
		Account account=new Account();
		account.setMyOrder(myOrder);
		account.setOrderTable(orderTable);
		// 先填充数据，然后生成图片，调用打印机直接打印图片
		Print createImage=new Print();
		String fileLocation=createImage.graphicsGeneration(goodsVoList, account);
		String fileimage= createImage.createImage(fileLocation);
		PrintUtil pu=new PrintUtil();
		pu.printNoWindow(fileimage);
		toAccount(request, response, model);
		return "admin/account";
	}
	
}
