package com.dev.data;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dev.model.SavingsAccount;

public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Integer>{

	SavingsAccount findByAccountNumber(String string);

	Optional<SavingsAccount> findByUserId(int id);

}
