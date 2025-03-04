package com.training.model.persistence.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
    // Getters and Setters
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(int id, String isbn, String title, String author, double price) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

}
