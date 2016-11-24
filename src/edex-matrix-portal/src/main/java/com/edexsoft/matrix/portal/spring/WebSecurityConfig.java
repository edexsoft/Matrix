package com.edexsoft.matrix.portal.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("ExexUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
	
//	@Bean
//	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//	public UserDetails authenticatedUserDetails() {
//		SecurityContextHolder.getContext().getAuthentication();
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication != null) {
//			if (authentication instanceof UsernamePasswordAuthenticationToken) {
//				return (UserDetails) authentication.getPrincipal();
//			}
//			if (authentication instanceof RememberMeAuthenticationToken) {
//				return (UserDetails) authentication.getPrincipal();
//			}
//		}
//		return null;
//	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin/**")
				.access("hasRole('ADMIN')").antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')").and()
				.formLogin().loginPage("/login").usernameParameter("ssoId").passwordParameter("password").and().csrf()
				.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}