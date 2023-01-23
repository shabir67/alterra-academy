package com.Configure.SwaggerApi.service;

import com.Configure.SwaggerApi.entitiy.Product;
import com.Configure.SwaggerApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {


    }
    public List<Product> getProducts() {
        List<Product> listOfProduct = productRepository.findAll();
        return listOfProduct;
    }
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }
    public Product updateProduct(Product product) {
        productRepository.save(product);
        return productRepository.findById(product.getId()).get();
    }

    public ResponseMessage deleteProduct(Long id) {
        productRepository.deleteById(id);
        return new ResponseMessage("Product succsesfully Deleted");
    }
}
