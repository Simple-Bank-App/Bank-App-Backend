package com.dev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wire {
	
	private int userId;
	private String internalAccountNumber;
	private String bankName;
	private String bankAddress;
	private String externalAccountNumber;
	private String routingNumber;
	private String amount;

}
