package com.example.demo.service;

import com.example.demo.dao.AccountDao;
import com.example.demo.entities.Account;
import com.example.demo.exceptions.AccountNotFoundException;
import com.example.demo.exceptions.InsufficientFundsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(int from, int to, double amount) {
        Account sender = accountDao.find(from);
        Account receiver = accountDao.find(to);

        if (sender == null) {
            throw new AccountNotFoundException("Sender account not found");
        }
        if (receiver == null) {
            throw new AccountNotFoundException("Receiver account not found");
        }
        if (sender.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds in sender's account");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountDao.update(sender);
        accountDao.update(receiver);
    }

    @Override
    public void deposit(int id, double amount) {
        Account account = accountDao.find(id);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        account.setBalance(account.getBalance() + amount);
        accountDao.update(account);
    }

    @Override
    public Account getAccount(int id) {
        Account account = accountDao.find(id);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        return account;
    }
}
