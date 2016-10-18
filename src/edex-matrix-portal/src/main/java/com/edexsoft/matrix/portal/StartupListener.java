package com.edexsoft.matrix.portal;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.Aware;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

	private Logger logger = LogManager.getLogger(StartupListener.class);

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		ApplicationContext oContext = event.getApplicationContext();
		logger.info(String.format("app context %s startup.", oContext.getDisplayName()));
		if (oContext.getParent() == null) {
			return;
		}

		logger.info(String.format("app context %s startup.", oContext.getDisplayName()));
		
		// 
//		WxApiConfig.loadProps();
	}
}
