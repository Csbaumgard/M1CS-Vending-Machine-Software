package com.techelevator;

public class Chips extends Item {
    public Chips(String name,  String price) {
        super(name, price);
    }

    @Override
    public String getItemSound() {
        return "sound";
    }


}
