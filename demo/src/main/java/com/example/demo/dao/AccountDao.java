package com.example.demo.dao;

import com.example.demo.entities.Account;

public interface AccountDao {
    void update(Account account);
    Account find(int id);
}
