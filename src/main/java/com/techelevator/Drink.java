package com.techelevator;

public class Drink extends Items {


    public Drink(String slot, String name, double price) {
        super(slot, name, price, 5);
    }
    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
