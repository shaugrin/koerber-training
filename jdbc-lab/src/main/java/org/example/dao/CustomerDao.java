package org.example.dao;

import org.example.entities.Customer;

public interface CustomerDao {
    void addCustomer(Customer customer);
    Customer findCustomer(int id);
}
