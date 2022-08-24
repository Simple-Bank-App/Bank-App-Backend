package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.Login;
import com.dev.model.User;
import com.dev.model.UserAddress;
import com.dev.model.UserEmployment;
import com.dev.service.AuthenticationService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/authentication")
public class authentication {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public boolean login(@RequestBody Login login) {
		return authenticationService.loginService(login);
	}
	
	@PostMapping("/registerBasicInfo")
	public ResponseEntity<User> registerUserBasicInfo(@RequestBody User user) {
		return ResponseEntity.ok(authenticationService.storeUSer(user));
	}
	
	@PostMapping("/registerUserAddress")
	public ResponseEntity<UserAddress> registerUserAddress(@RequestBody UserAddress userAddress) {
		return ResponseEntity.ok(authenticationService.storeAddress(userAddress));
	}
	
	@PostMapping("/registerUserEmployment")
	public ResponseEntity<UserEmployment> registerUserEmploymentInfo(@RequestBody UserEmployment userEmployment) {
		return ResponseEntity.ok(authenticationService.storeEmployment(userEmployment));
	}

}
