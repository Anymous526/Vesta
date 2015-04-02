package org.lazicats.website.controller.view;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping(value="/homepage")
public class HomgpageController {
	
	
	
	/**
	 * 列表显示商品信息
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public String findList(HttpServletRequest request,ModelMap model) throws Exception{
	    
	    
		return "wangcao/login";
		
	}
	
	
	
}
