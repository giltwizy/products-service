package com.giltwizy.testapp.controller;

import com.giltwizy.testapp.entity.Product;
import com.giltwizy.testapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("productById/{productId}")
    public Product getProduct(@PathVariable int productId){
        return productService.getProductById(productId);
    }

    @GetMapping("productByName/{productName}")
    public Product getProductByName(@PathVariable String productName){
        return productService.getProductByName(productName);
    }

    @PutMapping("update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("delete/{productId}")
    public String deleteProduct(@PathVariable int productId){
        return productService.deleteProductById(productId);
    }
}
