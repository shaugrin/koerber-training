package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller+ @ResponseBody(trigger the parser to return json)
@RequestMapping(path = "api")
public class BookController {

    private BookService bookService;
    //@Autowired is optional to write on single ctr
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "products")
    public ResponseEntity<List<Book>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<Book> getProductById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body( bookService.getBookById(id));
    }

    @PostMapping(path = "products")
    public ResponseEntity<Book> addProduct( @RequestBody @Valid Book product){
        Book productToReturn = bookService.addBook(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productToReturn);
    }

    //Exception hainding in controller layer.. 100 of controller, try catch... AOP
    //Ex hainding is a ccc, using aop
    //update
    @PutMapping(path = "products/{id}")
    public ResponseEntity<Book> updateProduct(@PathVariable int id, @RequestBody Book product){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id, product));
    }

    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable int id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
