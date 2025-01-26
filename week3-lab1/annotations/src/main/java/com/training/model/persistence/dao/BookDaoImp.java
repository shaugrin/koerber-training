package com.training.model.persistence.dao;


import com.training.model.persistence.entities.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Component
public class BookDaoImp implements BookDao {
    private static Map<Integer, Book> booksMap = new HashMap<>();
    private static int counter = 0;

    // Static block to initialize with some data
    static {
        booksMap.put(++counter, new Book(counter, "ABC123", "Head First Java", "Kathy Sierra", 600));
        booksMap.put(++counter, new Book(counter, "ABC723", "Servlet JSP Java", "Kathy Sierra", 700));
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(booksMap.values());
    }

    @Override
    public Book addBook(Book book) {
        book.setId(++counter);
        booksMap.put(counter, book);
        return book;
    }

    @Override
    public void deleteBook(int id) {
        booksMap.remove(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        booksMap.put(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return booksMap.get(id);
    }
}
