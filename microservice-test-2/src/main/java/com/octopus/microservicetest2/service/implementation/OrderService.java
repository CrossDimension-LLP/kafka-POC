package com.octopus.microservicetest2.service.implementation;

import com.octopus.microservicetest2.model.Order;
import com.octopus.microservicetest2.repository.IOrderRepository;
import com.octopus.microservicetest2.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }
}
