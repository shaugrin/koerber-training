package org.example.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
    private final String url;
    private final String user;
    private final String password;

    public ConnectionFactory(String url, String user, String password, String driver) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load database driver: " + driver, e);
        }
    }

    public  Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static ConnectionFactory getInstance() throws IOException, SQLException {
        Properties properties = new Properties();
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find database.properties");
            }
            properties.load(input);
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");
        String driver = properties.getProperty("db.driver");

        return new ConnectionFactory(url, user, password, driver);
    }
}