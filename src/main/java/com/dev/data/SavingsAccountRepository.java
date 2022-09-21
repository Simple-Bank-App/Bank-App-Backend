package com.dev.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.SavingsAccount;

@Repository
public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Integer>{

	SavingsAccount findByAccountNumber(String string);

	Optional<SavingsAccount> findByUserId(int id);

}
