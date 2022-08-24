package com.dev.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.User;

@Repository
public interface BasicInfoRepository extends CrudRepository<User, Integer>{
	
	public User findByUsername(String username);
	
	

}
