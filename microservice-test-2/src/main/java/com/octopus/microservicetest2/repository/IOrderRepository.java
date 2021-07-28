package com.octopus.microservicetest2.repository;

import com.octopus.microservicetest2.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepository extends MongoRepository<Order, String> {
}
