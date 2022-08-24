package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.Transaction;
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
	public void deposit() {
		
	}
	
	@PostMapping("/withdraw")
	public void withdraw() {
		
	}

}
