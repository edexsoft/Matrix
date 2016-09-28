package com.edexsoft.matrix.portal.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edexsoft.webmvc.JsonResult;

@RestController("api/root/account")
public class AccountApiController {
	private static Logger logger = Logger.getLogger(AccountApiController.class);
	
//	@Autowired
//	@Qualifier("AdminService")
//	private IAdminService AdminService;
//	
//	@Autowired
//	@Qualifier("RoleService")
//	private IRoleService RoleService;
	
	@RequestMapping(value = "/api/root/account/login", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> Login(@RequestParam("account") String account,
			@RequestParam("password") String password) {
		
		logger.info(String.format("login account:%s", account));
		
		JsonResult oJsonResult = null;

		if (account == null || account.isEmpty()) {
			oJsonResult = new JsonResult(-1, "account不能为空字符串");
			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
		}

		if (password == null || password.isEmpty()) {
			oJsonResult = new JsonResult(-2, "password不能为空字符串");
			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
		}
		
//		Admin oAdmin = AdminService.findByAccount(account);
//		
//		if (oAdmin == null || !oAdmin.getAcountPass().equals(password)) {
//			oJsonResult = new JsonResult(-12, "账户名不存在或者密码错误");
//			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
//		}
//		
//		Role oRole=RoleService.findById(oAdmin.getAcountRoleId());
		
		List<Object> oData=new ArrayList<Object>();
//		oData.add(oAdmin);
//		oData.add(oRole);
		
		oJsonResult = new JsonResult(0, "登录成功", oData);
		return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
	}
}
