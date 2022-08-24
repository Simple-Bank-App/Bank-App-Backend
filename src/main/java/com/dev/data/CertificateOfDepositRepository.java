package com.dev.data;

import org.springframework.data.repository.CrudRepository;

import com.dev.model.CertificateOfDeposit;

public interface CertificateOfDepositRepository extends CrudRepository<CertificateOfDeposit, Integer>{

	CertificateOfDeposit findByAccountNumber(String string);

}
