package com.dev.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.SavingsAccount;
import com.dev.model.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer>{

}
