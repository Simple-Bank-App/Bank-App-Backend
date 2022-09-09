package com.dev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	private int userId;
	private boolean deposit;
	private boolean withdraw;
	private String amount;
	private String timeFrame;
	private String interest;
	private String accountType;
	private String accountNumber;
}
