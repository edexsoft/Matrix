package com.edexsoft.matrix.portal.config;

import java.util.Properties;

import com.edexsoft.framework.config.PropertiesHelper;


public class IPAuthConfig {

	private static final String RESOURCE_PROPERTIES = "ipauth.properties";

	public static final String WX_API_MARKETING;
	public static final String LOCAL;

	static {
		Properties properties = PropertiesHelper.load(RESOURCE_PROPERTIES);

		LOCAL=properties.getProperty("local", null);
		WX_API_MARKETING = properties.getProperty("wx.api.marketing", null);
	}
	
}
