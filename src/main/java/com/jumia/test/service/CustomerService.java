package com.jumia.test.service;

import com.jumia.test.dto.CustomerDTO;
import com.jumia.test.dto.SearchCustomerDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    Page<CustomerDTO> searchOverCustomers (SearchCustomerDTO searchCustomerDTO);
}
