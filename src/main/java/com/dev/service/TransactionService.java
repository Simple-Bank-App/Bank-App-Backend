package com.dev.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.data.BasicInfoRepository;
import com.dev.data.CertificateOfDepositRepository;
import com.dev.data.CheckingAccountRepository;
import com.dev.data.SavingsAccountRepository;
import com.dev.model.CertificateOfDeposit;
import com.dev.model.CheckingAccount;
import com.dev.model.SavingsAccount;
import com.dev.model.Transaction;
import com.dev.model.User;

@Service
public class TransactionService {
	
	@Autowired
	BasicInfoRepository basicInfoRepo;
	
	@Autowired
	CheckingAccountRepository checkingRepo;
	
	@Autowired
	SavingsAccountRepository savingsRepo;
	
	@Autowired
	CertificateOfDepositRepository certificateOfDepRepo;

	public void initialDeposit(Transaction transaction) {
		
		//Get the first and last name based on the userId.
		Optional<User> user = basicInfoRepo.findById(transaction.getUserId());	
		
		if(transaction.isChecking() == true) {
			
			//Account to be saved.
			CheckingAccount checking = new CheckingAccount();
			
			//Account to be compared against the database.
			CheckingAccount existingChecking = new CheckingAccount();
			
			do {
				
				long randomInt = generateRandomNumber();
								
				existingChecking = checkingRepo.findByAccountNumber(Long.toString(randomInt));
				
				if(existingChecking == null) {
					checking.setAccountNumber(Long.toString(randomInt));
				}
				
			}while(existingChecking != null);
			
			checking.setUserId(transaction.getUserId());
			checking.setFirstName(user.get().getFirstName());
			checking.setLastName(user.get().getLastName());
			checking.setFundsAvailable(Double.parseDouble(transaction.getDeposit()));
			
			checkingRepo.save(checking);

			
		}else if(transaction.isSavings() == true) {
			
			//Account to be saved.
			SavingsAccount savings = new SavingsAccount();
			
			//Account to be compared against the database.
			SavingsAccount existingSavings = new SavingsAccount();
			
			do {
				
				long randomInt = generateRandomNumber();
								
				existingSavings = savingsRepo.findByAccountNumber(Long.toString(randomInt));
				
				if(existingSavings == null) {
					savings.setAccountNumber(Long.toString(randomInt));
				}
				
			}while(existingSavings != null);
			savings.setUserId(transaction.getUserId());
			savings.setFirstName(user.get().getFirstName());
			savings.setLastName(user.get().getLastName());
			savings.setFundsAvailable(Double.parseDouble(transaction.getDeposit()));
			
			savingsRepo.save(savings);
			
		}else if(transaction.isCertificateOfDeposit() == true) {
			
			//Account to be saved
			CertificateOfDeposit cd = new CertificateOfDeposit();
			
			//Account to be compared against the database.
			CertificateOfDeposit existingCD = new CertificateOfDeposit();
			
			do {
				
				long randomInt = generateRandomNumber();
								
				existingCD = certificateOfDepRepo.findByAccountNumber(Long.toString(randomInt));
				
				if(existingCD == null) {
					cd.setAccountNumber(Long.toString(randomInt));
				}
				
			}while(existingCD != null);
			
			cd.setUserId(transaction.getUserId());
			cd.setFirstName(user.get().getFirstName());
			cd.setLastName(user.get().getLastName());
			cd.setInitialDeposit(Double.parseDouble(transaction.getDeposit()));
			cd.setCurrentBalance(Double.parseDouble(transaction.getDeposit()));			
			cd.setInterest(Double.parseDouble(transaction.getDeposit()));
			cd.setTimeFrame(Integer.parseInt(transaction.getDeposit()));
			
			
		}
	}
	
	public long generateRandomNumber() {
		
		int min = 0;
		long max = 99999999;
		
		//1. Generate a random number.
		Random random = new Random();
		random.nextInt(100000000);
		
		long randomInt = (long)Math.floor(Math.random()*(max-min+1)+min);
		
		return randomInt;
	}

}
