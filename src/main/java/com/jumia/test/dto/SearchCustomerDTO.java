package com.jumia.test.dto;

import lombok.Data;


public class SearchCustomerDTO extends BaseSearchDTO {

    private String country ;
    private Boolean state ;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
