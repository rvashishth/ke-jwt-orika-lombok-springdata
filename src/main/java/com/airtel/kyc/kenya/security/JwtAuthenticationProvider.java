package com.airtel.kyc.kenya.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.airtel.kyc.kenya.model.JwtUserDetails;


/**
 * @author rvashishth
 *
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
    private JwtTokenHandler jwtTokenHandler;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
			throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        JwtUserDetails jwtUserDetails = jwtTokenHandler.validate(token);

        if (jwtUserDetails == null) {
            throw new RuntimeException("JWT Token is incorrect");
        }

        return jwtUserDetails;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
	}
}
