package com.bankapp.bankapp.controller;

import com.bankapp.bankapp.dto.DepositDto;
import com.bankapp.bankapp.dto.TransferDto;
import com.bankapp.bankapp.dto.WithdrawDto;
import com.bankapp.bankapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountTxController {

    private final AccountService accountService;

    @Autowired
    public AccountTxController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/deposit")
    public String deposit(@Valid @RequestBody DepositDto depositDto) {
        return accountService.deposit(depositDto);
    }

    @PostMapping("/withdraw")
    public String withdraw(@Valid @RequestBody WithdrawDto withdrawDto) {
        return accountService.withdraw(withdrawDto);
    }

    @PostMapping("/transfer")
    public String transfer(@Valid @RequestBody TransferDto transferDto) {
        return accountService.transfer(transferDto);
    }
}
