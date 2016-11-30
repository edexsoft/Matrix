//package com.edexsoft.matrix.portal.spring;
//
//import javax.servlet.FilterRegistration;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.filter.HttpPutFormContentFilter;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.util.IntrospectorCleanupListener;
//import org.springframework.web.util.WebAppRootListener;
//
//import com.edexsoft.matrix.portal.spring.AppConfig;
//
//// web.xml
//public class PortalWebAppInitializer implements WebApplicationInitializer {
//
//	private Logger logger = LogManager.getLogger(PortalWebAppInitializer.class);
//	
//	private static int times=0;
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		logger.info(String.format("WebAppInitializer startup, times: %s", ++times));
//
//		// Create the 'root' Spring application context
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		
//		// 两者二选一
//		// @Configuration
//		// AnnotationConfigWebApplicationContext.register(FooConfig.class)
//
//		rootContext.register(AppConfig.class);
//		rootContext.register(WebMvcConfig.class);
//		rootContext.register(WebSecurityConfig.class);
//		rootContext.setServletContext(servletContext);
//
//		// Manage the lifecycle of the root application context
//		servletContext.addListener(new ContextLoaderListener(rootContext));		
//		servletContext.addListener(new IntrospectorCleanupListener());
//		servletContext.addListener(new WebAppRootListener());		
//
//		FilterRegistration.Dynamic httpPutFormContentFilter = servletContext.addFilter("httpPutFormContentFilter", HttpPutFormContentFilter.class);
//		httpPutFormContentFilter.addMappingForUrlPatterns(null, false, "/*");
//		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
//		characterEncodingFilter.addMappingForUrlPatterns(null, true, "/*");
//		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
//		characterEncodingFilter.setInitParameter("forceEncoding", "true");		
//		
////		servletContext
////			.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
////			.addMappingForUrlPatterns(null, false, "/*");
//
//		// Register and map the dispatcher servlet
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",new DispatcherServlet(rootContext));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//	}	
//}
