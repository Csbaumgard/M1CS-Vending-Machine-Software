package com.techelevator;

public abstract class Item {
    private String name;
    private String price;

    public Item(String name, String price) {
    }

    public abstract String getItemSound();
}
