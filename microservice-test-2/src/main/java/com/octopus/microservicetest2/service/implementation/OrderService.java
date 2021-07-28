package com.octopus.microservicetest2.service.implementation;

import com.octopus.microservicetest2.model.Order;
import com.octopus.microservicetest2.model.User;
import com.octopus.microservicetest2.repository.IOrderRepository;
import com.octopus.microservicetest2.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public void updateOrder(User user) {
        List<Order> orderList = orderRepository.findAll();
        orderList.get(0).setAttachUser(user);
        orderRepository.save(orderList.get(0));
    }
}
