package com.bankapp.bankapp.service;

import com.bankapp.bankapp.dto.AccountDto;
import com.bankapp.bankapp.dto.DepositDto;
import com.bankapp.bankapp.dto.TransferDto;
import com.bankapp.bankapp.dto.WithdrawDto;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public AccountDto createAccount(AccountDto accountDto);
    public AccountDto getAccount(int id);
    public AccountDto updateAccount(int id, BigDecimal balance);
    public String deleteAccount(int id);
    public String transfer(TransferDto transferDto);
    public String deposit(DepositDto depositDto);
    public String withdraw(WithdrawDto withdrawDto);
    public List<AccountDto> getAllAccounts();
}
