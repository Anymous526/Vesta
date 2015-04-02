package org.lazicats.website.controller.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.lazicats.admin.entity.OrderTable;
import org.lazicats.admin.service.IDeskService;
import org.lazicats.admin.service.IOderTableService;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.website.entity.AppConstant;
import org.lazicats.website.entity.AppGoodVO;
import org.lazicats.website.entity.AppOrderVO;
import org.lazicats.website.entity.Goods;
import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IGoodsService;
import org.lazicats.website.service.IMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/wap")
public class AppController {
	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IMyOrderService myOrderService;

	@Autowired
	private IOderTableService orderTableService;

	@Autowired
	private IDeskService deskServie;

	/**
	 * 登录index
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/page")
	public String page(HttpServletRequest request, ModelMap model)
			throws Exception {
		List<Goods> goods = goodsService.findList();
		List<Goods> drinksList = new ArrayList<Goods>();
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Goods> sucaiList = new ArrayList<Goods>();
		for (Goods gd : goods) {
			if (gd.getType() == 5) {
				drinksList.add(gd);
			} else if(gd.getType()==1) {
				goodsList.add(gd);
			}else if(gd.getType()==2){
				goodsList.add(gd);
			}else{
				sucaiList.add(gd);
			}
			
		}
		model.put("drinksListlength", drinksList.size());
		model.put("goodsListlength", goodsList.size());
		model.put("sucaiListlength", sucaiList.size());
		model.put("sucaiList", sucaiList);
		model.put("drinksList", drinksList);
		model.put("goodsList", goodsList);
		return "wap/index";

	}

	@RequestMapping("/web")
	public String web(HttpServletRequest request, ModelMap model)
			throws Exception {
		/*
		 * TestComet come=new TestComet(); ServletContextEvent ss =null;
		 * come.contextInitialized(ss);
		 */
		return "wap/webs";

	}

	/**
	 * 点餐 订单
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unused")
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public String orderList(HttpServletRequest request, ModelMap model)
			throws Exception {
		AppOrderVO orderVO = new AppOrderVO();
		AppGoodVO goodVO;
		ArrayList<AppGoodVO> goodVOlist = new ArrayList<AppGoodVO>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfor = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderNo = sdfor.format(new Date()) + request.getParameter(AppConstant.DESKNO);
		String addrensu = request.getParameter(AppConstant.ADDRENSU);
		String time = sdf.format(new Date());
		JSONObject json = JSONObject.fromObject(request.getParameterMap());
		JSONArray arry = JSONArray.fromObject(json.get(AppConstant.ROWS));
		String ar = new String();
		ar = arry.getString(0);
		String[] avalue = new String[50];
		avalue = ar.split("},");
		String[] bvalue = new String[avalue.length];
		for (int i = 0; i < avalue.length; i++) {
			bvalue[i] = avalue[i].substring(1);
		}

		for (int i = 0; i < bvalue.length; i++) {
			String str = bvalue[i];
			AppGoodVO goodVo = new AppGoodVO();
			String[] arrs = str.split(",");
		}

		String[] bstring = null;
		for (int i = 0; i < bvalue.length; i++) {
			bstring = bvalue[i].split(",");
			goodVO = new AppGoodVO();
			for (int j = 0; j < bstring.length; j++) {
				String[] value = new String[2];
				value = bstring[j].split(":");
				if (value[0].contains("goodId")) {
					goodVO.setGoodId(value[1]);
				}
				if (value[0].contains("goodName")) {

					goodVO.setGoodName(value[1]);
				}
				if (value[0].contains("goodNum")) {
					goodVO.setGoodNum(value[1]);
				}
				if (value[0].contains("goodprice")) {
					goodVO.setGoodprice(value[1]);
				}
				if (value[0].contains("goodTaste")) {
					goodVO.setGoodTaste(value[1]);
				}
			}
			goodVOlist.add(goodVO);

		}

		orderVO.setDeskNo(request.getParameter(AppConstant.DESKNO));
		orderVO.setTotalPrice(request.getParameter(AppConstant.TOTALPRICE));
		orderVO.setOrderNo(orderNo);
		orderVO.setRensu(addrensu);
		orderVO.setTime(time);
		orderVO.setList(goodVOlist);

		message(orderVO, goodVOlist);

		return "true";
	}

	/**
	 * 
	 * 手机订单提交到后台----socket
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/telmessage", method = RequestMethod.POST)
	@ResponseBody
	public String messageOrder(HttpServletRequest request, ModelMap model)
			throws Exception {

		String truee = "true";
		String falsee = "flase";
		List<OrderTable> order = new ArrayList<OrderTable>();
		// 订单查询
		order = orderTableService.findByphone();

		if (order.size() > 0) {
			return truee;
		} else {
			return falsee;
		}
	}

	/**
	 * 人工呼叫
	 * 
	 * @param request
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/call", method = RequestMethod.POST)
	@ResponseBody
	public String ordercall(HttpServletRequest request, ModelMap model) {

		return "true";
	}

	/**
	 * 结账呼叫
	 * 
	 * @param request
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/bill", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public String billcall(HttpServletRequest request, ModelMap model) {

		return "true";
	}

	public void message(AppOrderVO orderVO, List<AppGoodVO> goodVOlist) throws Exception {
		MyOrder myOrder = new MyOrder();

		String id = "";// 商品id集
		String name = "";// 商品名集
		String qtys = "";// 商品数量集
		String price = "";// 商品价格集
		String taste="";//商品味道
		int totalQty = 0;// 顾客订餐的商品总数
		for (int i = 0; i < goodVOlist.size(); i++) {
			if (i == 0) {
				id = goodVOlist.get(i).getGoodId() + ",";
				name = name + goodVOlist.get(i).getGoodName() + ",";
				qtys = qtys + goodVOlist.get(i).getGoodNum() + ",";
				taste=taste+goodVOlist.get(i).getGoodTaste()+",";
				totalQty = totalQty
						+ Integer.parseInt(goodVOlist.get(i).getGoodNum());
				price = price + goodVOlist.get(i).getGoodprice() + ",";
			} else {
				id = id + goodVOlist.get(i).getGoodId() + ",";
				name = name + goodVOlist.get(i).getGoodName() + ",";
				qtys = qtys + goodVOlist.get(i).getGoodNum() + ",";
				taste=taste+goodVOlist.get(i).getGoodTaste()+",";
				totalQty = totalQty
						+ Integer.parseInt(goodVOlist.get(i).getGoodNum());
				price = price + goodVOlist.get(i).getGoodprice() + ",";
			}
		}
		String Id = "";
		String ids[] = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			ids[i] = ids[i].trim();
			Id = Id + ids[i] + ",";
		}
		//时间设置
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(new Date());
		name = name.trim();
		price = price.trim();
		qtys = qtys.trim();
		myOrder.setGoodsIds(Id);
		myOrder.setGoodsNames(name);
		myOrder.setPrice(price);
		myOrder.setGoodsQtys(qtys);
		myOrder.setGoodsNum(totalQty);
		myOrder.setGoodsTastes(taste);
		myOrder.setTotalPrice(Double.parseDouble(orderVO.getTotalPrice()));
		myOrder.setCreateDate(time);
		myOrder.setId(orderVO.getOrderNo());
		// 添加订单信息

		// 开台
		OrderTable orderTable = new OrderTable();
		// 桌位
		orderTable.setDeskNo(Integer.parseInt(orderVO.getDeskNo()));
		// 顾客人数
		orderTable.setClientNo(Integer.parseInt(orderVO.getRensu()));
		// 定金
		orderTable.setPayment(0.0);
		// 备注
		orderTable.setRemark("");
		// 是否手机订单
		orderTable.setPhone(1);
		// 是否vip
		orderTable.setVip(0);
		
		orderTable.setOrderBook(0);
		// 是否结账
		orderTable.setCheckOut(0);
		// 服务员id
		orderTable.setWaiterId(1);
		orderTable.setCreateTime(time);
		//查询
		  
		  OrderTable tablevalue=new OrderTable();
		  tablevalue=orderTableService.findBydesknophone(orderTable.getDeskNo());
		  if(tablevalue==null){
			  if (LogicUtil.isNotNull(orderVO.getDeskNo())) {
					try {
						
						String orderId = myOrder.getId();
						// 订单id
						orderTable.setOrderId(orderId);
						// 开台
						orderTableService.insert(orderTable);
						// 添加订单信息
						myOrderService.addMyOrder(myOrder);

						int tableId = orderTable.getId();
						// 修改订单信息中的开台id 根据订单id修改订单中的开台的id
						myOrder.setOrderId(tableId);
						myOrderService.updateMyOrder(myOrder);
						// 更改桌位信息
						deskServie.update(Integer.parseInt(orderVO.getDeskNo()));
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("订单提交成功!");
				}else{
					System.out.println("请输入桌号！");
				}
		  }else{
			  
			  //
			  String goodids = "";
				String goodnames="";
				String goodQtys="";
				int goodsNums=0;
				String prices="";
				Double totalPrice=0.0;
				String goodsTastes="";
				MyOrder	  myorders=new MyOrder();
			    myorders=myOrderService.findById(tablevalue.getOrderId());
				 goodids=myorders.getGoodsIds()+myOrder.getGoodsIds();
				 goodnames=myorders.getGoodsNames()+myOrder.getGoodsNames();
				 goodQtys=myorders.getGoodsQtys()+myOrder.getGoodsQtys();
				 goodsNums=myorders.getGoodsNum()+myOrder.getGoodsNum();
				 prices=myorders.getPrice()+myOrder.getPrice();
				 totalPrice=myorders.getTotalPrice()+myOrder.getTotalPrice();
				 goodsTastes=myorders.getGoodsTastes()+myOrder.getGoodsTastes();
			  
			  myOrder.setId(tablevalue.getOrderId());
			  MyOrder value=new MyOrder();
			  value.setId(tablevalue.getOrderId());
			  value.setOrderId(tablevalue.getId());
			  value.setGoodsIds(goodids);
			  value.setGoodsNames(goodnames);
			  value.setGoodsNum(goodsNums);
			  value.setGoodsQtys(goodQtys);
			  value.setPrice(prices);
			  value.setGoodsTastes(goodsTastes); 
			  value.setTotalPrice(totalPrice);
			  value.setCreateDate(myorders.getCreateDate());
			  
			  myOrderService.updateMyOrder(value);
		  }

		
	}

}
