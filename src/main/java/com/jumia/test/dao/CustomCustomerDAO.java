package com.jumia.test.dao;

import com.jumia.test.dto.SearchCustomerDTO;
import com.jumia.test.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomCustomerDAO {

    List<Customer> searchOverCustomer (SearchCustomerDTO searchCustomerDTO);
}
