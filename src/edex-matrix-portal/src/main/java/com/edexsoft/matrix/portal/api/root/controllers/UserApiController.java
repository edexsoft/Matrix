//package com.edexsoft.matrix.portal.api.root.controllers;
//
//import java.util.Date;
//
//import org.apache.log4j.Logger;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.edexsoft.webmvc.JsonResult;
//import com.edexsoft.data.PagingData;
//import com.edexsoft.matrix.domain.IUserService;
//import com.edexsoft.matrix.domain.User;
//
//@RestController("api/root/user")
//public class UserApiController {
//	private static Logger logger = Logger.getLogger(UserApiController.class);
//
//	@Autowired
//	@Qualifier("UserService")
//	private IUserService UserService;
//
//	@RequestMapping(value = "/api/root/user", method = RequestMethod.GET)
//	public ResponseEntity<JsonResult> Login(@RequestParam("account") String account,
//			@RequestParam("nickname") String nickName) {
//
//		logger.info(String.format("login account:%s", account));
//
//		JsonResult oJsonResult = null;
//
//		if (account == null || account.isEmpty()) {
//			oJsonResult = new JsonResult(-1, "account不能为空字符串");
//			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
//		}
//
//		//PagingDataResult<User> oData = new PagingDataResult<User>();
//		PagingData<User> oData = UserService.Get(
//				account, nickName, 
//				//auditState, desc, createdBegin, createdEnd, pageSize, pageIndex
//				0, "",
//				new Date(), new Date(),
//				10L, 0L);
//
//		oJsonResult = new JsonResult(0, "成功", oData);
//		return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
//	}
//}
