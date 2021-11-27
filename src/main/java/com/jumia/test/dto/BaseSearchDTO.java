package com.jumia.test.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseSearchDTO implements Serializable {

    private int pageSize ;
    private int pageNumber ;
}
