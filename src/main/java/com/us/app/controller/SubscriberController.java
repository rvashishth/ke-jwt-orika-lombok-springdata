package com.us.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.us.app.constants.SubscriberIDType;
import com.us.app.constants.SubscriberType;
import com.us.app.model.SubscriberModel;
import com.us.app.service.SubscriberService;

/**
 * @author b0202777
 *
 */
@Validated
@RestController
@RequestMapping(value = "/kyc/subscriber")
public class SubscriberController {

	@Autowired
	private SubscriberService subscriberService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody SubscriberModel userModel) {
		SubscriberModel newUser = subscriberService.createUser(userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	
	
	/**
	 * This api is only applicable 
	 * @param userModel
	 * @return
	 */
	@RequestMapping(value = "/ussd/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUserViaUSSD(@RequestBody SubscriberModel userModel) {
		//ID no, Name, MSisdn, sim serial no, county, occupation
		
		userModel.setSubscriberType(SubscriberType.KenyanCitizen);
		userModel.setIdType(SubscriberIDType.NationalId);
		SubscriberModel newUser = subscriberService.createUser(userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
}
