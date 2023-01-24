package com.Configure.SwaggerApi.service;

import com.Configure.SwaggerApi.entitiy.Product;
import com.Configure.SwaggerApi.entitiy.ResponseMessage;
import com.Configure.SwaggerApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired(required = false)
    ProductRepository productRepository;

    public Product createProduct(Product product) {
        Long length = productRepository.count();
        Long newProductId =  length + 1;
        Product dataProduct = new Product(newProductId, product.getName(), product.getDescription(), product.getStock(), product.getPrice());
        productRepository.save(dataProduct);
        return productRepository.findById(newProductId).get();
    }
    public List<Product> getProducts() {
        List<Product> listOfProduct = productRepository.findAll();
        return listOfProduct;
    }
    public Product getProductById(Long id) {
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
