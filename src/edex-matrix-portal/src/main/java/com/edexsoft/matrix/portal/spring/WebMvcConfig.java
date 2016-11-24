//package com.edexsoft.matrix.portal.spring;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.ServletContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.accept.ContentNegotiationManager;
//import org.springframework.web.context.support.ServletContextResource;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
//import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.XmlViewResolver;
//import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { 
//		"com.edexsoft.security,"+
//        "com.edexsoft.matrix.domain,"+
//        "com.edexsoft.matrix.portal,"+
//        "com.edexsoft.matrix.portal.controllers,"+
//        "com.edexsoft.matrix.portal.api.controllers,"+
//        "com.edexsoft.matrix.portal.api.root.controllers,"+
//        "com.edexsoft.matrix.portal.web.controllers,"+
//        "com.edexsoft.matrix.portal.m.controllers,"+
//        "com.edexsoft.matrix.portal.wx.controllers,"+
//        "com.edexsoft.matrix.portal.root.controllers" })
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//	
//	private static final int CACHE_PERIOD = 31556926; // one year
//	
//	@Autowired
//	ServletContext servletContext;
//	
////	@Autowired
////    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
////
////    @PostConstruct
////    public void init() {
////        requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
////    }
//	
//	@Bean
//    public ViewResolver jspViewResolver() {        
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/areas/");
//        viewResolver.setSuffix(".jsp");        
//        return viewResolver;
//    }
//	
//	@Bean
//	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
////		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
////		resolver.setContentNegotiationManager(manager);
//		
//		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
//		XmlViewResolver r1 = new XmlViewResolver();
//		r1.setLocation(new ServletContextResource(servletContext,"/WEB-INF/spring/spreadsheet-views.xml"));
//	    resolvers.add(r1);
//	    
//	    InternalResourceViewResolver r2 = new InternalResourceViewResolver();
//	    r2.setPrefix("WEB-INF/views");
//	    r2.setSuffix(".jsp");
//	    resolvers.add(r2);
//
//	    // Create the CNVR plugging in the resolvers and the content-negotiation manager
//	    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
//	    resolver.setViewResolvers(resolvers);
//	    resolver.setContentNegotiationManager(manager);
//	    
//		
//		return resolver;
//	}
//
////    @Bean(name = "messageSource")
////    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
////        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
////        messageSource.setBasenames("classpath:com/javaetmoi/sample/web/messages");
////        messageSource.setDefaultEncoding("UTF-8");
////        return messageSource;
////    }
//
//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////		  registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
////		  registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/").setCachePeriod(31556926);
////		  registry.addResourceHandler("/resources/**").addResourceLocations("/", "classpath:/META-INF/public-web-resources/");
////		  registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/").resourceChain(true).addResolver( new VersionResourceResolver().addContentVersionStrategy("/**"));
//		
//		registry
//			.addResourceHandler("/cdn/**")
//            .addResourceLocations("/cdn/")
//            .setCachePeriod(CACHE_PERIOD);
//		
//		registry
//			.addResourceHandler("/static/images/**")
//	        .addResourceLocations("/uploads/iamges/")
//	        .setCachePeriod(CACHE_PERIOD);
//		
//		registry
//			.addResourceHandler("/MP_verify_vTtj4yW9QDOKTUma.txt")
//	        .addResourceLocations("/MP_verify_vTtj4yW9QDOKTUma.txt")
//	        .setCachePeriod(CACHE_PERIOD);
//	}
//	
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//        // Add formatters and/or converters
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // Configure the list of HttpMessageConverters to use
//    	// org.springframework.http.converter.StringHttpMessageConverter
//    	// org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
//    }
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
////        configurer
////            .setUseSuffixPatternMatch(true)
////            .setUseTrailingSlashMatch(false)
////            .setUseRegisteredSuffixPatternMatch(true)
////            .setPathMatcher(antPathMatcher())
////            .setUrlPathHelper(urlPathHelper());
//    }
//
////    @Bean
////    public UrlPathHelper urlPathHelper() {
////        //...
////    }
////
////    @Bean
////    public PathMatcher antPathMatcher() {
////        //...
////    }
//    
//	@Override
//    public void addInterceptors(InterceptorRegistry registry) {
////		  registry.addInterceptor(new LocaleInterceptor());
////        registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
////        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
////		  registry.addInterceptor(new WebAuthorizeInteceptor());	// com.edexsoft.webmvc.interceptor.WebAuthorizeInteceptor
////        registry.addInterceptor(new ApiAuthorizeInteceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");	// com.edexsoft.webmvc.interceptor.ApiAuthorizeInteceptor
////        registry.addInterceptor(new WxAuthorizeInteceptor()).addPathPatterns("/secure/*");	// com.edexsoft.webmvc.interceptor.ApiAuthorizeInteceptor
//    }
//	
//	@Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer
//			.ignoreAcceptHeader(true)
//			.defaultContentType(MediaType.TEXT_HTML)
//			.mediaType("json", MediaType.APPLICATION_JSON);
//    }
//	
//	@Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//		// forward:/home/index
////        registry.addViewController("/").setViewName("home/index");
////		registry.addViewController("/home/about"); // the about page did not required any controller
//    }
//	
//	@Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
////        registry.enableContentNegotiation(new MappingJackson2JsonView());
////        registry.jsp();
////		  registry.freeMarker().cache(false);
//    }
//	
////	@Bean
////    public FreeMarkerConfigurer freeMarkerConfigurer() {
////        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
////        configurer.setTemplateLoaderPath("/WEB-INF/");
////        return configurer;
////    }
//	
//	@Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		// Serving static files using the Servlet container's default Servlet.
////        configurer.enable();
////		  configurer.enable("myCustomDefaultServlet");
//    }
//	
////	@Override
////    @Bean
////    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
////        // Create or let "super" create the adapter
////        // Then customize one of its properties
////    }
//}
//
//
