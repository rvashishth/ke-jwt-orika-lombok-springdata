package com.wolftechnica.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolftechnica.app.model.UserModel;
import com.wolftechnica.app.service.UserService;

/**
 * @author b0202777
 *
 */
@Validated
@RestController
@RequestMapping(value = "/kyc/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
		UserModel newUser = userService.createUser(userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}

	//TODO: Add msisdn validation
	@RequestMapping(value = "/fetchbymsisdn", method = RequestMethod.GET)
	public ResponseEntity<?> fetchbymsisdn(@RequestParam String msisdn) {
		UserModel newUser = userService.findUserByMsisdn(msisdn);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<?> fetchAllRoles() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.fetchAllRoles());
	}

}
