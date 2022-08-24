package com.dev.data;

import org.springframework.data.repository.CrudRepository;

import com.dev.model.SavingsAccount;

public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Integer>{

	SavingsAccount findByAccountNumber(String string);

}
