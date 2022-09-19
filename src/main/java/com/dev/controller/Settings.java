package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.User;
import com.dev.service.InfoService;
import com.dev.service.SettingsService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/settings")
public class Settings {
	
	@Autowired
	SettingsService settingsService;
	
	@Autowired
	InfoService infoService;
	
	@PostMapping("/check-password")
	public boolean checkPassword(@RequestBody User user){
		return settingsService.checkPassword(user);
	}
	
	@PostMapping("/change-password")
	public boolean changePassword(@RequestBody User user) {
		return settingsService.changePassword(user);
	}
	
	
	@PostMapping("/change-email")
	public boolean changeEmail(@RequestBody User user) {
		return settingsService.changeEmail(user);
	}
	
	@PostMapping("/change-username")
	public boolean changeUsername(@RequestBody User user) {
		return settingsService.changeUsername(user);
	}

}
