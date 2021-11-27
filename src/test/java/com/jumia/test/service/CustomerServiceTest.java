package com.jumia.test.service;

import com.jumia.test.dto.CustomerDTO;
import com.jumia.test.dto.SearchCustomerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService ;

    @Test
    public void getAllCustomersDTO (){
        SearchCustomerDTO searchCustomerDTO = new SearchCustomerDTO();
        searchCustomerDTO.setPageSize(10);
        searchCustomerDTO.setPageNumber(0);
       Page<CustomerDTO> customerDTOPage =  customerService.searchOverCustomers(searchCustomerDTO);

        Assertions.assertNotNull(customerDTOPage);
        Assertions.assertEquals(customerDTOPage.getTotalElements(),41);
        Assertions.assertEquals(customerDTOPage.getTotalPages(),5);
    }

    @Test
    public void getAllCustomersDTOByState (){
        SearchCustomerDTO searchCustomerDTO = new SearchCustomerDTO();
        searchCustomerDTO.setState(true);
        searchCustomerDTO.setPageSize(10);
        searchCustomerDTO.setPageNumber(0);
        Page<CustomerDTO> customerDTOPage =  customerService.searchOverCustomers(searchCustomerDTO);

        Assertions.assertNotNull(customerDTOPage);
        Assertions.assertEquals(customerDTOPage.getTotalElements(),27);
        Assertions.assertEquals(customerDTOPage.getTotalPages(),3);
    }

    @Test
    public void getAllCustomerByCountry (){
        SearchCustomerDTO searchCustomerDTO = new SearchCustomerDTO();
        searchCustomerDTO.setCountry("Cameroon");
        searchCustomerDTO.setPageSize(10);
        searchCustomerDTO.setPageNumber(0);
        Page<CustomerDTO> customerDTOPage =  customerService.searchOverCustomers(searchCustomerDTO);

        Assertions.assertNotNull(customerDTOPage);
        Assertions.assertEquals(customerDTOPage.getTotalElements(),10);
        Assertions.assertEquals(customerDTOPage.getTotalPages(),1);
    }

    @Test
    public void getAllCustomerByCountryAndState (){
        SearchCustomerDTO searchCustomerDTO = new SearchCustomerDTO();
        searchCustomerDTO.setCountry("Cameroon");
        searchCustomerDTO.setState(true);
        searchCustomerDTO.setPageSize(10);
        searchCustomerDTO.setPageNumber(0);

        Page<CustomerDTO> customerDTOPage =  customerService.searchOverCustomers(searchCustomerDTO);

        Assertions.assertNotNull(customerDTOPage);

        Assertions.assertEquals(customerDTOPage.getTotalElements(),7);
        Assertions.assertEquals(customerDTOPage.getTotalPages(),1);
    }
}
