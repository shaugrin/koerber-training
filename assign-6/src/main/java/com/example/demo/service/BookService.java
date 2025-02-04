package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBookSorted(String field) {
        return bookRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public Page<Book> getAllBookPage(int offset, int pageSize) {
        return bookRepo.findAll(PageRequest.of(offset, pageSize));
    }

    public Page<Book> getAllBookPageSorted(String field, int offset, int pageSize) {
        return bookRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.ASC, field)));
    }
}
