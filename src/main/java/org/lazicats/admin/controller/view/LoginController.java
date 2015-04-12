package org.lazicats.admin.controller.view;

import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/admin/")
@SessionAttributes("deskPage")
public class LoginController {
	
	@Autowired
	private IDeskService deskService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IOderTableService orderTableService;
	
	
	
	/**
	 * 登录页面
	 */
	@RequestMapping(value="tologin")
	public String tologin(){
		return "admin/login";
	}
	/***
	 * 返回主页
	 */
	@RequestMapping(value="tomain")
	public String tomain(){
		return "admin/main";
	}
	/**
	 * 登录的实现
	 * @throws Exception 
	 */
	@RequestMapping(value="login")
	public String login(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Employee emp=employeeService.login(username);
		 if(LogicUtil.isNull(emp)){
			 model.put("error", "用户名不存在");
			 return "admin/login";
		 }else if(!emp.getWaiterPassword().equals(password)){
			 model.put("error", "密码错误");
			 return "admin/login";
		 }else{
			 model.put("admin", emp);
		 }
		 /**
		 //跳到开台页面
		//查询所有桌面信息
			String ty=request.getParameter("type");
			List<Desk> list=null;
			if(LogicUtil.isNullOrEmpty(ty)){
				list=deskService.findDesk(1);			
			}else{
				Integer type=Integer.parseInt(ty);
				list=deskService.findDesk(type);
			}
			
			List<Desk> list1=new ArrayList<Desk>();
			List<Desk> list2=new ArrayList<Desk>();
			List<Desk> list3=new ArrayList<Desk>(); 
			for(int i=0;i<list.size();i++){
						if(i<=6){
							list1.add(list.get(i));	
						}else if(i>6&&i<14){
							list2.add(list.get(i));
						}else{
							list3.add(list.get(i));
						}		
			}
			 //查询所有员工信息
			List<Employee> emps=employeeService.findAll();
			
			//查询所有orderTable
			List<OrderTable> orderTables=new ArrayList<OrderTable>();
			orderTables=orderTableService.findAll();
			
			model.put("emps", emps);
			model.put("orderTables", orderTables);
			model.put("list1", list1);
			model.put("list2", list2);
			model.put("list3", list3);
			*/
		 
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
				if(page.getPageNow()>page.getTotalPageCount()){
					page.setPageNow(page.getPageNow()-1);
				}
				
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
					
					model.put("emps", emps);
					model.put("orderTables", orderTables);
					
					
					
					model.put("list1", list1);
					model.put("list2", list2);
					model.put("list3", list3);
					model.put("deskPage", page);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		return "admin/table";
	}
	
	
}
