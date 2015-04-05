package org.lazicats.admin.controller.view;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.admin.entity.Desk;
import org.lazicats.admin.entity.OrderTable;
import org.lazicats.admin.service.IDeskService;
import org.lazicats.admin.service.IOderTableService;
import org.lazicats.admin.vo.Account;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.Page;
import org.lazicats.website.entity.Goods;
import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IGoodsService;
import org.lazicats.website.service.IMyOrderService;
import org.lazicats.website.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
/***
 * 点餐页面商品显示
 * @author gogole
 *
 */
@Controller
@RequestMapping(value="/admin/")
public class MeanController {
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IMyOrderService myOrderService;
	
	@Autowired
	private IOderTableService orderTableService;
	
	@Autowired
	private IDeskService deskService;
	//用于存储index页面信息
	List<GoodsVo> goodsVoList=null;
	
	//当前订单集
	List<GoodsVo> myOrderList=new ArrayList<GoodsVo>();
	//当前订单信息		
	MyOrder myOrder=null;
	
	
	
	/**
	 * 根据类型对商品进行分页
	 * @param pageNo
	 * @param type
	 * @return googsPage
	 * @throws Exception
	 */
	List<Goods> goodsList = null;
	
	@RequestMapping(value="tomean")
	public String tomean(HttpServletRequest request,ModelMap model) throws Exception{
		goodsVoList=new ArrayList<GoodsVo>();
		//根据类型查询商品信息
		String type=request.getParameter("type");
		if(LogicUtil.isNotNull(type)){
			Goods goods=new Goods();
			goods.setType(Integer.parseInt(type));
			//根据类型查询商品
			goodsList=goodsService.findByType(goods);			
		}else{
			Goods goods=new Goods();
			goodsList=goodsService.findByType(goods);
		}
		GoodsVo vo=null;
		for(Goods goods:goodsList){
    		vo=new GoodsVo();
    		vo.setQty(0);
    		vo.setId(goods.getId());
    		vo.setName(goods.getName());
    		vo.setType(goods.getType());
    		vo.setPhto(goods.getPhto());
    		vo.setIntroduce(goods.getIntroduce());
    		vo.setPrice(goods.getPrice());
    		vo.setDescription(goods.getDescription());
    		vo.setCreate_time(goods.getCreate_time());
    		System.out.println(goods);
    		goodsVoList.add(vo);
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
		System.out.println("pageNo:" + pageNo);
		Page page=null;
		List<GoodsVo> list1 = new ArrayList<GoodsVo>();
		List<GoodsVo> list2 = new ArrayList<GoodsVo>();
		List<GoodsVo> list3 = new ArrayList<GoodsVo>();
		
		if(goodsVoList.size()!=0){
		    page = new Page(goodsVoList.size(), pageNo);
			page.setPageSize(15);
			page.setTotalCount(goodsVoList.size());
			page.setStartPos((page.getPageNow()-1)*page.getPageSize());
			GoodsVo goods1;
			if(pageNo ==page.getTotalPageCount()){
				for (int i = page.getStartPos(); i <page.getTotalCount(); i++) {
					goods1=new GoodsVo();
					goods1=goodsVoList.get(i);
					if(i<(page.getStartPos()+5)){//5
						System.out.println(goods1);
						list1.add(goods1);	
					}else if(i>=(page.getStartPos()+5)&&i<(page.getStartPos()+10)){//5,10
						list2.add(goods1);
						System.out.println(goods1);
					}else{
						list3.add(goods1);
						System.out.println(goods1);
					}		
				}
			}else{
				for (int i = page.getStartPos(); i <(page.getPageNow()*page.getPageSize()); i++) {
					goods1=new GoodsVo();
					goods1=goodsVoList.get(i);
					if(i<(page.getStartPos()+5)){
						list1.add(goods1);	
						System.out.println(goods1);
					}else if(i>=(5+page.getStartPos())&&i<(page.getStartPos()+10)){
						list2.add(goods1);
						System.out.println(goods1);
					}else{
						list3.add(goods1);
						System.out.println(goods1);
					}		
				}
			}			
		}else{
			page=new Page(0,1);
			page.setPageSize(15);
		}
		
	
		System.out.println("list1="+list1);
		System.out.println("list2="+list2);
		System.out.println("list3="+list3);
		 myOrder=new MyOrder();
		 int totalNum=0;
		double totalPrice=0.00;
		if(myOrderList.size()==0){
			myOrder.setGoodsNum(0);
			myOrder.setTotalPrice(0);
		}else{
			
			//计算订单列表的总数量，总价格
			for(GoodsVo gv:myOrderList){
				totalNum+=gv.getQty();
				totalPrice+=gv.getQty()*gv.getPrice();
			}
			myOrder.setGoodsNum(totalNum);
			myOrder.setTotalPrice(totalPrice);
		}	
		//查询所有桌号信息
		List<Desk> desks=deskService.findAllDesk();
		System.out.println(desks);
		//所有被预定的桌位信息
		List<Desk> reserve=new ArrayList<Desk>();
		
		for(Desk desk:desks){
			if(desk.getBookMark()==2){
				System.out.println("预定"+desk.getBookMark()+desk.getDeskName()+desk.getDeskNo());
				reserve.add(desk);
				
			}
		}

		
			model.put("list1", list1);
			model.put("list2", list2);
			model.put("list3", list3);			
			model.put("myOrderList", myOrderList);
			model.put("myOrder", myOrder);
			model.put("reserve", reserve);
			model.put("page", page);		
			return "admin/mean";
	}
	
	
	
	/***
	 * 后台第一次添加商品至订单集合
	 * @throws Exception 
	 */
	
	@RequestMapping(value="add")
	public void addGoods(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		int q=1;
		boolean flag=false;
		String num=request.getParameter("id");
		int id=Integer.parseInt(num);
		for(GoodsVo gv:goodsVoList){
			//判断列表中添加的商品ID
			if(gv.getId()==id){
				//第一次向订单列表中添加商品
				if(myOrderList.size()==0){
					gv.setQty(1);
					myOrderList.add(gv);
				}else{
					//判断订单列表中没有该商品，才能添加成功 有则添加商品数量
					for(GoodsVo go:myOrderList){
						System.out.println(myOrderList);
						//将myOrderList中的每一个元素的id和gv的id进行比较，确定没有之后才能添加 
						if(gv.getId()==go.getId()){
							flag=false;//比较中有这个元素
							q=go.getQty()+1;
							go.setQty(q);
							break;
						}else{
							flag=true;//比较第一次没有
						}
						
					}
					
					if(flag==true){
						gv.setQty(1);
						myOrderList.add(gv);
						System.out.println(myOrderList);
						break;
					}
				}
			}
		}
		Gson gson=new Gson();
		String result=gson.toJson(myOrderList);
		
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();		
	}
	
	
	/***
	 * 订单列表添加商品数量
	 */
	@RequestMapping(value="addqty")
	public void addGoodsOrder(HttpServletRequest request){
		
		String str=request.getParameter("id");		
		
		String []array=str.split(",");
		String id=array[0];
		String q=array[1];
		System.out.println(id+","+q);
		int goodsID=Integer.parseInt(id);
		int qty=Integer.parseInt(q);
		for(GoodsVo gv:myOrderList){			
			if(gv.getId()==goodsID){
				gv.setQty(qty);
			
			
			}	
		}		
				
		
	}
	
	
	/****
	 * 订单中减少商品数量
	 */
	@RequestMapping(value="subqty")
	public void subGoodsQty(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
		String str=request.getParameter("id");		
		
		String []array=str.split(",");
		String id=array[0];
		String q=array[1];
		int goodsID=Integer.parseInt(id);
		int qty=Integer.parseInt(q);
		for(GoodsVo gv:myOrderList){			
			if(gv.getId()==goodsID){
				gv.setQty(qty);
			}	
		}		
	}
	
	/**
	 * 根据ID从订单中删除商品
	 */
	@RequestMapping(value="removegoods")
	public void removeGoodsQty(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
		String goodsId=request.getParameter("id");		
		int gd=Integer.parseInt(goodsId);
		for(GoodsVo goodsVo:myOrderList){
			if(goodsVo.getId()==gd){
				myOrderList.remove(goodsVo);
			}
		}
		
		
				
	}
	
	/**
	 * 
	 * 生成订单 给哪一桌的顾客点餐 deskNo 不是添加，而是修改订单
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Transactional
	@RequestMapping(value="submitorder")
	public String submitForm(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String di=request.getParameter("deskId");
		Integer deskId=Integer.parseInt(di);
		List<OrderTable> ots=orderTableService.findByDeskId(deskId);
		String orderId="";
		for(OrderTable ot:ots){
			if(ot.getCheckOut()==0){
				orderId=ot.getOrderId();
				break;				
			}
		}
		String id=request.getParameter("id");
		//通过订单Id查出订单信息
		MyOrder myorder=myOrderService.findById(orderId);
		if(LogicUtil.isNull(myorder)){
			myorder=new MyOrder();
		}
		System.out.println("根据orderId查询出的订单信息"+myorder.getId()+myorder.getGoodsNames()+myorder.getGoodsNum());
		
		//修改id的信息,以前有的信息不能删掉，添加新的数据
		String goodsIds="";
		 String goodsNames="";
		 String price="";
		 String goodsQtys="";
		if(LogicUtil.isNotNull(myorder.getGoodsIds())){
			goodsIds =myorder.getGoodsIds();						  
		}
		if(LogicUtil.isNotNull(myorder.getGoodsNames())){
			 goodsNames =myorder.getGoodsNames();//各商品名称			
		}
		if(LogicUtil.isNotNull(myorder.getPrice())){
			 price =myorder.getPrice();//商品价格集			
		}
		if(LogicUtil.isNotNull(myorder.getGoodsQtys())){
		 goodsQtys=myorder.getGoodsQtys();//各商品数量			
		}
		 int goodsNum = myorder.getGoodsNum();//商品数量
		 double totalPrice = myorder.getTotalPrice();//总价格
		
		
		
	
		//显示订单信息
	List<GoodsVo>	 orderList=new ArrayList<GoodsVo>();
			
		for(GoodsVo gv:myOrderList){
			
			if(gv.getQty()>0){
				orderList.add(gv);
				goodsIds=goodsIds+gv.getId()+",";
				goodsNames=goodsNames+gv.getName()+",";
				goodsQtys=goodsQtys+gv.getQty()+",";
				goodsNum=goodsNum+gv.getQty();
				price=price+gv.getPrice()+",";
				totalPrice=totalPrice+gv.getPrice()*gv.getQty();
			}
		}
		//时间设置
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		myorder.setGoodsIds(goodsIds);
		myorder.setGoodsNames(goodsNames);
		myorder.setGoodsQtys(goodsQtys);
		myorder.setGoodsNum(goodsNum);
		myorder.setPrice(price);
		myorder.setTotalPrice(totalPrice);
		myorder.setCreateDate(time);
		System.out.println("djkdjkdkjkdjkdfkjdfkjdf"+sdf.parse(time).toString());
		myOrderService.updateMyOrder(myorder);
		String myOrderid=myorder.getId();
		//在添加订单前给它一个开台信息
		
		//将顾客选单信息清空
		myOrderList.clear();
		//查询所有订单信息
		List<MyOrder> myOrderList=myOrderService.findAll();
		//查询所有开台信息
		List<OrderTable> orderTableList=orderTableService.findAll();
		//结账
		Account account=null;
		List<Account> accountList1=new ArrayList<Account>();
		for(MyOrder mo:myOrderList){
			for(OrderTable ot:orderTableList){
				//判断开台后是否有订餐
				if(ot.getOrderId().equals(mo.getId())){
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
		System.out.println("pageNo:" + pageNo);
		List<Account> accountList = new ArrayList<Account>();
		Page page=null;
		if(accountList1.size()!=0){
			 page = new Page(accountList1.size(), pageNo);
			page.setPageSize(12);
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
		return "admin/orderlist";
		
	}

	
}
