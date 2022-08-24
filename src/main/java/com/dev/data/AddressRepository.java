package com.dev.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.UserAddress;

@Repository
public interface AddressRepository extends CrudRepository<UserAddress, Integer>{

}
