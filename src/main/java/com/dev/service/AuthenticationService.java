package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.data.AddressRepository;
import com.dev.data.BasicInfoRepository;
import com.dev.data.EmploymentRepository;
import com.dev.model.Login;
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
		
	
	public boolean loginService(Login login) {
		
		boolean validUser = false;
		
		User foundUser = basicInfoRepository.findByUsername(login.getUsername());
		if(login.getPassword().equals(foundUser.getPassword())){
			validUser = true;
		}
		
		return validUser;
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
