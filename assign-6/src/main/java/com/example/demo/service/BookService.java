package com.example.demo.service;

import com.example.demo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    public List<Book> getAll();
    public Book getById(int id);
    public Book save(Book book);
    public Book update(int id,Book book);


    public void delete(int id);

}
