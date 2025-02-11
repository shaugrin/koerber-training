package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repo.BookRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepo.save(new Book("123","book1","category1","author1", BigDecimal.valueOf(1000.00)));
		bookRepo.save(new Book("456","book2","category2","author2",BigDecimal.valueOf(2000.00)));
		userService.addUser(new User("teacher",
				passwordEncoder.encode("teacher"), List.of("ROLE_TEACHER","ROLE_STUDENT")));

		userService.addUser(new User("student",passwordEncoder.encode("student"),
				List.of("ROLE_STUDENT")));


		System.out.println("---------------added books----------------");
	}
}
