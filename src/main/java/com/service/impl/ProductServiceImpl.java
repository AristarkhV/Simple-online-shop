package com.service.impl;

import com.model.Product;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.repository.ProductJpaRepository;
import com.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductJpaRepository jpaRepository;

    @Autowired
    public ProductServiceImpl(ProductJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Transactional
    public void addProduct(Product product) {
        jpaRepository.saveAndFlush(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return jpaRepository.findAll();
    }

    @Transactional
    public void deleteProduct(Product product) {
        jpaRepository.delete(product);
    }

    @Transactional
    public Optional<Product> getById(Long id) {
        Product product = jpaRepository.getOne(id);
        return Optional.ofNullable(product);
    }

    @Transactional(readOnly = true)
    public void updateProduct(Product product) {
        jpaRepository.saveAndFlush(product);
    }

}
