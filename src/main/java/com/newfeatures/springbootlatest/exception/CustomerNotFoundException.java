package com.newfeatures.springbootlatest.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
