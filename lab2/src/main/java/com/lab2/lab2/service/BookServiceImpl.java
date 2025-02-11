package com.lab2.lab2.service;

import com.lab2.lab2.entity.Book;
import com.lab2.lab2.exception.BookNotFoundException;
import com.lab2.lab2.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepo;
    @Autowired
    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("NOok not found"));
    }

    @Override
    public Book save(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public Book update(int id, Book book) {
        Book bookToUpdate = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("NOok not found"));
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setCategory(book.getCategory());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPrice(book.getPrice());
        return bookRepo.save(bookToUpdate);
    }


    @Override
    public void delete(int id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("NOok not found"));
        bookRepo.delete(book);

    }
}

