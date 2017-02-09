package com.edexsoft.matrix.portal.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edexsoft.matrix.portal.config.IPAuthConfig;
import com.edexsoft.matrix.portal.config.PortalConfig;
import com.edexsoft.matrix.portal.config.WxApiConfig;

@Controller("web/home")
public class HomeController {
	@RequestMapping("/home/index")
    public ModelAndView Index(Model model) {
		// model.addAttribute("message", "Hello World!");
		
		String sWebRootKey=PortalConfig.WEBAPP_ROOT_KEY;
		String sWxApiMarketing=IPAuthConfig.WX_API_MARKETING;
		String sWxSecret=WxApiConfig.WX_SECRET;
		
		String sView = "/web/home/index";		
		Map<String, Object> oModel = new HashMap<String, Object>();
		// oModel.put("userName", name);
		return new ModelAndView(sView, oModel);
    }
}
