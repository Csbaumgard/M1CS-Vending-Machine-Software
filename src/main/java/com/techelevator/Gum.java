package com.techelevator;

public class Gum extends Items {

    public Gum(String slot, String name, double price) {
        super(slot, name, price, 5);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
