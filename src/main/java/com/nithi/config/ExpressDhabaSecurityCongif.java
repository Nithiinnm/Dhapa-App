package com.nithi.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
public class ExpressDhabaSecurityCongif extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("admin","user");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("Inside Configur Overide");
		http.authorizeRequests().antMatchers("/deleteMenuItem","/updateMenuItem/**","/save-menu","/showAddMenuPage")
		.authenticated().and().formLogin();
		
	}
}
