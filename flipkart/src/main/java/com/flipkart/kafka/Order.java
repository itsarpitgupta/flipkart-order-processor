package com.flipkart.kafka;
import java.io.Serializable;

public class Order implements Serializable {
    private String orderType;   // "BOOK", "MOBILE", or "CAR"
    private String description; // Additional details like book title, mobile model, or car vendor
    private int price;          // Price of the order

    // Constructors
    public Order() {}

    public Order(String orderType, String description, int price) {
        this.orderType = orderType;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return "Order{" +
                "orderType='" + orderType + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
