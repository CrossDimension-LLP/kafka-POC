package com.octopus.microservicetest2.controller;

import com.octopus.microservicetest2.model.Order;
import com.octopus.microservicetest2.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderRestController {

    @Autowired
    private IOrderService orderService;

    @PostMapping(value = "/order")
    public Order createOrder (@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}
