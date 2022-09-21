package com.dev.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.CertificateOfDeposit;

@Repository
public interface CertificateOfDepositRepository extends CrudRepository<CertificateOfDeposit, Integer>{

	CertificateOfDeposit findByAccountNumber(String string);

	Optional<CertificateOfDeposit> findByUserId(int id);

}
