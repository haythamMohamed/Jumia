package com.jumia.test.service.impl;

import com.jumia.test.dao.CustomerDAO;
import com.jumia.test.dto.CustomerDTO;
import com.jumia.test.dto.SearchCustomerDTO;
import com.jumia.test.entity.Customer;
import com.jumia.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired CustomerDAO customerDAO ;

    @Override
    public Page<CustomerDTO> searchOverCustomers(SearchCustomerDTO searchCustomerDTO) {
       List<Customer> customers =  customerDAO.searchOverCustomer(searchCustomerDTO);
        Stream<CustomerDTO> stream = customers.stream().map(CustomerDTO::fromEntity);
        if(searchCustomerDTO.getState() != null){
            stream = stream.filter(CustomerDTO::isState);
        }
        List<CustomerDTO> result = stream.collect(Collectors.toList());
        Page<CustomerDTO> page = new PageImpl<>(result,PageRequest.of(searchCustomerDTO.getPageNumber(),searchCustomerDTO.getPageSize()) ,result.size());
       return page ;
    }

}
