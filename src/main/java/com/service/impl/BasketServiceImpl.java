package com.service.impl;

import com.model.Basket;
import com.model.Product;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.repository.BasketJpaRepository;
import com.service.BasketService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BasketServiceImpl implements BasketService {

    private final BasketJpaRepository basketJpaRepository;

    @Autowired
    public BasketServiceImpl(BasketJpaRepository basketJpaRepository) {
        this.basketJpaRepository = basketJpaRepository;
    }

    public void add(Basket basket) {
        basketJpaRepository.saveAndFlush(basket);
    }

    public void addProduct(Basket basket, Product product) {
        basket.getProducts().add(product);
        basketJpaRepository.saveAndFlush(basket);
    }

    public List<Product> getProducts(Basket basket) {
        return basket.getProducts();
    }

    public int getCountProducts(Basket basket) {
        return basket.getBasketSize();
    }

    public Optional<Basket> getBasketByUser(User user) {
        return basketJpaRepository.getBasketByUser(user);
    }

}
