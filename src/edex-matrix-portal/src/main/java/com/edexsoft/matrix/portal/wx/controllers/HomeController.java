package com.edexsoft.matrix.portal.wx.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("wx/home")
public class HomeController {
	@RequestMapping("/wx/home/index")
    public ModelAndView Index(Model model) {
		// model.addAttribute("message", "Hello World!");
		String sView = "/wx/home/index";		
		Map<String, Object> oModel = new HashMap<String, Object>();
		// oModel.put("userName", name);
		return new ModelAndView(sView, oModel);
    }
}
