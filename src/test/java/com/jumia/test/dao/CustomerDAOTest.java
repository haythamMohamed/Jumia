package com.jumia.test.dao;

import com.jumia.test.dto.SearchCustomerDTO;
import com.jumia.test.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class CustomerDAOTest {

    @Autowired CustomerDAO customerDAO ;

    @Test
    public void searchOverCustomers() {
        List<Customer> customers = customerDAO.searchOverCustomer(new SearchCustomerDTO());

        Assertions.assertNotNull(customers);
        Assertions.assertEquals(customers.size(),41);
    }
}
