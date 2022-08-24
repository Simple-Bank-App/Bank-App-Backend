package com.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="certificate_of_deposit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateOfDeposit {
	
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="user_id")
	int userId;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="initial_deposit")
	double initialDeposit;
	
	@Column(name="time_frame")
	int timeFrame;
	
	double interest;
	
	@Column(name="current_balance")
	double currentBalance;
	
	@Column(name="account_number")
	int accountNumber;

}
