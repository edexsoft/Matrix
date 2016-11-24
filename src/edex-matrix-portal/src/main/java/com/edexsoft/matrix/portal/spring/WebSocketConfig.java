//package com.edexsoft.matrix.portal.spring;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		registry.addHandler(new MyHandler(), "/myHandler").addInterceptors(new HttpSessionHandshakeInterceptor());
//		registry.addHandler(echoWebSocketHandler(), "/echo").setHandshakeHandler(handshakeHandler());
//	}
//	
//	@Bean
//    public WebSocketHandler myHandler() {
//        return new MyHandler();
//    }
//
//	@Bean
//	public DefaultHandshakeHandler handshakeHandler() {
//
//		WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
//		policy.setInputBufferSize(8192);
//		policy.setIdleTimeout(600000);
//
//		return new DefaultHandshakeHandler(new JettyRequestUpgradeStrategy(new WebSocketServerFactory(policy)));
//	}
//}
