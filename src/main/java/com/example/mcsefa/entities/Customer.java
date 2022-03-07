package com.example.mcsefa.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Customer {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
