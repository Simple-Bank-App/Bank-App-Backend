package com.dev.data;

import org.springframework.data.repository.CrudRepository;

import com.dev.model.CheckingAccount;

public interface CheckingAccountRepository extends CrudRepository<CheckingAccount, Integer>{

	CheckingAccount findByAccountNumber(String string);

}
