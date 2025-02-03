package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.entities.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody AccountDto dto) {
        accountService.transfer(dto.getFrom(), dto.getTo(), dto.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam int id, @RequestParam double amount) {
        accountService.deposit(id, amount);
        return ResponseEntity.ok("Deposit successful");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable int id) {
        Account account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }
}
