package org.lazicats.admin.print;

import java.util.ArrayList;
import java.util.List;

import org.lazicats.common.basecomponent.page.PageFinder;
import org.lazicats.common.basecomponent.page.PageQuery;
import org.lazicats.website.entity.MyOrder;

public class Page {

	
	@SuppressWarnings({ "unchecked", "unused" })
	public String firstPage(){
		
		// lists 全部查出来
		List<MyOrder> lists=new ArrayList<MyOrder>();
		PageQuery pquery=new PageQuery();
		pquery.setPageNo(0);
		pquery.setPageSize(6);
		PageFinder<MyOrder> pfinder=new  PageFinder<MyOrder>(pquery.getPageNo(), pquery.getPageSize(),lists.size());
		//pfinder.setData(lists);
		// 1 循环
		List<MyOrder>list1=new ArrayList<MyOrder>();
		List<MyOrder>list2=new ArrayList<MyOrder>();
		List<MyOrder>list3=new ArrayList<MyOrder>();
		for (int i = 0; i < pfinder.getPageSize(); i++) {
			list1=(List<MyOrder>) lists.get(i);
		}
		return "";
	}
}
