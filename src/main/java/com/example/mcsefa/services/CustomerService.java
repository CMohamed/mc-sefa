package com.example.mcsefa.services;

import com.example.mcsefa.dtos.CustomerDTO;
import com.example.mcsefa.mappers.CustomerMapper;
import com.example.mcsefa.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::entityToModel).collect(Collectors.toList());
    }
}
