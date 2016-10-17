package com.edexsoft.matrix.portal.wx.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edexsoft.webmvc.HttpProxy;


@Controller("wx/wxauth")
public class WxAuthController {
	private static Logger logger = Logger.getLogger(WxAuthController.class);

	private static String wxAppId = "wx7b0499948c3815a9";
	private static String wxSecret = "6cb036d8536f0a423ddfe1f53376d63e";

	public static ModelAndView WxAuth(String returnUrl)
	{
		String sReturnUrl=null;
		try {
			sReturnUrl = URLEncoder.encode(returnUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.toString());
		}
		
		return new ModelAndView(String.format("redirect:/wx/wxauth/call?returnUrl=%s", sReturnUrl));
	}
	
	@RequestMapping("/wx/wxauth/call")
	public ModelAndView WxCall(String returnUrl) {

		// 'https://open.weixin.qq.com/connect/oauth2/authorize
		// ?appid=wx7b0499948c3815a9
		// &redirect_uri=http%3A%2F%2Fcloudkf.kaisagroup.com%2F8082%2Fwechat_api%2Foauth%2Fcode
		// &response_type=code
		// &scope=snsapi_base
		// &state=http%3A%2F%2Fcloudkf.kaisagroup.com%2F8082%2Fwechat_api%2FreceiveOpenId#wechat_redirect'

		String sCallbackUrl = "";
		String sWxAuthUrl = "";
		try {
			sCallbackUrl = String.format("http://cloudkf.kaisagroup.com/wx/wxauth/callback?returnUrl=%s",
					URLEncoder.encode(returnUrl, "UTF-8"));
			sWxAuthUrl = String.format("%s?appid=%s&redirect_uri=%s&response_type=%s&scope=%s&state=%s",
					"https://open.weixin.qq.com/connect/oauth2/authorize", wxAppId,
					URLEncoder.encode(sCallbackUrl, "UTF-8"), "code", "snsapi_base", "STATE#wechat_redirect");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.toString());
		}

		return new ModelAndView(String.format("redirect:%s", sWxAuthUrl));
	}

	@RequestMapping("/wx/wxauth/callback")
	public ModelAndView WxCallback(String code, String returnUrl) {

		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx7b0499948c3815a9&secret=6cb036d8536f0a423ddfe1f53376d63e&code="+code+"&grant_type=authorization_code"

		String sWxAuthUrl = String.format("%s?appid=%s&secret=%s&code=%s&grant_type=%s",
				"https://api.weixin.qq.com/sns/oauth2/access_token", wxAppId, wxSecret, code, "authorization_code");

		/**
		 * 
		 * 通过code换取网页授权access_token和openid的返回数据，正确时返回的JSON数据包如下： {
		 * "access_token":"ACCESS_TOKEN", "expires_in":7200,
		 * "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE",
		 * "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL" }
		 * 其中access_token可用于获取共享收货地址 openid是微信支付jsapi支付接口统一下单时必须的参数
		 * 更详细的说明请参考网页授权获取用户基本信息：http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
		 * 
		 * @失败时抛异常WxPayException
		 */
		HttpProxy oHttpProxy = HttpProxy.getProxy();
		String sResult = null;
		try {
			sResult = oHttpProxy.get(sWxAuthUrl, "UTF-8");
		} catch (IOException e) {
			logger.error(e.toString());
		}

		if (sResult == null || sResult.isEmpty()) {
			return null;//
		}
		
		ObjectMapper oObjectMapper = new ObjectMapper();
		JsonNode oJsonNode = null;
		try {
			oJsonNode = oObjectMapper.readTree(sResult);
		} catch (JsonProcessingException e) {
			logger.error(e.toString());
		} catch (IOException e) {
			logger.error(e.toString());
		}
		if (oJsonNode == null) {
			return null;
		}

		String sAccessToken = oJsonNode.get("access_token").asText();
		String sWxOpenId = oJsonNode.get("openid").asText();

		String sReturnUrl = String.format(returnUrl, sWxOpenId, sAccessToken);

		return new ModelAndView(String.format("redirect:%s", sReturnUrl));
	}
}
