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
import org.lazicats.admin.vo.Account;
import org.lazicats.admin.vo.SelCount;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.Page;
import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/***
 * 结账管理控制器
 * @author gogole
 *
 */
@Controller
@RequestMapping(value="/admin/")
public class AdminAccountController {
	// 员工号  员工姓名   时间段  总桌数  总价格
	@Autowired
	private IOderTableService oderTableService;//开台
	@Autowired
	private IMyOrderService myOrderService;//订单
	@Autowired
	private IDeskService deskService;//桌号
	@Autowired
	private IEmployeeService employeeService;//员工
	
	
	/***
	 * 显示后台结账管理信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="accountList")
	public String TimeSearch(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		List<OrderTable> orderTableList=oderTableService.findAll();
		//开台信息，checkOut为1表示已经结账的开台信息
		List<SelCount> selCountList1=new ArrayList<SelCount>();
		for(OrderTable ot:orderTableList){
			if(ot.getCheckOut()==1){
				SelCount sc=new SelCount();
				sc.setOrderTable(ot);//添加开台信息
				Employee employee=employeeService.findEmployeeById(ot.getWaiterId());
				sc.setEmployee(employee);//通过开台信息的员工id查询到员工信息
				Desk desk=deskService.findDeskById(ot.getDeskNo());
				sc.setDesk(desk);//通过开台的桌号信息查询到对应的桌位信息
				MyOrder myOrder=myOrderService.findById(ot.getOrderId());//应该是个集合
				sc.setMyOrder(myOrder);//通过开台信息的订单id查找到对应的订单信息
				
				selCountList1.add(sc);
			}
		}
		
		List<SelCount> selCountList2=new ArrayList<SelCount>();//存储时间段内的账单
		
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		if(LogicUtil.isNotNull(start)&&LogicUtil.isNotNull(end)){		
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(SelCount sc1:selCountList1){
				  Date time=sdf.parse(sc1.getOrderTable().getCreateTime());
				  Date start1=sdf.parse(start.toString()+":00");
				  Date end1=sdf.parse(end.toString()+":00");
				  int hour=(int) ((time.getTime()-start1.getTime())/(60*60*1000));
				  int hour1=(int) ((end1.getTime()-time.getTime())/(60*60*1000));
				  if(hour>0&&hour1>0){
					  selCountList2.add(sc1);  
				  }
			}
		}else{
			for(SelCount sc2:selCountList1){
				selCountList2.add(sc2);  
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
		List<SelCount> selCountList = new ArrayList<SelCount>();
		int deskTotal=0;
		double totalPrice=0.00;
		Page page=null;
		if(selCountList2.size()!=0){
			 page = new Page(selCountList2.size(), pageNo);
			page.setTotalCount(selCountList2.size());
			page.setStartPos((page.getPageNow()-1)*page.getPageSize());
			SelCount sel;
			if(pageNo ==page.getTotalPageCount()){
				for (int i = page.getStartPos(); i <page.getTotalCount(); i++) {
					sel=new SelCount();
					sel=selCountList2.get(i);
					selCountList.add(sel);
					deskTotal++;
					totalPrice=totalPrice+sel.getMyOrder().getTotalPrice();
				}
			}else{
				for (int i = page.getStartPos(); i <(page.getPageNow()*page.getPageSize()); i++) {
					sel=new SelCount();
					sel=selCountList2.get(i);
					selCountList.add(sel);
					deskTotal++;
					totalPrice=totalPrice+sel.getMyOrder().getTotalPrice();
				}
			}		
		}else{
			page=new Page(0,1);
		}

			model.addAttribute("accountCountList", selCountList);
			model.addAttribute("deskTotal", deskTotal);
			model.addAttribute("totalPrice", totalPrice);
			model.put("page", page);
		return "admin/sys_account";
	}
	
	
	
}
