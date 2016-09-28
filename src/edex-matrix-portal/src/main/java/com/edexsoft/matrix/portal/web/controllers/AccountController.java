package com.edexsoft.matrix.portal.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("web/account")
public class AccountController {

	@RequestMapping(value = { "/account", "/account/login" })
	public ModelAndView Login() {
		String sView = "/web/account/login";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// oModel.put("userName", name);
		return new ModelAndView(sView, oModel);
	}

	@RequestMapping("/account/register")
	public ModelAndView Register() {
		String sView = "/web/account/register";
		Map<String, Object> oModel = new HashMap<String, Object>();
		// map.put("userName", name);
		return new ModelAndView(sView, oModel);
	}
}
