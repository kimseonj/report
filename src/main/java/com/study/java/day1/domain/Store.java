package com.study.java.day1.domain;

import com.study.java.day1.Utils;

public class Store {
    String name;
    Product[] products;

    public Store(String name, Product[] products) {
        this.name = name;
        this.products = products;
    }

    public void enterStore() {
        System.out.println("안녕하세요. " + name + " 입니다.\n");
    }

    public void leaveStore() {
        System.out.println("\n 안녕히가세요!");
    }

    public void showProducts() {
        System.out.println("상품 안내!\n");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + ". " + products[i].getName() + " / " + products[i].getPrice() + "원");
        }
        System.out.println("---------------------------------");
    }

    public void action() {
        System.out.println("무엇을 도와드릴까요?");
    }

    public String getName() {
        return name;
    }

    public Product[] getProducts() {
        return products;
    }
}
