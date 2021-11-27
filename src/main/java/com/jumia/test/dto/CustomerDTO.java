
package com.jumia.test.dto;

import com.jumia.test.entity.Customer;
import lombok.Data;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Data
public class CustomerDTO {

    private long id;
    private String name ;
    private String country ;
    private boolean state ;
    private String countryCode ;
    private String number ;

    public static CustomerDTO fromEntity(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setState(customerDTO.validateNumber().test(customer.getPhone()));
        customerDTO.setNumber(customer.getPhone());
        customerDTO.setName(customer.getName());
        customerDTO.setId(customer.getId());
        customerDTO.setCountry(customerDTO.getCountry().apply(customer.getPhone()));
        customerDTO.setCountryCode(customerDTO.getCountryCode().apply(customer.getPhone()));

        return customerDTO ;
    }


    private Predicate<String> validateNumber (){
        return s -> {
            Pattern pattern = null;
            if(s.contains("(237)")){
                pattern = Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$");
            }else if (s.contains("(251)")){
                pattern = Pattern.compile("\\(251\\)\\ ?[1-59]\\d{8}$");
            }else if (s.contains("(212)")){
                pattern = Pattern.compile("\\(212\\)\\ ?[5-9]\\d{8}$");
            }else if (s.contains("(258)")){
                pattern = Pattern.compile("\\(258\\)\\ ?[28]\\d{7,8}$");
            }else if (s.contains("256")){
                pattern = Pattern.compile("\\(256\\)\\ ?\\d{9}$");
            }

            if(pattern != null){
                return pattern.matcher(s).find();
            }else{
                return false ;
            }

        };
    }

    private Function<String,String> getCountry (){
        return s -> {
            String country = null;
            if(s.contains("(237)")){
                country = "Cameroon" ;
            }else if (s.contains("(251)")){
                country = "Ethiopia" ;
            }else if (s.contains("(212)")){
                country = "Morocco" ;
            }else if (s.contains("(258)")){
                country = "Mozambique" ;
            }else if (s.contains("256")){
                country = "Uganda" ;
            }
            return country ;
        };
    }

    private Function<String,String> getCountryCode (){
        return s -> {
            String countryCode = null;
            if(s.contains("(237)")){
                countryCode = "+237" ;
            }else if (s.contains("(251)")){
                countryCode = "+251" ;
            }else if (s.contains("(212)")){
                countryCode = "+212" ;
            }else if (s.contains("(258)")){
                countryCode = "+258" ;
            }else if (s.contains("256")){
                countryCode = "+256" ;
            }
            return countryCode ;
        };
    }
}
