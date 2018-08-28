package com.us.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.us.app.model.LoginModel;
import com.us.app.security.JwtTokenHandler;
import com.us.app.service.UserService;

/**
 * @author b0202777
 *
 */
@Validated
@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private JwtTokenHandler jwtTokenHandler;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> login(@Valid @RequestBody LoginModel loginModel) {
		if(!userService.validateUserCredentials(loginModel)){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
		}
		String token = jwtTokenHandler.generate(loginModel.getUsername(), loginModel.getRole());
		return ResponseEntity.status(HttpStatus.OK).body(token);
	}
}
