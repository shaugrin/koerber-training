package com.lab2.lab2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="book_isbn",nullable = false, unique=true,length=20)
    private String isbn;
    @Size(min = 2, max = 50, message = "Title must be between 2-50 characters")
    @Column(name="book_title",nullable = false,length=20)
    private String title;
    @Size(min = 2, max = 30, message = "Category must be between 2 and 30 characters")
    @Column(name="book_category",nullable = false,length=20)
    private String category;
    @Column(name="book_author",nullable = false, length=20)
    private String author;
    @Column(name="book_price",nullable = false)
    private BigDecimal price;

    public Book(String isbn, String title, String category, String author, BigDecimal price) {
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.author = author;
        this.price = price;
    }
}
