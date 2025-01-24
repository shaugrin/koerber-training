package org.example.dao;

import org.example.entities.Customer;
import org.example.factory.ConnectionFactory;
import java.io.IOException;
import java.sql.*;

public class CustomerDaoImp implements CustomerDao {
    private final ConnectionFactory connectionFactory;

    public CustomerDaoImp() throws IOException, SQLException {
        connectionFactory = ConnectionFactory.getInstance();
    }

    @Override
    public void addCustomer(Customer customer) {
        try (Connection connection = connectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO customers (id,name, address, phoneNumber) VALUES (?, ?, ?,?)")) {
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getAddress());
            statement.setLong(4, customer.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
        }
    }

    @Override
    public Customer findCustomer(int id) {
        Customer customer = null;
        try (Connection connection = connectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    customer = new Customer(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("address"),
                            resultSet.getLong("phoneNumber")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting customer: " + e.getMessage());
        }
        return customer;
    }
}