package com.dev.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.UserEmployment;

@Repository
public interface EmploymentRepository extends CrudRepository<UserEmployment, Integer>{

}
