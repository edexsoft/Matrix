package com.edexsoft.matrix.portal.api.wx.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edexsoft.framework.utility.JsonHelper;
import com.edexsoft.matrix.portal.WxApiConfig;
import com.edexsoft.webmvc.HttpProxy;
import com.edexsoft.webmvc.JsonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("api/wx/wxjssdk")
public class WxJsSdkApiController {

	private static Logger logger = Logger.getLogger(WxJsSdkApiController.class);

	@RequestMapping(value = "/api/wx/wxjssdk/wxconfig", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> get(@RequestParam("requestUrl") String requestUrl, @RequestParam("t") String t) {

		logger.info(String.format("wxconfig get:%s", t));

		JsonResult oJsonResult = null;
		if (requestUrl == null || requestUrl.trim().isEmpty()) {
			oJsonResult = new JsonResult(-1, "参数错误,requestUrl不能为空.");
			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
		}
		
		String sWxUrlGetToken = String.format("%s?grant_type=%s&appid=%s&secret=%s",
				"https://api.weixin.qq.com/cgi-bin/token", "client_credential", WxApiConfig.WX_APP_ID, WxApiConfig.WX_SECRET);
		
		
		HttpProxy oHttpProxy = HttpProxy.getProxy();
		// {"access_token":"wNRlzkNFdxb_AhD4wogmCL9PUBNsxqK_qpe-Rnv5dRQXsckjaR998fnDkhlAVX9H1lrvssX2b82OxMfN0AuKsArukGXCjTv7p3waMq8TK4kF8bGLFGqLlGX4-jeT8wJKKUQcCAAEOK","expires_in":7200}
		String sResult = null;
		try {
			sResult = oHttpProxy.get(sWxUrlGetToken, "UTF-8");
		} catch (IOException e) {
			logger.error(e.toString());
		}
		if (sResult == null || sResult.trim().isEmpty()) {
			oJsonResult = new JsonResult(-11, "微信接口访问错误,微信接口token返回空字符串.");
			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
		}
		JsonNode oJsonNode = JsonHelper.readTree(sResult);
		if (oJsonNode == null) {
			oJsonResult = new JsonResult(-12, "解析数据失败,解析微信接口token返回字符串失败.");
			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
		}
		String sAccessToken = oJsonNode.get("access_token").asText();

		String sWxUrlGetTicket = String.format("%s?access_token=%s&type=%s",
				"https://api.weixin.qq.com/cgi-bin/ticket/getticket", sAccessToken, "jsapi");
		// {"errcode":0,"errmsg":"ok","ticket":"kgt8ON7yVITDhtdwci0qefgHi5aZwMipfguuBM88tsdWS_PSJ3HlHEKvqp6e0eTaCg08TwYz376WLcKYo-kHhw","expires_in":7200}
		sResult = null;
		try {
			sResult = oHttpProxy.get(sWxUrlGetTicket, "UTF-8");
		} catch (IOException e) {
			logger.error(e.toString());
		}

		if (sResult == null || sResult.trim().isEmpty()) {
			oJsonResult = new JsonResult(-13, "微信接口访问错误,微信接口getticket返回空字符串.");
			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
		}
		oJsonNode = JsonHelper.readTree(sResult);
		if (oJsonNode == null) {
			oJsonResult = new JsonResult(-14, "解析数据失败,解析微信接口getticket返回字符串失败.");
			return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
		}
		String sJsApiTicket = oJsonNode.get("ticket").asText();

		String sTimestamp = Long.toString(System.currentTimeMillis() / 1000); // 必填，生成签名的时间戳
		String sNonceStr = UUID.randomUUID().toString(); // 必填，生成签名的随机串

		// 注意这里参数名必须全部小写，且必须有序
		String sSignOriginal = String.format("jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s", sJsApiTicket, sNonceStr,
				sTimestamp, requestUrl);
		String sSignature = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(sSignOriginal.getBytes("UTF-8"));
			sSignature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.toString());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.toString());
		}

		Map<String, Object> oMap = new HashMap<String, Object>();
		oMap.put("appId", WxApiConfig.WX_APP_ID);
		oMap.put("timestamp", sTimestamp);
		oMap.put("nonceStr", sNonceStr);
		oMap.put("signature", sSignature);

		oJsonResult = new JsonResult(0, "成功", oMap);
		return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);

	}

	/**
	 * 方法名：byteToHex</br>
	 * 详述：字符串加密辅助方法 </br>
	 * 开发人员：souvc </br>
	 * 创建时间：2016-1-5 </br>
	 * 
	 * @param hash
	 * @return 说明返回值含义
	 * @throws 说明发生此异常的条件
	 */
	private static String byteToHex(final byte[] hash) {

		// Formatter formatter = new Formatter();
		// for (byte b : hash) {
		// formatter.format("%02x", b);
		// }
		// String result = formatter.toString();
		// formatter.close();
		// return result;

		StringBuffer hexString = new StringBuffer();
		// 字节数组转换为 十六进制 数
		for (int i = 0; i < hash.length; i++) {
			String shaHex = Integer.toHexString(hash[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexString.append(0);
			}
			hexString.append(shaHex);
		}
		return hexString.toString();
	}
}

// JsonResult oSsoJsonResult = null;
// ObjectMapper oMapper = new ObjectMapper();
// try {
// oSsoJsonResult = oMapper.readValue(sResult, JsonResult.class);
// } catch (JsonParseException e) {
// logger.error(e.toString());
// } catch (JsonMappingException e) {
// logger.error(e.toString());
// } catch (IOException e) {
// logger.error(e.toString());
// }
// if (oSsoJsonResult == null) {
// oJsonResult = new JsonResult(-11, "登录失败,解析SSO服务器返回的登录json结果失败");
// return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
// }
//
// if (oSsoJsonResult.getResultCode() < 0 || oSsoJsonResult.getData() == null) {
// oJsonResult = new JsonResult(-12, String.format("登录失败,%s",
// oSsoJsonResult.getResultMessage()));
// return new ResponseEntity<JsonResult>(oJsonResult, HttpStatus.OK);
// }