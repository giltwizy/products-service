package com.giltwizy.testapp.controller;

import com.giltwizy.testapp.dto.ProductDto;
import com.giltwizy.testapp.entity.Product;
import com.giltwizy.testapp.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("addProduct")
    public ResponseEntity<Product> addProduct( @RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
    }

    @PostMapping("addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
        return new ResponseEntity<>(productService.saveProducts(products),HttpStatus.CREATED);
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("productById/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping("productByName/{productName}")
    public ResponseEntity<Product> getProductByName(@PathVariable String productName){
        return ResponseEntity.ok(productService.getProductByName(productName));
    }

    @PutMapping("update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId){
        return ResponseEntity.ok(productService.deleteProductById(productId));
    }
}
