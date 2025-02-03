package com.bankapp.bankapp.controller;

import com.bankapp.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.bankapp.exceptions.InsufficientFundaException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class BankAppExceptionHandler {

    private final Environment environment;

    public BankAppExceptionHandler(Environment environment) {
        this.environment = environment;
    }
    @ExceptionHandler(InsufficientFundaException.class)
    public ResponseEntity<ErrorDetails> handleInsufficientFundaException(InsufficientFundaException ex) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .timestamp(LocalTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleAccountNotFoundException(AccountNotFoundException ex) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .timestamp(LocalTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex)
    {
        String errorMessage= ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        ErrorDetails errorDetails= ErrorDetails.builder()
                .message(errorMessage)
                .timestamp(LocalTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception ex) {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(environment.getProperty("generic.error.message"))
                .timestamp(LocalTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

}
