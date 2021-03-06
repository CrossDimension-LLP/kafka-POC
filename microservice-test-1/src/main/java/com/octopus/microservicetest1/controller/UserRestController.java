package com.octopus.microservicetest1.controller;

import com.octopus.microservicetest1.model.User;
import com.octopus.microservicetest1.service.implementation.ProducerService;
import com.octopus.microservicetest1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserRestController {

    private final ProducerService producerService;
    @Autowired
    private IUserService userService;

    public UserRestController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/user")
    public User createUser(@RequestBody User user){
        producerService.sendMessage(user);
        return userService.createUser(user);
    }

}
