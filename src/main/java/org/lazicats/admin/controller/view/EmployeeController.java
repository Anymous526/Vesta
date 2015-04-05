package org.lazicats.admin.controller.view;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.lazicats.admin.entity.Customer;
import org.lazicats.admin.entity.Employee;
import org.lazicats.admin.service.IEmployeeService;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

/***
 * 后台员工管理控制器
 * @author gogole
 *
 */
@Controller
@RequestMapping(value="/admin/")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	/***
	 * 跳的后台人事信息维护页面
	 * @throws Exception 
	 */
//	@RequestMapping(value="toemployee")
//	public String toemployee(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
//		
//		List<Employee> list=employeeService.findAll();
//		
//		model.addAttribute("employees", list);
//		return "admin/sys_employee";
//	}
	
	
	/***
	 * 跳的后台顾客信息维护页面
	 * @throws Exception 
	 */
	@RequestMapping(value="toemployee")
	public String toemployee(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		
		//获取参数第几页
		String pN=request.getParameter("pageNo");
		if(LogicUtil.isNotNull(pN)){
			@SuppressWarnings("unused")
			int pageNo=Integer.parseInt(pN);			
		}
		Page page=null;
		//page.setType(1);
		Integer rows=employeeService.countRows(page);
		System.out.println(rows);
		List<Employee> employees=null;
		if(pN!=null){
			//清空上次查询的数据
		//	listpage.removeAll(listpage);
			page=new Page(rows,Integer.parseInt(pN));
			page.setPageSize(12);
			employees=employeeService.pageEmployee(page);
		}else{
			page=new Page(rows, 1);
			page.setPageSize(12);
			employees=employeeService.pageEmployee(page);
		}
	
		
		model.put("employees", employees);
		model.put("page", page);

		return "admin/sys_employee";
	}
	
	
	/***
	 * 添加员工信息
	 * @throws Exception 
	 */
	@RequestMapping(value="addEmployee")
	public String addEmployee(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String waiterName=request.getParameter("waiterName");
		String se=request.getParameter("sex");
		int sex=Integer.parseInt(se);
		String a=request.getParameter("age");
		int age=Integer.parseInt(a);
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		
		String d=request.getParameter("deptNo");
		int deptNo=Integer.parseInt(d);
		
		String au=request.getParameter("auth");
		int auth=Integer.parseInt(au);
		
		String waiterPassword=request.getParameter("waiterPassword");
		
		
		//时间设置
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		
		Employee employee=new Employee();
		employee.setWaiterName(waiterName);
		employee.setSex(sex);
		employee.setAge(age);
		employee.setTel(tel);
		employee.setAddress(address);
		employee.setDeptNo(deptNo);
		employee.setAuth(auth);
		employee.setWaiterPassword(waiterPassword);
		employee.setCreateTime(time);
		employeeService.addEmployee(employee);
		toemployee(request, response, model);
		return "admin/sys_employee";
	}
	
	
	
	/***
	 * 弹出员工修改窗体
	 * @param response
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="toUpdateEmployee")
	public void toupdateCustomer(HttpServletResponse response,HttpServletRequest request) throws Exception{
		String i=request.getParameter("id");
		int waiterId=Integer.parseInt(i);
		Employee employee=employeeService.findEmployeeById(waiterId);
		Gson gson=new Gson();
		String result=gson.toJson(employee);
		System.out.println(result);
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
	}
	
	
	/***
	 * 修改员工信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateEmployee")
	public String updateEmployee(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String i=request.getParameter("id");
		int waiterId=Integer.parseInt(i);
		String waiterName=request.getParameter("waiterName");
		String se=request.getParameter("sex");
		int sex=Integer.parseInt(se);
		
		String ag=request.getParameter("age");
		int age=Integer.parseInt(ag);
		String tel=request.getParameter("tel");
		String dn=request.getParameter("deptNo");
		int deptNo=Integer.parseInt(dn);
		String au=request.getParameter("auth");
		int auth=Integer.parseInt(au);
		String waiterPassword=request.getParameter("waiterPassword");
		String address=request.getParameter("address");
		Employee employee=new Employee();
		employee.setWaiterId(waiterId);
		employee.setWaiterName(waiterName);
		employee.setSex(sex);
		employee.setAge(age);
		employee.setTel(tel);
		employee.setDeptNo(deptNo);
		employee.setAuth(auth);
		employee.setWaiterPassword(waiterPassword);
		employee.setAddress(address);
		employeeService.updateEmployee(employee);
		System.out.println(employee);
		toemployee(request, response, model);
		return "admin/sys_employee";
	}
	
	/***
	 * 通过id删除顾客信息
	 * @throws Exception 
	 */
	@RequestMapping(value="delEmployee")
	public String delete(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String i=request.getParameter("id");
		int waiterId=Integer.parseInt(i);
		employeeService.delEmployeeById(waiterId);
		toemployee(request, response, model);
		return  "admin/sys_employee";
	}
	
}
