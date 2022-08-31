package com.dev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	private int userId;
	private String deposit;
	private String withdraw;
	private String timeFrame;
	private String interest;
	private boolean checking;
	private boolean savings;
	private boolean certificateOfDeposit;

}
