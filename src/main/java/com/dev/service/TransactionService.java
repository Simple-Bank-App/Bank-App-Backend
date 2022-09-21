package com.dev.service;

import java.util.ArrayList;
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
		
		System.out.println(transaction);
		
		if(transaction.getAccountType().equals("Checking")) {
			
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
			checking.setFundsAvailable(Double.parseDouble(transaction.getAmount()));
			
			checkingRepo.save(checking);

			
		}else if(transaction.getAccountType().equals("Savings")) {
			
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
			savings.setFundsAvailable(Double.parseDouble(transaction.getAmount()));
			
			savingsRepo.save(savings);
			
		}
		//CHECK HERE FOR POTENTIAL ERRORS!!!
		else if(transaction.getAccountType().equals("Certificate of Deposit")) {
			
			//Account to be saved
			CertificateOfDeposit cd = new CertificateOfDeposit();
			
			//Account to be compared against the database.
			CertificateOfDeposit existingCD = new CertificateOfDeposit();
			
			long randomInt  = 0;
						
			do {
				
				//Generate a random number.
				randomInt = generateRandomNumber();
								
				//Check if this random number exists in the database.
				existingCD = certificateOfDepRepo.findByAccountNumber(Long.toString(randomInt));
				
				//If it does't exist in the database, then set it.
				if(existingCD == null) {
					cd.setAccountNumber(Long.toString(randomInt));
				}
				
			}while(existingCD != null);
			
			cd.setUserId(transaction.getUserId());
			cd.setFirstName(user.get().getFirstName());
			cd.setLastName(user.get().getLastName());
			cd.setInitialDeposit(Double.parseDouble(transaction.getAmount()));
			cd.setCurrentBalance(Double.parseDouble(transaction.getAmount()));			
			cd.setInterest(Double.parseDouble(transaction.getInterest()));
			cd.setTimeFrame(Integer.parseInt(transaction.getTimeFrame()));
						
			certificateOfDepRepo.save(cd);
			
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

	public boolean withdrawFunds(Transaction transaction) {
		
		boolean withdrawComplete = false;
		
		if(transaction.getAccountType().equals("Checking")) {
			
			Optional<CheckingAccount> account = checkingRepo.findByUserId(transaction.getUserId());
			
			CheckingAccount checkingAccount = account.get();
			
			double fundsAvailable = checkingAccount.getFundsAvailable();
			
			if(Double.parseDouble(transaction.getAmount()) < fundsAvailable) {
				
				fundsAvailable -= Double.parseDouble(transaction.getAmount());
				
				checkingAccount.setFundsAvailable(fundsAvailable);
				
				checkingRepo.save(checkingAccount);

				withdrawComplete = true;
				
			}else {
				
				//Insufficient funds.
				withdrawComplete = false;
				
			}
			
			
			
		}else if(transaction.getAccountType().equals("Savings")) {
			
			Optional<SavingsAccount> account = savingsRepo.findByUserId(transaction.getUserId());
			
			SavingsAccount savingsAccount = account.get();
			
			double fundsAvailable = savingsAccount.getFundsAvailable();
			
			if(Double.parseDouble(transaction.getAmount()) < fundsAvailable) {
				
				fundsAvailable -= Double.parseDouble(transaction.getAmount());
				
				savingsAccount.setFundsAvailable(fundsAvailable);
				
				savingsRepo.save(savingsAccount);

				withdrawComplete = true;
				
			}else {
				
				//Insufficient funds.
				withdrawComplete = false;
				
			}

			
		}
		
		return withdrawComplete;
		
	}

	public boolean depositFunds(Transaction transaction) {
		
		boolean depositComplete = false;
		
		if(transaction.getAccountType().equals("Checking")) {
			
			Optional<CheckingAccount> account = checkingRepo.findByUserId(transaction.getUserId());
			
			CheckingAccount checkingAccount = account.get();
						
			System.out.println(checkingAccount);
			
			double fundsAvailable = checkingAccount.getFundsAvailable();
							
			fundsAvailable += Double.parseDouble(transaction.getAmount());
				
			checkingAccount.setFundsAvailable(fundsAvailable);
				
			checkingRepo.save(checkingAccount);

			depositComplete = true;
										
			
		}else if(transaction.getAccountType().equals("Savings")) {
			
			Optional<SavingsAccount> account = savingsRepo.findByUserId(transaction.getUserId());
			
			SavingsAccount savingsAccount = account.get();
			
			double fundsAvailable = savingsAccount.getFundsAvailable();
			
			if(Double.parseDouble(transaction.getAmount()) < fundsAvailable) {
				
				fundsAvailable += Double.parseDouble(transaction.getAmount());
				
				savingsAccount.setFundsAvailable(fundsAvailable);
				
				savingsRepo.save(savingsAccount);

				depositComplete = true;
				
			}else {
				
				//Insufficient funds.
				depositComplete = false;
				
			}

			
		}else if(transaction.getAccountType().equals("Certificate of Deposit")) {
			
			Optional<CertificateOfDeposit> account = certificateOfDepRepo.findByUserId(transaction.getUserId());
			
			CertificateOfDeposit cd = account.get();
			
			double fundsAvailable = cd.getCurrentBalance();
			
			if(Double.parseDouble(transaction.getAmount()) < fundsAvailable) {
				
				fundsAvailable += Double.parseDouble(transaction.getAmount());
				
				cd.setCurrentBalance(fundsAvailable);
				
				certificateOfDepRepo.save(cd);

				depositComplete = true;
				
			}else {
				
				//Insufficient funds.
				depositComplete = false;
				
			}

		}
		
		return depositComplete;
		
	}

}
