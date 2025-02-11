package com.lab2.lab2;

import com.lab2.lab2.entity.Book;
import com.lab2.lab2.entity.User;
import com.lab2.lab2.repo.BookRepository;
import com.lab2.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class Lab2Application implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class,args);
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
