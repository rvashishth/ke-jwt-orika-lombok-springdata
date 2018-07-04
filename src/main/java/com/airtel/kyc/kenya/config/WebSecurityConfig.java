package com.airtel.kyc.kenya.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.airtel.kyc.kenya.security.JwtAuthenticationEntryPoint;
import com.airtel.kyc.kenya.security.JwtAuthenticationProvider;
import com.airtel.kyc.kenya.security.JwtAuthenticationTokenFilter;
import com.airtel.kyc.kenya.security.JwtSuccessHandler;


/**
 * @author rvashishth
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private JwtAuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	
	@Autowired
	private JwtSuccessHandler jwtSuccessHandler;
	 
	//TODO: How roles can be updated dynamically without code change
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.csrf().disable()
				.authorizeRequests()
					.antMatchers("/login","/actuator/**","/swagger-ui.html"
							,"/webjars/**","/swagger-resources/**","/v2/**").permitAll()
					.antMatchers(HttpMethod.OPTIONS, "/*").permitAll() 
					/* this can be alternatively done using //@EnableGlobalMethodSecurity(prePostEnabled = true) on this class
					 * and adding //@PreAuthorize("hasAnyRole('USER')") at restController method level
					 */
					//.antMatchers("/kyc/user/findbyemail").hasAnyRole("USER")
					//.antMatchers("/kyc/user/create").hasAnyRole("ADMIN") 
					//.anyRequest().authenticated() /* Ensures that any request to our application requires the user to be authenticated */
					.anyRequest().permitAll() //TODO: remove security bypass
				.and()
				.exceptionHandling().authenticationEntryPoint(entryPoint)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		httpSecurity.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		httpSecurity.headers().cacheControl();
	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilter() {
		JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(jwtSuccessHandler);
		//filter.setRequiresAuthenticationRequestMatcher(requestMatcher);
		return filter;
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}

}
