package com.dev.data;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dev.model.CheckingAccount;

public interface CheckingAccountRepository extends CrudRepository<CheckingAccount, Integer>{

	CheckingAccount findByAccountNumber(String string);

	Optional<CheckingAccount> findByUserId(int id);

}
