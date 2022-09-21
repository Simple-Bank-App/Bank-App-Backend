package com.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="certificate_of_deposit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateOfDeposit {
	
	@JsonInclude()
	@Transient
	private final String accountType = "Certificate of Deposit"; 
	
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
	
	@Column(name="funds_available")
	double fundsAvailable;
	
	@Column(name="account_number")
	String accountNumber;
	

}
