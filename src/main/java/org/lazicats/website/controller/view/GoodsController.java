package org.lazicats.website.controller.view;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.website.entity.Goods;
import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IGoodsService;
import org.lazicats.website.service.IMyOrderService;
import org.lazicats.website.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping(value="/order")
public class GoodsController {
	
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IMyOrderService myorderService;
	
	//用于存储index页面信息
	List<GoodsVo> goodsVoList=new ArrayList<GoodsVo>();
	
	
	/**
	 * 列表显示商品信息
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goodslist")
	public String findList(HttpServletRequest request,ModelMap model) throws Exception{
	    GoodsVo vo=null;
	    if(goodsVoList.size()==0){	 
	    	List<Goods> goodsList=goodsService.findList();
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
	    		goodsVoList.add(vo);					    					
	    	}
	    	
	    }
	    model.put("goodsVoList", goodsVoList);
	    
		return "order/index";
		
	}
	/**
	 * index页面添加商品ID
	 * 商品数量
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add")
	public void addGoods(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String str=request.getParameter("id");		
		String []array=str.split(",");
		String id=array[0];
		String q=array[1];
		int goodsID=Integer.parseInt(id);
		int qty=Integer.parseInt(q);
		for(GoodsVo gv:goodsVoList){			
			if(gv.getId()==goodsID){
				gv.setQty(qty);
			}	
		}		
		
		
	}

	
	
	/**
	 * index页面删除商品
	 */
	@RequestMapping(value="delete")
	public void subGoods(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String str=request.getParameter("id");		
		String []array=str.split(",");
		String id=array[0];
		String q=array[1];
		int goodsID=Integer.parseInt(id);
		int qty=Integer.parseInt(q);
		for(GoodsVo gv:goodsVoList){			
			if(gv.getId()==goodsID){
				gv.setQty(qty);
			
			}	
		}		
		
		
	}

	//-----------------------------------------------------------------
	//用于存储menu订单主页面信息
		List<GoodsVo> goodsVoLists;
	//总价格totalPrice 总数量totalQty
		double totalPrice= 0.0;
		int totalQty=0;
		MyOrder mo=new MyOrder();
	/**
	 * 根据ID查询商品信息
	 * @throws Exception 
	 */
	@RequestMapping("toOrder")
	public String  findOneById(HttpServletRequest request,ModelMap model) throws Exception{
		goodsVoLists=new ArrayList<GoodsVo>();
		
		for(GoodsVo goodsVo:goodsVoList){
			if(goodsVo.getQty()>0){ 
				goodsVoLists.add(goodsVo);						
			}
		}
			
		
		totalQty=0;
		totalPrice=0.0;
	for(GoodsVo god:goodsVoLists){
		totalQty+=god.getQty();
		totalPrice+=god.getQty()*god.getPrice();
		
	}
		
		mo.setGoodsNum(totalQty);
		mo.setTotalPrice(totalPrice);
		model.put("myOrder", mo);
		model.put("goodsVoLists", goodsVoLists);	
		
		return "order/menu";
		
	}
	
	/**
	 * 根据ID添加商品数量
	 */
	@RequestMapping(value="addqty")
	public void addGoodsQty(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
		
		String str=request.getParameter("id");		
		System.out.println("str="+str);
		String []array=str.split(",");
		String id=array[0];
		String q=array[1];
		System.out.println(id+","+q);
		int goodsID=Integer.parseInt(id);
		int qty=Integer.parseInt(q);
		for(GoodsVo gv:goodsVoList){			
			if(gv.getId()==goodsID){
				gv.setQty(qty);
			System.out.println("qty="+gv.getQty());	
			
			}	
		}		
				
	}
	/**
	 * 根据ID减少商品数量
	 */
	@RequestMapping(value="subqty")
	public void subGoodsQty(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
		String str=request.getParameter("id");		
		System.out.println("str="+str);
		String []array=str.split(",");
		String id=array[0];
		String q=array[1];
		System.out.println(id+","+q);
		int goodsID=Integer.parseInt(id);
		int qty=Integer.parseInt(q);
		for(GoodsVo gv:goodsVoList){			
			if(gv.getId()==goodsID){
				gv.setQty(qty);
			System.out.println("qty="+gv.getQty());	
			
			}	
		}		
	}
	
	/**
	 * 根据ID删除商品
	 */
	@RequestMapping(value="removegoods")
	public void removeGoodsQty(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
		String goodsId=request.getParameter("id");		
		int gd=Integer.parseInt(goodsId);
		for(GoodsVo goodsVo:goodsVoList){
			System.out.println("--------------"+goodsId);
			if(goodsVo.getId()==gd){
				goodsVo.setQty(0);
			}
		}
		
		
				
	}
	List<GoodsVo> orderList;
	/**
	 * 
	 * 生成订单
	 * @throws Exception 
	 */
	@RequestMapping(value="submitorder")
	public String submitForm(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		@SuppressWarnings("unused")
		String id=request.getParameter("id");
		MyOrder myorder=new MyOrder();
		 String goodsIds ="";
		 String goodsNames ="";//各商品名称
		 String goodsQtys="";//各商品数量
		 int goodsNum = 0;//商品数量
		 String price ="";//商品价格
		 double totalPrice = 0;//总价格
		//显示订单信息
		 orderList=new ArrayList<GoodsVo>();
			
		for(GoodsVo gv:goodsVoList){
			
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
		myorder.setOrderId(1);
		myorder.setGoodsIds(goodsIds);
		myorder.setGoodsNames(goodsNames);
		myorder.setGoodsQtys(goodsQtys);
		myorder.setGoodsNum(goodsNum);
		myorder.setPrice(price);
		myorder.setTotalPrice(totalPrice);
		//时间设置
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(new Date());
		myorder.setCreateDate(time);
		
		myorderService.addMyOrder(myorder);
		System.out.println("订单已添加成功!");
		model.put("orderList", orderList);
		model.put("myOrder", myorder);
		//将顾客选单信息清0
//		for(GoodsVo go:goodsVoList){
//			go.setQty(0);
//		}
		return "order/service";
		
	}
	
	
	
}
