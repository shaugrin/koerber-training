package com.lab2.lab2.service;


import com.lab2.lab2.entity.Book;
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
