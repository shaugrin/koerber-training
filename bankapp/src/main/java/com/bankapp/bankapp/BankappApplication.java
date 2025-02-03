package com.bankapp.bankapp;

import com.bankapp.bankapp.entities.Account;
import com.bankapp.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {


	@Autowired
	private AccountRepo accountRepo;
	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("John Doe", new BigDecimal(1000)));
		accountRepo.save(new Account("Jane Doe", new BigDecimal(500)));
	}
}
