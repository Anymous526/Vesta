package org.lazicats.admin.controller.view;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.admin.entity.Desk;
import org.lazicats.admin.service.IDeskService;
import org.lazicats.common.basecomponent.utils.LogicUtil;
import org.lazicats.common.vo.ImageUtil;
import org.lazicats.common.vo.Page;
import org.lazicats.website.entity.Goods;
import org.lazicats.website.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

@Controller
@RequestMapping(value="/admin/")
public class MaintainController {
	@Autowired
	private IDeskService deskService;
	@Autowired
	private IGoodsService goodsService;
	/***
	 * 跳的后台商品维护页面
	 * @throws Exception 
	 */
	@RequestMapping(value="tomaintain")
	public String tomaintain(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		
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
		List<Desk> desks=null;
		if(pN!=null){
			//清空上次查询的数据
		//	listpage.removeAll(listpage);
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
	
	
	@RequestMapping(value="toSysGoods")
	public String toSysdesk(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
			
		//goods
		//获取参数第几页
		String pN=request.getParameter("pageNo");
		//Page page1=null;
		if(LogicUtil.isNotNull(pN)){
			@SuppressWarnings("unused")
			int pageNo=Integer.parseInt(pN);			
		}
		Page page=null;
		//page.setType(1);
		Integer rows=goodsService.countRows(page);
		System.out.println(rows);
		
		List<Goods> goodslist=null;
		if(pN!=null){
			//清空上次查询的数据
		//	listpage.removeAll(listpage);
			page=new Page(rows,Integer.parseInt(pN));
			page.setPageSize(6);
			goodslist=goodsService.pageGoods(page);
		}else{
			page=new Page(rows, 1);
			page.setPageSize(6);
			goodslist=goodsService.pageGoods(page);
		}
			for(Goods gd:goodslist){
				System.out.println(gd.getId()+","+gd.getName());
			}
			model.put("goodslist", goodslist);
			model.put("page", page);
			for(Goods gd:goodslist){
				System.out.println(gd.getPhto()+","+gd.getName());
			}
		
		return "admin/sys_goods";
	}
	
	/***
	 * 添加桌位信息
	 * @throws Exception 
	 */
	@RequestMapping(value="addDesk")
	public String addDesk(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String dNo=request.getParameter("deskNo");
		int deskNo=Integer.parseInt(dNo);
		String deskName=request.getParameter("deskName");
		String ty=request.getParameter("type");
		int type=Integer.parseInt(ty);
		String description=request.getParameter("description");
		Desk desk=new Desk();
		desk.setDeskNo(deskNo);
		desk.setDeskName(deskName);
		desk.setType(type);
		desk.setBookMark(1);
		desk.setDescription(description);
		deskService.addDesk(desk);
		tomaintain(request, response, model);
		return "admin/sys_desk";
	}
	/***
	 * 弹出修改窗体
	 * @param response
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="toUpdateDesk")
	public void toupdateDesk(HttpServletResponse response,HttpServletRequest request) throws Exception{
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		Desk desk=deskService.findDeskById(id);
		Gson gson=new Gson();
		String result=gson.toJson(desk);
		System.out.println(result);
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
	}
	/***
	 * 修改桌位信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateDesk")
	public String updateDesk(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		String dNo=request.getParameter("deskNo");
		int deskNo=Integer.parseInt(dNo);
		String deskName=request.getParameter("deskName");
		String ty=request.getParameter("type");
		int type=Integer.parseInt(ty);
		String description=request.getParameter("description");
		Desk desk=new Desk();
		desk.setId(id);
		desk.setDeskNo(deskNo);
		desk.setDeskName(deskName);
		desk.setType(type);
		desk.setDescription(description);
		deskService.updateDesk(desk);
		System.out.println(desk);
		tomaintain(request, response, model);
		return "admin/sys_desk";
	}
	
	/***
	 * 删除桌位
	 * @throws Exception 
	 */
	@RequestMapping(value="delDesk")
	public String delete(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		deskService.delDesk(id);
		tomaintain(request, response, model);	
		return"admin/sys_desk";
	}
	
	/**
	 * -------------------------------goods---------------------------------------------
	 */
	
	/***
	 * 添加商品信息
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="addGoods")
	public String addGoods(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String name=request.getParameter("name");
		String ty=request.getParameter("type");
		int type=Integer.parseInt(ty);
		
		ImageUtil util=new ImageUtil();
		 MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
		  MultipartFile imgFile1  =  multipartRequest.getFile("phto");  
		
		  //定义一个数组，用于保存可上传的文件类型  
	         List fileTypes = new ArrayList();  
	         fileTypes.add("jpg");  
	         fileTypes.add("jpeg");  
	         fileTypes.add("bmp");  
	         fileTypes.add("gif");
	         fileTypes.add("png");  
	         File file1=null; 
	         //保存第一张图片  
	         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {  
	/*下面调用的方法，主要是用来检测上传的文件是否属于允许上传的类型范围内，及根据传入的路径名 
	*自动创建文件夹和文件名，返回的File文件我们可以用来做其它的使用，如得到保存后的文件名路径等 
	*这里我就先不做多的介绍。 
	*/  
	            file1 = util.getFile(imgFile1, fileTypes,name,ty);  
	             
	         }  
	           
		  
		//从字符串中将文件名拿出来   
		  String strimage=file1.toString();
		  String p=strimage.substring(strimage.lastIndexOf("\\") + 1);
		  
		String introduce=request.getParameter("introduce");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		
		Goods goods=new Goods();
		goods.setName(name);
		goods.setType(type);
		goods.setPhto(p);
		goods.setIntroduce(introduce);
		goods.setPrice(Float.parseFloat(price));
		goods.setDescription(description);
		goods.setCreate_time(new Date());
		goodsService.addGoods(goods);
		tomaintain(request, response, model);
		return "admin/sys_desk";
	}
	
