package com.newfeatures.springbootlatest.dto;


import org.springframework.http.HttpStatus;

public class Error {

    private HttpStatus status;
    private int errorCode;
    private String errorMessage;
}
