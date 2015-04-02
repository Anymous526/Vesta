package org.lazicats.admin.controller.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/")
public class PageController {
	
	
	@RequestMapping("toPage")
	public String toPage(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		int current=20;
		//pList
		model.put("current", current);
		return "admin/page";
	}
	
}
