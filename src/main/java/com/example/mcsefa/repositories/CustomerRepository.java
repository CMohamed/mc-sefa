package com.example.mcsefa.repositories;

import com.example.mcsefa.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByNameContainingAndPhoneNumberAndBankCode(String name, String phoneNumber, String bankCode);
}
