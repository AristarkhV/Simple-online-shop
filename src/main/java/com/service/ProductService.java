package com.service;

import com.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getAllProducts();

    void deleteProduct(Product product);

    Optional<Product> getById(Long id);

    void updateProduct(Product product);

}
