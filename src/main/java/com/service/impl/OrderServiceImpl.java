package com.service.impl;

import com.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.repository.OrderJpaRepository;
import com.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderJpaRepository jpaRepository;

    @Autowired
    public OrderServiceImpl(OrderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public void addOrder(Order order) {
        jpaRepository.saveAndFlush(order);
    }

}
