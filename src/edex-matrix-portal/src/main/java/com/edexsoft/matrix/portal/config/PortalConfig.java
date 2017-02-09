package com.edexsoft.matrix.portal.config;

import java.util.Properties;

import com.edexsoft.framework.config.PropertiesHelper;

public class PortalConfig {

	private static final String RESOURCE_PROPERTIES = "portal.properties";

	// public static final String UPLOAD_PATH;
	public static final String WEBAPP_ROOT_KEY;

	static {
		Properties properties = PropertiesHelper.load(RESOURCE_PROPERTIES);

		// UPLOAD_PATH = properties.getProperty("upload_path", null);
		WEBAPP_ROOT_KEY = properties.getProperty("webapp.root.key", null);
	}

}
