package com.service;

import com.model.Basket;
import com.model.Product;
import com.model.User;

import java.util.List;
import java.util.Optional;

public interface BasketService {

    void add(Basket basket);

    void addProduct(Basket basket, Product product);

    List<Product> getProducts(Basket basket);

    int getCountProducts(Basket basket);

    Optional<Basket> getBasketByUser(User user);

}
