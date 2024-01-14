package com.giltwizy.testapp.service;

import com.giltwizy.testapp.dto.ProductDto;
import com.giltwizy.testapp.entity.Product;
import com.giltwizy.testapp.exceptions.ProductIdNotFoundException;
import com.giltwizy.testapp.exceptions.ProductNameNotFoundException;
import com.giltwizy.testapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(ProductDto productDto){
        Product product = Product.build(0, productDto.getProductName(),productDto.getProductPrice(),productDto.getProductQuantity());
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId) throws ProductIdNotFoundException {
        Product product =  productRepository.findById(productId).orElse(null);
        if(product != null ){
            return product;
        }
        else {
            throw new ProductIdNotFoundException("Product with id "+productId+" is not found");
        }
    }

    public Product getProductByName(String productName) throws ProductNameNotFoundException {
        Product product = productRepository.findByProductName(productName);
        if(product != null){
            return product;
        }else{
            throw new ProductNameNotFoundException("Product with name "+productName+" is not found");
        }
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
