package com.dev.data;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.CheckingAccount;

@Repository
public interface CheckingAccountRepository extends CrudRepository<CheckingAccount, Integer>{

	CheckingAccount findByAccountNumber(String string);

	Optional<CheckingAccount> findByUserId(int id);

}
