package com.bankapp.bankapp.controller;

import com.bankapp.bankapp.dto.AccountDto;
import com.bankapp.bankapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AcccountCrudController {

    private AccountService accountService;

    @Autowired
    public AcccountCrudController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable int id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.createAccount(accountDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable int id, @Valid @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.updateAccount(id, accountDto.getBalance()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable int id) {
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }
}
