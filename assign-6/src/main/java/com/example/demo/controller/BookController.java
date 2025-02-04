package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/sorted")
    public List<Book> getAllBookSorted(@RequestParam String field) {
        return bookService.getAllBookSorted(field);
    }

    @GetMapping("/page")
    public Page<Book> getAllBookPage(@RequestParam int offset, @RequestParam int pageSize) {
        return bookService.getAllBookPage(offset, pageSize);
    }

    @GetMapping("/pagesorted")
    public Page<Book> getAllBookPageSorted(@RequestParam String field, @RequestParam int offset, @RequestParam int pageSize) {
        return bookService.getAllBookPageSorted(field, offset, pageSize);
    }
}
