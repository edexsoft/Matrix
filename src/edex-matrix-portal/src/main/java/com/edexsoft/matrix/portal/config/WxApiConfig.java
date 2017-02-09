package com.edexsoft.matrix.portal.config;

import java.util.Properties;

import com.edexsoft.framework.config.PropertiesHelper;

// JASYPT

public class WxApiConfig {

	private static final String RESOURCE_PROPERTIES = "wxapi.properties";
	
	public static final String WX_APP_ID;
	public static final String WX_SECRET;
	
	static {
		Properties properties = PropertiesHelper.load(RESOURCE_PROPERTIES);

		WX_APP_ID = properties.getProperty("appid", null);
		WX_SECRET = properties.getProperty("secret", null);
	}

}
