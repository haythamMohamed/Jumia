package com.jumia.test.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    private Long id ;

    private String name ;

    private String phone ;
}
