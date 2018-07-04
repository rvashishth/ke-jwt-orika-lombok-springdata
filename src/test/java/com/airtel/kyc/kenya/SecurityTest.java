package com.airtel.kyc.kenya;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class SecurityTest {

	@Test
	public void encryptDecryptPasswordTest(){
		String rawPassword = "abcd1234";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(rawPassword);
		Assert.assertTrue(encoder.matches(rawPassword, encodedPassword));
	}
}
