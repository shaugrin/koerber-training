package com.employeeservice;

import com.employeeservice.entity.Employee;
import com.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Employee(1L, "John Doe", "john.doe@example.com", 1L));
		repository.save(new Employee(2L, "Jane Smith", "jane.smith@example.com", 2L));
		repository.save(new Employee(3L, "Mike Johnson", "mike.johnson@example.com", 3L));
		System.out.println("Employee data initialized!");
	}
}
