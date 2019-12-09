package com.example.pizzapp;

public class Model {

    private int pizza_size;
    private String price;

    public Model(int pizza_size, String price) {
        this.pizza_size = pizza_size;
        this.price = price;
    }

    public int getPizza_size() {
        return pizza_size;
    }

    public void setPizza_size(int pizza_size) {
        this.pizza_size = pizza_size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
