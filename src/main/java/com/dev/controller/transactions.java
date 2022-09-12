package com.dev.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.Transaction;
import com.dev.model.Transfer;
import com.dev.service.TransactionService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/transactions")
public class transactions {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/initialDeposit")
	public void initialDeposit(@RequestBody Transaction transaction) {
		transactionService.initialDeposit(transaction);
	}
	
	@PostMapping("/deposit")
	public Boolean deposit(@RequestBody Transaction transaction) {
		return transactionService.depositFunds(transaction);
	}
	
	@PostMapping("/withdraw")
	public Boolean withdraw(@RequestBody Transaction transaction) {
		return transactionService.withdrawFunds(transaction);
	}
	
	@PostMapping("/transfer")
	public String transfer(@RequestBody Transfer transfer) {
		
		System.out.println(transfer);
		
		Transaction transaction = new Transaction();
		String transferMessage = null;
		
		transaction.setUserId(transfer.getUserId());
		transaction.setAmount(transfer.getAmount());
		transaction.setAccountType(transfer.getAccountFrom());
		transaction.setWithdraw(true);
		transaction.setDeposit(false);
		
		//Withdraw
		boolean withdrawSuccess = withdraw(transaction);
		
		if(!withdrawSuccess) {
			transferMessage = "Incuficient funds, Please select another anount to transfer.";
		}
		
		transaction.setAccountType(transfer.getAccountTo());
		transaction.setWithdraw(false);
		transaction.setDeposit(true);
		
		//Then deposit
		boolean depositSuccess = deposit(transaction);
		
		if(withdrawSuccess == true && depositSuccess == true) {
			transferMessage = "Succesful transfer.";
		}
		
		return transferMessage;
		
	}
	

}
