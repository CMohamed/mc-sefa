package com.example.mcsefa.controllers;

import com.example.mcsefa.dtos.CustomerDTO;
import com.example.mcsefa.dtos.CustomerFilterRequest;
import com.example.mcsefa.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/filter")
    public ResponseEntity<List<CustomerDTO>> getFilteredCustomers(@RequestBody CustomerFilterRequest customerFilterRequest) {
        return ResponseEntity.ok(customerService.filterCustomers(customerFilterRequest));
    }

    @GetMapping("")
    public  ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.save(customerDTO));
    }
}
