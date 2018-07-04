package com.airtel.kyc.kenya.security;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.airtel.kyc.kenya.model.JwtUserDetails;
import com.airtel.kyc.kenya.util.beans.KYCContants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * This class uses JJWT api by stormpath
 * 
 * @author b0202777
 */
@Component
public class JwtTokenHandler {
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Value("${jwt.validity}")
	private long jwtValidity;
	
    public String generate(String username, String role) {
        Claims claims = Jwts.claims()
                .setSubject(username);
        claims.put(KYCContants.JWT_ROLE, role);

        return Jwts.builder()
        		.setExpiration(new Date(System.currentTimeMillis()+jwtValidity))
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public JwtUserDetails validate(String token) {
    	System.out.println("==========token: "+token);
    	JwtUserDetails jwtUserDetails = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUserDetails = new JwtUserDetails(body.getSubject(), token,
                    (String) body.get("role"));
            System.out.println("after validation=================="+jwtUserDetails.getUserName());
            System.out.println("after validation=================="+jwtUserDetails.getPassword());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return jwtUserDetails;
    }
}
