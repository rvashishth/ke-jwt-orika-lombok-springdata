package com.wolftechnica.app.util.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CustomBeans {

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
}
