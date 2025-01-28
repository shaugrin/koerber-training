package com.training.model.persistence.dao;


import com.training.model.annotations.Loggable;
import com.training.model.persistence.entities.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;


@Component
public class BookDaoImp implements BookDao {
    private static Map<Integer, Book> booksMap = new HashMap<>();
    private static int counter = 0;

    static {
        booksMap.put(1, new Book(1, "1234", "book1", "author1", 100.0));
        booksMap.put(2, new Book(2, "1235", "book2", "author2", 200.0));
    }

    public static void setBooksMap(Map<Integer, Book> booksMap) {
        BookDaoImp.booksMap = booksMap;
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
