package org.example;

import java.io.*;
import java.sql.*;
import java.util.*;


// DAO Implementation
class BookDaoImp implements BookDao {

    @Override
    public List<Book> getAllBooks() throws DaoException {
        return List.of();
    }

    @Override
    public void addBook(Book book) throws DaoException {

    }

    @Override
    public void deleteBook(int id) throws DaoException {

    }

    @Override
    public void updateBook(int id, Book book) throws DaoException {

    }

    @Override
    public Book getBookById(int id) throws DaoException {
        return null;
    }
}
