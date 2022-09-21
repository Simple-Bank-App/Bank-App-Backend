package com.dev.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.CertificateOfDeposit;
import com.dev.model.CheckingAccount;
import com.dev.model.SavingsAccount;
import com.dev.model.User;
import com.dev.service.InfoService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/info")
public class Info {
	
	@Autowired
	InfoService infoService;
	
	@GetMapping("/accounts/{id}")
	public ArrayList<Object> getAccount(@PathVariable int id) {
				
		ArrayList<Object> accounts = new ArrayList<Object>();
		
		try {
			Optional<CheckingAccount> checkingAccount = infoService.getCheckingAccounts(id);
			
			accounts.add(checkingAccount.get());

			Optional<SavingsAccount> savingAccount = infoService.getSavingsAccounts(id);
			
			accounts.add(savingAccount.get());

			Optional<CertificateOfDeposit> cdAccount = infoService.getCDAccounts(id);
									
			accounts.add(cdAccount.get());	
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {

			Optional<CertificateOfDeposit> cdAccount = infoService.getCDAccounts(id);
									
			accounts.add(cdAccount.get());	
			
		}catch(Exception e) {
			System.out.println(e);
		}
				
		return accounts;

	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return infoService.getUser(id).get();
	}

}
