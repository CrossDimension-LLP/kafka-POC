package com.octopus.microservicetest2.service.implementation;
import com.octopus.microservicetest2.model.User;
import com.octopus.microservicetest2.service.interfaces.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {
    @Value("${spring.kafka.consumer.topic-name}")
    private String topicname;

    @Autowired
    private IOrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "userUpdation", groupId = "group_id")
    public void consume(User user) {
        logger.info(String.format("$$$$ => Consumed message: %s", user));
        orderService.updateOrder(user);
    }
}