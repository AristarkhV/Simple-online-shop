package com.repository;

import com.model.Basket;
import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketJpaRepository extends JpaRepository<Basket, Long> {

    Optional<Basket> getBasketByUser(User user);

}
