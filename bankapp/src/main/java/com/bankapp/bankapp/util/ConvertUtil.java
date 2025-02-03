package com.bankapp.bankapp.util;

import com.bankapp.bankapp.dto.AccountDto;
import com.bankapp.bankapp.dto.TransferDto;
import com.bankapp.bankapp.entities.Account;

import java.math.BigDecimal;

public class ConvertUtil {

    public static AccountDto convertToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }

    public static Account convertToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());
        account.setBalance(accountDto.getBalance());
        return account;
    }
}
