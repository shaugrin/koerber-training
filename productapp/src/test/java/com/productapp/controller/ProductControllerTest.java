package com.productapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepo productRepo;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void givenProductObject_whenCreateProduct_thenReturnSavedProduct() throws Exception {
        // given - precondition or setup
        ProductDto productDto = new ProductDto(0, "laptop", new BigDecimal("120000.00"));
        given(productService.addProduct(productDto)).willReturn(productDto);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)));

        // then - verify the output
        response.andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(productDto.getName())))
                .andExpect(jsonPath("$.price", is(productDto.getPrice().toString())));
    }
    @Test
    public void givenListOfProducts_whenGetAllProducts_thenReturnProductList() throws Exception{
        // given - precondition or setup
        List<ProductDto> listOfProducts = new ArrayList<>();
        listOfProducts.add(new ProductDto(1,"a", new BigDecimal(6000)));
        listOfProducts.add(new ProductDto(2,"b", new BigDecimal(6000)));
        given(productService.getProducts()).willReturn(listOfProducts);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/products"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfProducts.size())));

    }

    // positive scenario - valid product id
    @Test
    public void givenProductId_whenGetProductById_thenReturnProductObject() throws Exception{
        // given - precondition or setup
        int productId = 1;
        ProductDto product=new ProductDto(1,"laptop", new BigDecimal(120000));
        given(productService.getProductById(productId)).willReturn(product);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/products/{id}", productId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.price", is(product.getPrice())));

    }


    // @Test
    public void givenInvalidProductId_whenGetProductById_thenReturnEmpty() throws Exception{
        // given - precondition or setup
        int productId = 1;
        Product product=new Product(1,"laptop", new BigDecimal(120000));
        given(productService.getProductById(productId)).willReturn(null);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/products/{id}", productId));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());

    }

    // JUnit test for delete employee REST API
    @Test
    public void givenProductId_whenDeleteProduct_thenReturn200() throws Exception {
        // given - precondition or setup
        int productId = 1;
        when(productService.removeProduct(productId)).thenReturn(new ProductDto());

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/products/{id}", productId));

        // then - verify the output
        response.andExpect(status().isNoContent()) // Update this line
                .andDo(print());
    }
}