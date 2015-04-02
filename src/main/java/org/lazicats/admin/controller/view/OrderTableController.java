package org.lazicats.admin.controller.view;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.admin.entity.Desk;
import org.lazicats.admin.entity.Employee;
import org.lazicats.admin.entity.OrderTable;
import org.lazicats.admin.service.IDeskService;
import org.lazicats.admin.service.IEmployeeService;
import org.lazicats.admin.service.IOderTableService;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.Page;
import org.lazicats.website.entity.AppConstant;
import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/admin/")
@SessionAttributes("deskPage")
public class OrderTableController {
	@Autowired
	private IDeskService deskService;
	@Autowired
	private IMyOrderService myOrderService;
	@Autowired
	private IOderTableService orderTableService;
	@Autowired
	private IEmployeeService employeeService;;
	
	/**
	 * 到开台页面
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="totable")
	public String totable(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		
		//获取参数第几页
				String pN=request.getParameter("pageNo");
				if(LogicUtil.isNotNull(pN)){
					int pageNo=Integer.parseInt(pN);			
				}
				Page page=null;
				//page.setType(1);
				Integer rows=deskService.countRows(page);
				System.out.println(rows);
				//page.setTotalCount(rows);
				List<Desk> listpage=null;
				List<Desk> list1=null;
				List<Desk> list2=null;
				List<Desk> list3=null;
				if(pN!=null){
					//清空上次查询的数据
				//	listpage.removeAll(listpage);
					page=new Page(rows,Integer.parseInt(pN));
					listpage=deskService.pageDesk(page);
					if(page.getPageNow()>page.getTotalPageCount()){
						page.setPageNow(page.getPageNow()-1);
					}
					
					
					
					
					//将获取的桌位信息封装
					 list1=new ArrayList<Desk>();
					 list2=new ArrayList<Desk>();
					 list3=new ArrayList<Desk>(); 
					for(int i=0;i<listpage.size();i++){
								if(i<5){
									list1.add(listpage.get(i));	
								}else if(i>=5&&i<10){
									list2.add(listpage.get(i));
								}else{
									list3.add(listpage.get(i));
								}		
					}
					
				}else{
					page=new Page(rows, 1);
					listpage=deskService.pageDesk(page);
					
					//将获取的桌位信息封装
					 list1=new ArrayList<Desk>();
					 list2=new ArrayList<Desk>();
					 list3=new ArrayList<Desk>(); 
					for(int i=0;i<listpage.size();i++){
								if(i<5){
									list1.add(listpage.get(i));	
								}else if(i>=5&&i<10){
									list2.add(listpage.get(i));
								}else{
									list3.add(listpage.get(i));
								}		
					}
				}	
						
									
						 //查询所有员工信息
						List<Employee> emps=employeeService.findAll();
						
						//查询所有orderTable
						List<OrderTable> orderTables=new ArrayList<OrderTable>();
						orderTables=orderTableService.findAll();
						
						map.put("emps", emps);
						map.put("orderTables", orderTables);
						
						
						
						map.put("list1", list1);
						map.put("list2", list2);
						map.put("list3", list3);
						map.put("deskPage", page);
		
		return "admin/table";
	}
	
	/****
	 * 条件查询分页
	 * @throws Exception 
	 */
	@RequestMapping(value="page")
	public String pageDesk(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		//获取参数第几页
		String pN=request.getParameter("pageNo");
		if(LogicUtil.isNotNull(pN)){
			@SuppressWarnings("unused")
			int pageNo=Integer.parseInt(pN);			
		}
		Page page=null;
		//page.setType(1);
		Integer rows=deskService.countRows(page);
		System.out.println(rows);
		//page.setTotalCount(rows);
		List<Desk> listpage=null;
		List<Desk> list1=null;
		List<Desk> list2=null;
		List<Desk> list3=null;
		if(pN!=null){
			//清空上次查询的数据
		//	listpage.removeAll(listpage);
			page=new Page(rows,Integer.parseInt(pN));
			listpage=deskService.pageDesk(page);
			
			//将获取的桌位信息封装
			 list1=new ArrayList<Desk>();
			 list2=new ArrayList<Desk>();
			 list3=new ArrayList<Desk>(); 
			for(int i=0;i<listpage.size();i++){
						if(i<5){
							list1.add(listpage.get(i));	
						}else if(i>=5&&i<10){
							list2.add(listpage.get(i));
						}else{
							list3.add(listpage.get(i));
						}		
			}
			
		}else{
			page=new Page(rows, 1);
			listpage=deskService.pageDesk(page);
			
			//将获取的桌位信息封装
			 list1=new ArrayList<Desk>();
			 list2=new ArrayList<Desk>();
			 list3=new ArrayList<Desk>(); 
			for(int i=0;i<listpage.size();i++){
						if(i<5){
							list1.add(listpage.get(i));	
						}else if(i>=5&&i<10){
							list2.add(listpage.get(i));
						}else{
							list3.add(listpage.get(i));
						}		
			}
		}	
				
							
				 //查询所有员工信息
				List<Employee> emps=employeeService.findAll();
				
				//查询所有orderTable
				List<OrderTable> orderTables=new ArrayList<OrderTable>();
				orderTables=orderTableService.findAll();
				
				map.put("emps", emps);
				map.put("orderTables", orderTables);
				
				
				
				map.put("list1", list1);
				map.put("list2", list2);
				map.put("list3", list3);
				map.put("page", page);
	//	totable(request, response, map);
		return "admin/table";
	}
	
	
	
	
	
	
	

