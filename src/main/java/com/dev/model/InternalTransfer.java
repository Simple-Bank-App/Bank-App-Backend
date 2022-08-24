package com.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="internal_transfers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalTransfer {
	
	@Id
	@Column(name="transfer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userId;

	@Column(name="account_number_from")
	private String accountNumberFrom;
	
	@Column(name="account_number_to")
	private String accountNumberTo;
	
	@Column(name="transfer_amount")
	private double transferAmount;

}
