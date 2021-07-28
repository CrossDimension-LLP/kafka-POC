package com.octopus.microservicetest1.service.implementation;

import com.octopus.microservicetest1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public final class ProducerService {

    @Value("${spring.kafka.producer.topic-name}")
    private String topicName;


    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(User user) {
        logger.info(String.format("$$$$ => Producing message: %s", user));

        ListenableFuture<SendResult<String, User>> future = this.kafkaTemplate.send(topicName, user);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Unable to send message=[ {} ] due to : {}", user, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, User> result) {
                logger.info("Sent message=[ {} ] with offset=[ {} ]", user, result.getRecordMetadata().offset());
            }
        });
    }
}
