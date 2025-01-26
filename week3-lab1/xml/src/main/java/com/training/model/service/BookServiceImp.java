package com.training.model.service;

import com.training.model.persistence.dao.BookDao;
import com.training.model.persistence.entities.Book;
import lombok.Setter;

import java.util.List;

@Setter
public class BookServiceImp implements BookService {

    private BookDao dao;

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }
}
