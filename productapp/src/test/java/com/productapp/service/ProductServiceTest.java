package com.productapp.service;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.productapp.util.ProductUtil.convertProductToProductDto;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        Product product = new Product("laptop", new BigDecimal("2222.00"));
        productRepo.save(product);
    }

    @DisplayName("JUnit test for get all products")
    @Test
    void testGetAllProducts() {
        // note that its mockito
        Product product = new Product("laptop cover", new BigDecimal("2222.00"));
        when(productRepo.findAll()).thenReturn(List.of(product));
        List<ProductDto> products = productService.getProducts();
        assertThat(products).hasSize(1);
    }

    @DisplayName("JUnit test for get product by id")
    @Test
    void testGetProductById() {
        Product product = new Product("laptop cover", new BigDecimal("2222.00"));
        product.setId(1);
        when(productRepo.findById(1)).thenReturn(Optional.of(product));
        ProductDto productDto = productService.getProductById(1);
        assertThat(productDto).isNotNull();
    }

    @DisplayName("JUnit test for delete product by id")
    @Test
    @Rollback
    void testDeleteProductById() {
        Product product = new Product();
        product.setId(1);
        product.setName("Sample Product");
        product.setPrice(new BigDecimal("100.0"));
        when(productRepo.findById(1)).thenReturn(Optional.of(product));
        productService.removeProduct(1);
        verify(productRepo, times(1)).delete(product);
    }



    @Test
    @Rollback
    void testUpdateProduct() {
        ProductDto product = new ProductDto(1, "laptop", new BigDecimal("2222.00"));
        when(productRepo.findById(1)).thenReturn(Optional.of(new Product()));
        productService.updateProduct(product.getId(),product);
        ProductDto productById = productService.getProductById(1);
        assertThat(productById).isNotNull();
    }

    @Test
    @Rollback
    void testAddProduct() {
        ProductDto product = new ProductDto(1, "laptop", new BigDecimal("2222.00"));
        when(productRepo.save(any(Product.class))).thenReturn(new Product());
        ProductDto savedProduct = productService.addProduct(product);
        assertThat(savedProduct).isNotNull();
    }
}