	/***
	 * 弹出修改商品窗口
	 * @throws Exception 
	 */
	@RequestMapping(value="toUpdateGoods")
	public void toUpdateGoods(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		System.out.println("id="+id);
		Goods goods=goodsService.findOneById(id);
		Gson gson=new Gson();
		String result=gson.toJson(goods);
		System.out.println(result);
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
	}
	
	/***
	 * 修改商品信息
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="updateGoods")
	public String updateGoods(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		String name=request.getParameter("name");
		String ty=request.getParameter("type");
		int type=Integer.parseInt(ty);
		//String phto=request.getParameter("phto");
		
		ImageUtil util=new ImageUtil();
		 MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
		  MultipartFile imgFile1  =  multipartRequest.getFile("phto");  
		
		  //定义一个数组，用于保存可上传的文件类型  
	         List fileTypes = new ArrayList();  
	         fileTypes.add("jpg");  
	         fileTypes.add("jpeg");  
	         fileTypes.add("bmp");  
	         fileTypes.add("gif");  
	         File file1=null; 
	         //保存第一张图片  
	         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {  
	/*下面调用的方法，主要是用来检测上传的文件是否属于允许上传的类型范围内，及根据传入的路径名 
	*自动创建文件夹和文件名，返回的File文件我们可以用来做其它的使用，如得到保存后的文件名路径等 
	*这里我就先不做多的介绍。 
	*/  
	            file1 = util.getFile(imgFile1, fileTypes,name,ty);  
	             
	         }  
	           
		  
		//从字符串中将文件名拿出来   
		  String strimage=file1.toString();
		  String p=strimage.substring(strimage.lastIndexOf("\\") + 1);
		System.out.println(p);
		
		
		String introduce=request.getParameter("introduce");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		Goods goods=new Goods();
		goods.setId(id);
		goods.setName(name);
		goods.setType(type);
		goods.setPhto(p);
		goods.setIntroduce(introduce);
		goods.setPrice(Float.parseFloat(price));
		goods.setDescription(description);
		goodsService.updateGoods(goods);
		tomaintain(request, response, model);
		return"admin/sys_desk";
	}
	
	
	
	//删除商品信息
	@RequestMapping(value="delGoods")
	public String delGoods(HttpServletResponse response,HttpServletRequest request,ModelMap model) throws Exception{
		String id=request.getParameter("id");
		goodsService.delGoods(Integer.parseInt(id));
		tomaintain(request, response, model);
		return "admin/sys_desk";
	}
	
	
	
	
	
	
	
	
	
}
