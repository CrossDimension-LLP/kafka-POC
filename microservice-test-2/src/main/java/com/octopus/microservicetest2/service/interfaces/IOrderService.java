package com.octopus.microservicetest2.service.interfaces;

import com.octopus.microservicetest2.model.Order;
import com.octopus.microservicetest2.model.User;

public interface IOrderService {
    Order createOrder(Order order);
     void updateOrder(User user);
}
