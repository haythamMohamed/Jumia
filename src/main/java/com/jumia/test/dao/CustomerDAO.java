package com.jumia.test.dao;

import com.jumia.test.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> , CustomCustomerDAO {

}
