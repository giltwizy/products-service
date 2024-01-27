package com.giltwizy.testapp;


import com.giltwizy.testapp.entity.Product;
import com.giltwizy.testapp.repository.ProductRepository;
import com.giltwizy.testapp.service.ProductService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAppApplicationTests {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void getProductsTest(){
        when(productRepository.findAll()).thenReturn(Arrays.asList(
                new Product(1, "Laptop", 999.99, 5),
                new Product(2, "Smartphone", 499.99, 10)
                // Add more products if needed
        ));
        assertEquals(2,productService.getProducts().size());

    }

    @Test
    public void addProductTest(){
        Product wirelessMouse = new Product(5,"Wireless Mouse",20000,3);
        when(
                productRepository.save(wirelessMouse)
        ).thenReturn(wirelessMouse);
        assertEquals(wirelessMouse,productService.saveProduct(wirelessMouse));
    }

    @Test
    public void testDeleteProductById() {
        Product pillow = new Product(8, "Bed pillow", 2000, 4);

        // Mock the behavior of productRepository.findById
        when(productRepository.findById(pillow.getProductId()))
                .thenReturn(Optional.of(pillow));

        // Call the method you are testing
        String result = productService.deleteProductById(pillow.getProductId());

        // Verify that productRepository.deleteById was called with the correct productId
        verify(productRepository, times(1)).deleteById(pillow.getProductId());

        // Verify the result message
        String expectedMessage = "Product " + pillow.getProductId() + " is deleted successfully";
        assertEquals(expectedMessage, result);
    }



}
