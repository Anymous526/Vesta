package org.lazicats.website.controller.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.website.entity.MyOrder;
import org.lazicats.website.service.IMyOrderService;
import org.lazicats.website.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/order/")
public class MyOrderController {
	@Autowired
	private IMyOrderService myOrderService;
	
	/***
	 * 根据Id查询订单信息
	 * @throws Exception 
	 */
	@RequestMapping(value="findOrder")
	@SuppressWarnings("unused")
	public String findByMyOrder(HttpServletResponse response,HttpServletRequest request,ModelMap model) throws Exception{
			//int orderId=Integer.parseInt(request.getParameter("id"));
		String orderId=request.getParameter("id");
		MyOrder	myOrder=myOrderService.findById(orderId);
		String goodsIds=myOrder.getGoodsIds();
		String goodsNames=myOrder.getGoodsNames();
		String goodsQtys=myOrder.getGoodsQtys();
		String price=myOrder.getPrice();
		//解析字符串
		GoodsVo gv=new GoodsVo();
		String[] ids=goodsIds.split(",");
		String[] names=goodsNames.split(",");
		String[] qtys=goodsQtys.split(",");
		String[] prices=price.split(",");
		List<GoodsVo> orderList=new ArrayList<GoodsVo>();
			
		  for(int i=0;i<ids.length;i++){
					 GoodsVo goodsVo=new GoodsVo();
					 goodsVo.setId(Integer.parseInt(ids[i]));
					 goodsVo.setName(names[i]);
					 goodsVo.setQty(Integer.parseInt(qtys[i]));
					 goodsVo.setPrice(Float.parseFloat(prices[i]));
					 orderList.add(goodsVo);
		  }
		model.put("myOrder", myOrder);
		model.put("orderList", orderList);
		return "order/service";
	}
	
}
