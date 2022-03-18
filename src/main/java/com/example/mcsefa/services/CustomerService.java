package com.example.mcsefa.services;

import com.example.mcsefa.DAO.specifications.CustomerSpecifications;
import com.example.mcsefa.dtos.CustomerDTO;
import com.example.mcsefa.dtos.CustomerFilterRequest;
import com.example.mcsefa.entities.Customer;
import com.example.mcsefa.mappers.CustomerMapper;
import com.example.mcsefa.DAO.repositories.CustomerRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.domain.Specification;
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
        return null;
    }

    public List<Customer> filterCustomersBySpecs(CustomerFilterRequest customerFilterRequest) {
        // todo: use specifications
        Specification<Customer> spec = CustomerSpecifications.phoneNumber(customerFilterRequest.getPhoneNumber());
        Specification<Customer> spec2 = CustomerSpecifications.name(customerFilterRequest.getName());
        Specification<Customer> specFinal = spec.and(spec2);
        return customerRepository.findAll( Specification.not(specFinal) );
    }

}
