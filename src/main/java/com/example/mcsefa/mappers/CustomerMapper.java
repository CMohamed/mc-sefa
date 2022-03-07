package com.example.mcsefa.mappers;

import com.example.mcsefa.dtos.CustomerDTO;
import com.example.mcsefa.entities.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer modelToEntity(CustomerDTO customerDTO);

    CustomerDTO entityToModel(Customer customer);
}
