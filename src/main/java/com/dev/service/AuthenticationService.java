package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.data.AddressRepository;
import com.dev.data.BasicInfoRepository;
import com.dev.data.EmploymentRepository;
import com.dev.data.LoginResponse;
import com.dev.model.LoginCredentials;
import com.dev.model.User;
import com.dev.model.UserAddress;
import com.dev.model.UserEmployment;

@Service
public class AuthenticationService {
	
	@Autowired
	BasicInfoRepository basicInfoRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	EmploymentRepository employmentRepository;
		
	
	public LoginResponse loginService(LoginCredentials login) {
		
		LoginResponse response = new LoginResponse();
		
		boolean validUser = false;
		
		System.out.println("Username: " + login.toString());
		
		User foundUser = basicInfoRepository.findByUsername(login.getUsername());
		if(login.getPassword().equals(foundUser.getPassword())){
			validUser = true;
			response.setAuthenticated(validUser);
			response.setId(foundUser.getId());
		}
		
		return response;
	}
	
	public User storeUSer(User user) {
		return basicInfoRepository.save(user);
	}
	
	public UserAddress storeAddress(UserAddress userAddress) {	
		return (UserAddress) addressRepository.save(userAddress);
	}
	
	public UserEmployment storeEmployment(UserEmployment userEmployment) {
		return (UserEmployment) employmentRepository.save(userEmployment);
	}

}
