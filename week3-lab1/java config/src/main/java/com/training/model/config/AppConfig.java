package com.training.model.config;

import com.training.model.persistence.dao.BookDao;
import com.training.model.persistence.dao.BookDaoImp;
import com.training.model.service.BookService;
import com.training.model.service.BookServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BookDao bookDao() {
        return new BookDaoImp();
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImp(bookDao());
    }
}
