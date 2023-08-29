package com.newfeatures.springbootlatest.exception;

import static org.springframework.http.ProblemDetail.forStatusAndDetail;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationException {


    @ExceptionHandler(CustomerNotFoundException.class)
    public ProblemDetail handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException) {

        ProblemDetail problemDetail = forStatusAndDetail(HttpStatusCode.valueOf(400),
                customerNotFoundException.getMessage());
        problemDetail.setTitle("Customer not Found");
        return problemDetail;

    }
}
