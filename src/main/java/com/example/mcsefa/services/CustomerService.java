package com.example.mcsefa.services;

import com.example.mcsefa.dtos.CustomerDTO;
import com.example.mcsefa.dtos.CustomerFilterRequest;
import com.example.mcsefa.entities.Customer;
import com.example.mcsefa.mappers.CustomerMapper;
import com.example.mcsefa.repositories.CustomerRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::entityToModel).collect(Collectors.toList());
    }

    public Long save(CustomerDTO customerDTO) {
        return customerRepository.save(customerMapper.modelToEntity(customerDTO)).getId();
    }

    public List<CustomerDTO> filterCustomers(CustomerFilterRequest customerFilterRequest) {
        List<Customer> filteredList = customerRepository.findAllByNameContainingAndPhoneNumberAndBankCode(customerFilterRequest.getName(),
                customerFilterRequest.getPhoneNumber(),
                customerFilterRequest.getBankCode());
        return filteredList.stream().map(customerMapper::entityToModel).collect(Collectors.toList());
    }

}
