package com.octopus.microservicetest1.repository;

import com.octopus.microservicetest1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
}
