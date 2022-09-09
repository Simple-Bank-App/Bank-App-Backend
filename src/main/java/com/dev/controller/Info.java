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
			Optional<SavingsAccount> savingAccount = infoService.getSavingsAccounts(id);
			Optional<CertificateOfDeposit> cdAccount = infoService.getCDAccounts(id);
			
			if(checkingAccount.get() != null) {
				accounts.add(checkingAccount.get());
			}
			
			if(savingAccount.get() != null) {
				accounts.add(savingAccount.get());
			}
			
			if(cdAccount.get() != null) {
				accounts.add(cdAccount.get());	
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		return accounts;

	}

}
