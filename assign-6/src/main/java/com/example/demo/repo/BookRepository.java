package com.example.demo.repo;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select p from Book p")
    List<Book> getAllBooks();

    @Query("select p from Book p where p.name=?1")
    Book getBookByName(String name);

    @Query("select p from Book p where p.name=:name")
    Book getBookByName2(@Param("name") String name);

    @Query("select p from Book p where p.name=?1 and p.price=?2")
    Book getBookByNameAndPrice(String name, double price);

    @Query("select p from Book p where p.name=?1 or p.price=?2")
    List<Book> getBookByNameOrPrice(String name, double price);

    @Query("select p from Book p where p.name like %?1")
    List<Book> findByNameEndingWith(String name);

    @Query("select p from Book p where p.mfgDate > ?1")
    List<Book> findByMfgDateAfter(LocalDate date);

    @Query("select p from Book p where p.mfgDate < ?1")
    List<Book> findByMfgDateBefore(LocalDate date);


    @Query("select p from Book p where p.name like ?1")
    List<Book> findByNameContaining(String name);

    @Query("select p from Book p where p.name like %?1%")
    List<Book> findByNameLike(String name);

    @Query("select p from Book p where p.name like ?1%")
    List<Book> findByNameStartingWith(String name);


    @Query("select p from Book p where lower(p.name)=?1")
    List<Book> findByNameIgnoreCase(String name);


    @Query("select p from Book p where p.mfgDate between ?1 and ?2")
    List<Book> findByMfgDateBetween(LocalDate date1, LocalDate date2);
}
