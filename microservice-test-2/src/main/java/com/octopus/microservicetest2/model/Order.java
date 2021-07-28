package com.octopus.microservicetest2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "com.kafka.poc.consumer.order")
public class Order {

    @Id
    private String id;
    private String productId;
    private User attachUser;
    private String price;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public User getAttachUser() {
        return attachUser;
    }

    public void setAttachUser(User attachUser) {
        this.attachUser = attachUser;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
