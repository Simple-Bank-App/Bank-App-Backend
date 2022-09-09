package com.dev.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.data.CertificateOfDepositRepository;
import com.dev.data.CheckingAccountRepository;
import com.dev.data.SavingsAccountRepository;
import com.dev.model.CertificateOfDeposit;
import com.dev.model.CheckingAccount;
import com.dev.model.SavingsAccount;

@Service
public class InfoService {
	
	@Autowired
	CheckingAccountRepository checkingRepo;
	
	@Autowired
	SavingsAccountRepository savingsRepo;
	
	@Autowired
	CertificateOfDepositRepository certificateOfDepRepo;

	public Optional<CheckingAccount> getCheckingAccounts(int id) {
		
		Optional<CheckingAccount> checkingAccount = null;
		
		checkingAccount = checkingRepo.findByUserId(id);
		
		return checkingAccount;
	}

	public Optional<SavingsAccount> getSavingsAccounts(int id) {
		
		Optional<SavingsAccount> savingsAccount = null;
		
		savingsAccount = savingsRepo.findByUserId(id);
		
		return savingsAccount;
	}

	public Optional<CertificateOfDeposit> getCDAccounts(int id) {
		
		Optional<CertificateOfDeposit> cd = null;
				
		cd = certificateOfDepRepo.findByUserId(id);
		
		return cd;
	}

}
