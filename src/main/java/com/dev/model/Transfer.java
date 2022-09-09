package com.dev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

	private int userID;
	private String accountFrom;
	private String accountTo;
	private String amount;
}
