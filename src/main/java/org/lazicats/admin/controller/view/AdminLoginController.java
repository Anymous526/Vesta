package org.lazicats.admin.controller.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.admin.entity.Desk;
import org.lazicats.admin.entity.Employee;
import org.lazicats.admin.service.IDeskService;
import org.lazicats.admin.service.IEmployeeService;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.Page;
import org.lazicats.website.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/")
public class AdminLoginController {
	@Autowired
	private IDeskService deskService;
	@Autowired
	private IGoodsService goodsService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	/***
	 * 跳的后台商品维护页面
	 * @throws Exception 
	 */
	@RequestMapping(value="toSysLogin")
	public String tomaintain(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		
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
		
		 List<Desk>desks=null;
			//获取参数第几页
			String pN=request.getParameter("pageNo");
			if(LogicUtil.isNotNull(pN)){
			@SuppressWarnings("unused")
			int pageNo=Integer.parseInt(pN);	
			}
			Page page=null;
			Integer rows=deskService.countRows(page);
			//page.setType(1);
			System.out.println(rows);
			if(pN!=null){
			page=new Page(rows,Integer.parseInt(pN));
			page.setPageSize(12);
			desks=deskService.pageDesk(page);
			}else{
				page=new Page(rows, 1);
				page.setPageSize(12);
				desks=deskService.pageDesk(page);
			}
		 
		 
		 
		
		
		model.put("desks", desks);
	
		model.put("page", page);
		
		return "admin/sys_desk";
	}
	
	
}
