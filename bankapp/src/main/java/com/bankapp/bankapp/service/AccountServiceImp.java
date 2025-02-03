package com.bankapp.bankapp.service;

import com.bankapp.bankapp.dto.AccountDto;
import com.bankapp.bankapp.dto.DepositDto;
import com.bankapp.bankapp.dto.TransferDto;
import com.bankapp.bankapp.dto.WithdrawDto;
import com.bankapp.bankapp.entities.Account;
import com.bankapp.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.bankapp.repo.AccountRepo;
import com.bankapp.bankapp.util.ConvertUtil;
import jakarta.transaction.Transactional;
import lombok.With;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

    private final AccountRepo accountRepo;
    private final Environment environment;

    @Autowired
    public AccountServiceImp(AccountRepo accountRepo, Environment environment) {
        this.accountRepo = accountRepo;
        this.environment = environment;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        return ConvertUtil.convertToDto(accountRepo.save(ConvertUtil.convertToEntity(accountDto)));
    }

    @Override
    public AccountDto getAccount(int id) {
        return accountRepo.findById(id)
                .map(ConvertUtil::convertToDto)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    @Override
    public AccountDto updateAccount(int id, BigDecimal balance) {
        AccountDto accountDto = getAccount(id);
        accountDto.setBalance(balance);
        return accountDto;
    }

    @Override
    public String deleteAccount(int id) {
        AccountDto accountDto = getAccount(id);
        accountRepo.delete(ConvertUtil.convertToEntity(accountDto));
        return environment.getProperty("deleted.message"); //"deleted.message";
    }

    @Override
    public String transfer(TransferDto transferDto) {
        Account fromAccount = ConvertUtil.convertToEntity(getAccount(transferDto.getFromId()));
        Account toAccount = ConvertUtil.convertToEntity(getAccount(transferDto.getToId()));
        fromAccount.setBalance(fromAccount.getBalance().subtract(transferDto.getAmount()));
        toAccount.setBalance(toAccount.getBalance().add(transferDto.getAmount()));
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);
        return environment.getProperty("transfer.message"); //"transfer.message";
    }

    @Override
    public String deposit(DepositDto depositDto) {
        Account account = ConvertUtil.convertToEntity(getAccount(depositDto.getId()));
        account.setBalance(account.getBalance().add(depositDto.getAmount()));
        accountRepo.save(account);
        return environment.getProperty("deposit.message"); //"deposit.message";
    }

    @Override
    public String withdraw(WithdrawDto withdrawDto) {
        Account account = ConvertUtil.convertToEntity(getAccount(withdrawDto.getId()));
        account.setBalance(account.getBalance().subtract(withdrawDto.getAmount()));
        accountRepo.save(account);
        return environment.getProperty("withdraw.message"); //"withdraw.message";
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepo.findAll()
                .stream()
                .map(ConvertUtil::convertToDto)
                .toList();
    }
}
