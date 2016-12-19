package com.edexsoft.matrix.portal.config;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class IPAuthConfig {
	private static Logger logger = Logger.getLogger(IPAuthConfig.class);

	private static final String RESOURCE_PROPERTIES = "ipauth.properties";

//	public static final String UPLOAD_PATH;
	public static final String WX_API_MARKETING;

	static {

		Properties properties = new Properties();

		try {
			InputStream propStreams = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(RESOURCE_PROPERTIES);
			if (propStreams != null) {
				properties.load(propStreams);
			}
		} catch (Exception e) {
			logger.error(e);
		}

//		UPLOAD_PATH = properties.getProperty("upload_path", null);
		WX_API_MARKETING = properties.getProperty("wx.api.marketing", null);
	}
}
