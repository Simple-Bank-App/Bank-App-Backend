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
	public void transfer(@RequestBody Transfer transfer) {
		
		//Withdraw
		
		//Then deposit
	}
	

}
