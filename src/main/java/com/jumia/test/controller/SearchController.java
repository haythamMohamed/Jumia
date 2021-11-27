package com.jumia.test.controller;

import com.jumia.test.dto.CustomerDTO;
import com.jumia.test.dto.SearchCustomerDTO;
import com.jumia.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/customer")
public class SearchController {

    @Autowired
    CustomerService customerService ;

    @PostMapping(path = "/get-all")
    public Page<CustomerDTO> getListOfCustomers (@RequestBody SearchCustomerDTO customerDTO){
       return customerService.searchOverCustomers(customerDTO);
    }
}
