package com.octopus.microservicetest2.service.interfaces;

import com.octopus.microservicetest2.model.Order;

public interface IOrderService {
    Order createOrder(Order order);
}
