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

import com.edexsoft.matrix.portal.spring.security.EdexAuthenticationSuccessHandler;
import com.edexsoft.security.EdexAuthenticationProvider;

//@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	@Qualifier("ExexUserDetailsService")
//	UserDetailsService userDetailsService;

	@Autowired
	@Qualifier("EdexAuthenticationProvider")
    private EdexAuthenticationProvider edexAuthenticationProvider;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
//	    auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
		// auth.userDetailsService(userDetailsService);
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.authenticationProvider(edexAuthenticationProvider);
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
		web.ignoring().antMatchers("/cdn/**");
		web.ignoring().antMatchers("/static/**");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
//				.antMatchers("/", "/home").permitAll()
//				.antMatchers("/account/login").permitAll()
				.antMatchers("/api/root/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/root/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/member/**").access("hasRole('ROLE_MEMBER')")
				.antMatchers("/api/member/**").access("hasRole('ROLE_MEMBER')")
//				.anyRequest().permitAll()
		.and()
			.formLogin()
				.loginPage("/account/login")
				.usernameParameter("account")
				.passwordParameter("password")
//				.loginProcessingUrl("/account/login2")
				.failureUrl("/account/login?error=access_denied")
				.successHandler(new EdexAuthenticationSuccessHandler())
				//.successForwardUrl(forwardUrl)
		.and()
			.logout()
				.logoutUrl("/account/logout")
				.logoutSuccessUrl("/account/login")
		.and()
			.exceptionHandling()
			.accessDeniedPage("/Access_Denied")
//		.and().httpBasic()
		.and()
			.csrf().disable();
	}
}