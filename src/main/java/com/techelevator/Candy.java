package com.techelevator;

public class Candy extends Items {

    public Candy(String slot, String name, double price) {
        super(slot, name, price, 5);
    }
    @Override
    public String getSound() {
        return "Munch Munch, Yum!";
    }

}


