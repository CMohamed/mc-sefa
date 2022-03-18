package com.example.mcsefa.mappers;

import com.example.mcsefa.dtos.CustomerDTO;
import com.example.mcsefa.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

    Customer modelToEntity(CustomerDTO customerDTO);

    CustomerDTO entityToModel(Customer customer);
}
