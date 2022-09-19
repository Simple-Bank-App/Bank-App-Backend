package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.data.UserRepository;
import com.dev.model.User;

@Service
public class SettingsService {
	
	@Autowired
	InfoService infoService;
	
	@Autowired
	UserRepository userRepo;
	
	public boolean checkPassword(User user) {
		
		boolean validPassword = false;
		
		User foundUser = infoService.getUser(user.getId()).get();
		
		if(foundUser.getPassword().equals(user.getPassword())) {
			validPassword = true;
		}
		
		return validPassword;
	}

	public boolean changeEmail(User user) {
		
		boolean emailChanged = false;
		
		User foundUser = infoService.getUser(user.getId()).get();
		
		if(foundUser != null) {
			foundUser.setEmail(user.getEmail());
			
			userRepo.save(foundUser);
			
			emailChanged = true;
		}
		
		
		return emailChanged;		
	}
	
	public boolean changeUsername(User user) {
		
		boolean usernameChanged = false;
		
		User foundUser = infoService.getUser(user.getId()).get();
		
		if(foundUser != null) {
			foundUser.setUsername(user.getUsername());
			
			userRepo.save(foundUser);	
		}
		
		return usernameChanged;		
	}

	public boolean changePassword(User user) {
		
		boolean passwordChanged = false;
		
		User foundUser = infoService.getUser(user.getId()).get();
		
		String oldPassword = foundUser.getPassword();
		
		foundUser.setPassword(user.getPassword());
		
		String newPassword = foundUser.getPassword();
		
		if(!oldPassword.equals(newPassword)) {
			userRepo.save(foundUser);
		}
		
		return passwordChanged;
	}

	public boolean changePhoneNumber(User user) {
		
		boolean numberChanged = false;
		
		User foundUser = infoService.getUser(user.getId()).get();
		
		String oldNumber = foundUser.getPhoneNumber();
		
		foundUser.setPhoneNumber(user.getPhoneNumber());
		
		String newNumber = foundUser.getPhoneNumber();
		
		if(!oldNumber.equals(newNumber)) {
			numberChanged = true;
			userRepo.save(foundUser);
		}
		
		return numberChanged;
		
	}

}
