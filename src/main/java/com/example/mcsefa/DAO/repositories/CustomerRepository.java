package com.example.mcsefa.DAO.repositories;

import com.example.mcsefa.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    List<Customer> findAllByNameContainingAndPhoneNumberAndBankCode(String name, String phoneNumber, String bankCode);
}
