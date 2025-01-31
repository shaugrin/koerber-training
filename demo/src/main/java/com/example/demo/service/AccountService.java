package com.example.demo.service;

import com.example.demo.entities.Account;

public interface AccountService {
    void transfer(int from, int to, double amount);
    void deposit(int id, double amount);
    Account getAccount(int id);
}

