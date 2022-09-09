package com.dev.data;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dev.model.CertificateOfDeposit;

public interface CertificateOfDepositRepository extends CrudRepository<CertificateOfDeposit, Integer>{

	CertificateOfDeposit findByAccountNumber(String string);

	Optional<CertificateOfDeposit> findByUserId(int id);

}
