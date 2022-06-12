package com.techelevator;

public class Chip extends Items{

    public Chip(String slot, String name, double price) {
        super(slot, name, price, 5);

    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
