package com.productapp.repo;

import com.productapp.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("laptop", new BigDecimal("2222.00"));
    }

    @DisplayName("JUnit test for save product")
    @Test
    @Rollback
    void testSaveProduct() {
        Product savedProduct = productRepo.save(product);
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @DisplayName("JUnit test for get all products")
    @Test
    @Rollback
    void testGetAllProducts() {
        Product product2 = new Product("laptop cover", new BigDecimal("2222.00"));
        productRepo.save(product);
        productRepo.save(product2);

        List<Product> products = productRepo.findAll();
        assertThat(products).hasSize(2);
    }
}
