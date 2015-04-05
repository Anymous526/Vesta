package org.lazicats.admin.controller.view;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.admin.entity.Customer;
import org.lazicats.admin.service.ICustomerService;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

/***
 * 顾客信息控制器
 * @author gogole
 *
 */
@Controller
@RequestMapping(value="/admin/")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	/***
	 * 跳的后台顾客信息维护页面
	 * @throws Exception 
	 */
//	@RequestMapping(value="tocustomer")
//	public String omaintain(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
//		
//		List<Customer> list=customerService.findAll();
//		
//		model.addAttribute("customers", list);
//		return "admin/sys_customer";
//	}
//	
	
	/***
	 * 跳的后台顾客信息维护页面
	 * @throws Exception 
	 */
	@RequestMapping(value="tocustomer")
	public String tomaintain(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		
		//获取参数第几页
		String pN=request.getParameter("pageNo");
		if(LogicUtil.isNotNull(pN)){
			@SuppressWarnings("unused")
			int pageNo=Integer.parseInt(pN);			
		}
		Page page=null;
		//page.setType(1);
		Integer rows=customerService.countRows(page);
		System.out.println(rows);
		List<Customer> customers=null;
		if(pN!=null){
			//清空上次查询的数据
		//	listpage.removeAll(listpage);
			page=new Page(rows,Integer.parseInt(pN));
			page.setPageSize(12);
			customers=customerService.pageCustomer(page);
		}else{
			page=new Page(rows, 1);
			page.setPageSize(12);
			customers=customerService.pageCustomer(page);
		}
	
		
		model.put("customers", customers);
		model.put("page", page);

		return "admin/sys_customer";
	}
	
	
	
	/***
	 * 添加顾客信息
	 * @throws Exception 
	 */
	@RequestMapping(value="addCustomer")
	public String addCustomer(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String name=request.getParameter("name");
		String se=request.getParameter("sex");
		int sex=Integer.parseInt(se);
		String a=request.getParameter("age");
		int age=Integer.parseInt(a);
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		//时间设置
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		
		Customer customer=new Customer();
		customer.setName(name);
		customer.setSex(sex);
		customer.setAge(age);
		customer.setTel(tel);
		customer.setAddress(address);
		customer.setCreateTime(time);
		customerService.addCustomer(customer);
		tomaintain(request, response, model);
		return "admin/sys_customer";
	}
	
	/***
	 * 弹出顾客修改窗体
	 * @param response
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="toUpdateCustomer")
	public void toupdateCustomer(HttpServletResponse response,HttpServletRequest request) throws Exception{
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		Customer customer=customerService.findCustomerById(id);
		Gson gson=new Gson();
		String result=gson.toJson(customer);
		System.out.println(result);
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
	}
	
	
	
	/***
	 * 修改顾客信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateCustomer")
	public String updateCustomer(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		String name=request.getParameter("name");
		String se=request.getParameter("sex");
		int sex=Integer.parseInt(se);
		
		String ag=request.getParameter("age");
		int age=Integer.parseInt(ag);
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		Customer customer=new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setSex(sex);
		customer.setAge(age);
		customer.setTel(tel);
		customer.setAddress(address);
		
		customerService.updateCustomer(customer);
		System.out.println(customer);
		tomaintain(request, response, model);
		return "admin/sys_customer";
	}
	
	/***
	 * 通过id删除顾客信息
	 * @throws Exception 
	 */
	@RequestMapping(value="delCustomer")
	public String delete(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		customerService.delCustomerById(id);
		tomaintain(request, response, model);	
		return  "admin/sys_customer";
	}
	
	
	
	
	
}
