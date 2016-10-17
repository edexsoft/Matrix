package com.edexsoft.matrix.portal.wx.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("wx/media")
public class MediaController {
	@RequestMapping("/wx/media/index")
    public ModelAndView Index(Model model) {
		// model.addAttribute("message", "Hello World!");
		String sView = "/wx/media/index";		
		Map<String, Object> oModel = new HashMap<String, Object>();
		// oModel.put("userName", name);
		return new ModelAndView(sView, oModel);
    }
}
