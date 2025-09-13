package com.study.java.day1.domain.store;

public class Product {
    String name;
    int price;
    int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int decreaseQuantity(int quantity) {
        this.quantity -= quantity;

        return this.quantity;
    }

    public int increaseQuantity(int quantity) {
        this.quantity += quantity;

        return this.quantity;
    }
}
