package org.example;


import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImp;
import org.example.entities.Customer;
import org.example.exceptions.CustomerDaoException;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        CustomerDao customerDao = new CustomerDaoImp();

        try {
            customerDao.addCustomer(new Customer(1, "John Doe", "123 Main St", 1234567890));
            customerDao.addCustomer(new Customer(2, "Jane Doe", "456 Main St", 1234567891));
            customerDao.addCustomer(new Customer(3, "Bob Smith", "789 Main St", 1234567892));
            customerDao.addCustomer(new Customer(4, "Alice Johnson", "321 Main St", 1234567893));

            Customer customer = customerDao.findCustomer(1);
            System.out.println("Found customer: " + customer);
            Customer customer2 = customerDao.findCustomer(4);
            System.out.println("Found customer: " + customer2);
        } catch (CustomerDaoException e) {
            System.out.println("Failed to add customer: ");
        }
    }
}