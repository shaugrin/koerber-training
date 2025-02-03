package com.bankapp.bankapp.exceptions;

public class InsufficientFundaException extends RuntimeException {
    public InsufficientFundaException(String message) {
        super(message);
    }
}
