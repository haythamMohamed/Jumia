package com.jumia.test.controller;

import com.jumia.test.dto.CustomerDTO;
import com.jumia.test.dto.SearchCustomerDTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testSearchForCustomerInCountry () throws JSONException {

        SearchCustomerDTO searchCustomerDTO = new SearchCustomerDTO();
        searchCustomerDTO.setCountry("Cameroon");
        searchCustomerDTO.setPageSize(10);
        searchCustomerDTO.setPageNumber(0);

        HttpEntity<SearchCustomerDTO> httpEntity = new HttpEntity<>(searchCustomerDTO);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange("/customer/get-all/", HttpMethod.POST, httpEntity, String.class);

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

        JSONObject response = new JSONObject(responseEntity.getBody());

        Assertions.assertEquals(response.getInt("numberOfElements"),10);
        Assertions.assertEquals(response.getJSONArray("content").length(),10);

    }

    @Test
    public void testSearchForCustomerInCountryByState () throws JSONException {

        SearchCustomerDTO searchCustomerDTO = new SearchCustomerDTO();
        searchCustomerDTO.setCountry("Cameroon");
        searchCustomerDTO.setState(true);
        searchCustomerDTO.setPageSize(10);
        searchCustomerDTO.setPageNumber(0);

        HttpEntity<SearchCustomerDTO> httpEntity = new HttpEntity<>(searchCustomerDTO);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange("/customer/get-all/", HttpMethod.POST, httpEntity, String.class);

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

        JSONObject response = new JSONObject(responseEntity.getBody());

        Assertions.assertEquals(response.getInt("numberOfElements"),7);
        Assertions.assertEquals(response.getJSONArray("content").length(),7);

    }
}