	/***
	 * 开台
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	
	@Transactional
	@RequestMapping(value="addTable")
	public String createTable(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		
		MyOrder myOrder=new MyOrder();
		//时间设置
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		//设置ID
		SimpleDateFormat sdfor = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderNo = sdfor.format(new Date()) + request.getParameter(AppConstant.DESKNO);
		myOrder.setCreateDate(time);
		myOrder.setId(orderNo);
		//插入一个空的顾客订单,获取顾客订单号
		//id
		myOrderService.addMyOrder(myOrder);
		
		String orderId=myOrder.getId();
		//服务员ID号
		String wd=request.getParameter("waiterId");
		int waiterId=Integer.parseInt(wd);
		String dn=request.getParameter("deskNo");
		int	 deskNo=Integer.parseInt(dn);
		String cn=request.getParameter("clientNum");
		int clientNum= Integer.parseInt(cn);											
		String v=request.getParameter("vip");//on是 null否
		int vip=1;
		if(LogicUtil.isNull(v)){
			vip=0;
		}
		int phone=1;
		String ph=request.getParameter("phone");
		if(LogicUtil.isNull(ph)){
			phone=0;
		}
		double	payment=0.0;
		String payment1=request.getParameter("payment");
		int p=payment1.length();
		if(p!=0){
			payment=Double.parseDouble(payment1);						
		}
		
		String remarks=request.getParameter("remarks");
		//开台
			OrderTable table=new OrderTable();
			//table.setId(1);
		table.setOrderId(orderNo);
		table.setDeskNo(deskNo);
		table.setWaiterId(waiterId);
		table.setClientNo(clientNum);
		table.setVip(vip);
		table.setOrderBook(0);
		table.setPhone(phone);
		table.setPayment(payment);
		table.setCheckOut(0);
		table.setRemark(remarks);
		//时间设置
		table.setCreateTime(time);
		
		//开台
			deskService.update(deskNo);
			orderTableService.insert(table);			
			int tableId=table.getId();
			//修改订单信息中的开台id 根据订单id修改订单中的开台的id
			myOrder.setOrderId(tableId);
			myOrderService.updateMyOrder(myOrder);
			System.out.println("开台成功!");	
		totable(request, response, map); 
		return "admin/table";
	}
	
	/***
	 * 顾客就餐状态
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	/**
	@RequestMapping(value="eate")
	public String eate(HttpServletResponse response,HttpServletRequest request,ModelMap model) throws Exception{
		String id=request.getParameter("id");
		Integer deskNo=Integer.parseInt(id);
		//通过id找到对应的订单，判断是否订餐，没有则不能就餐
		System.out.println("deskNo:"+deskNo);
		List<OrderTable> otlist=(List<OrderTable>) orderTableService.findByDeskId(deskNo);
		for(OrderTable ot:otlist){
			MyOrder myorder=myOrderService.findById(ot.getOrderId());
			if(LogicUtil.isNotNull(myorder.getGoodsIds())){
				deskService.updateEate(deskNo);
				break;
			}			
		}
		totable(request, response, model);
		return "admin/table";
	}
	
	*/
}
