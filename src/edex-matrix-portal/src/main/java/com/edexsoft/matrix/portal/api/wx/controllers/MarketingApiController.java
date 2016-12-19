package com.edexsoft.matrix.portal.api.wx.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edexsoft.webmvc.JsonResult;
import com.edexsoft.webmvc.interceptor.IPAddressAuthorizeAnnotation;

@RestController("api/wx/marketing")
public class MarketingApiController {
	// Marketing
	
	private static Logger logger = Logger.getLogger(MarketingApiController.class);
	
	@IPAddressAuthorizeAnnotation(IPAuthKey="wx.api.marketing")
	@RequestMapping(value = "/api/wx/marketing/getuser", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getuser(@RequestParam("userid") String userid, @RequestParam("t") String t) {

		logger.info(String.format("wxconfig get:%s", t));

		JsonResult oJsonResult = null;
		
		Map<String, Object> oMap = new HashMap<String, Object>();
		oMap.put("test", "test");
		
		oJsonResult = new JsonResult(0, "成功", oMap);
		return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);

	}
}
