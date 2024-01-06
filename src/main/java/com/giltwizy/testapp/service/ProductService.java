package com.giltwizy.testapp.service;

import com.giltwizy.testapp.entity.Product;
import com.giltwizy.testapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId){
        return productRepository.findById(productId).orElse(null);
    }

    public Product getProductByName(String productName){
        return productRepository.findByProductName(productName);
    }

    public String deleteProductById(int productId){
        productRepository.deleteById(productId);
        return "Product "+productId+" is deleted successfully";
    }

    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductPrice(product.getProductPrice());
        existingProduct.setProductQuantity(product.getProductQuantity());
        return productRepository.save(existingProduct);
    }

}
