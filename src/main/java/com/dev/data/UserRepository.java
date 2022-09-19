package com.dev.data;

import org.springframework.data.repository.CrudRepository;

import com.dev.model.SavingsAccount;
import com.dev.model.User;

public interface UserRepository  extends CrudRepository<User, Integer>{

}
