package com.techelevator;

import java.util.Scanner;

public class Money {
    private int balance;
    private Scanner userInput = new Scanner(System.in);

    public int getBalance() {
        return balance;
    }

    public String addMoney() {
        System.out.println("Please insert cash (1's, 2's, 5's, 10's)");
        String amount = userInput.nextLine();
        if (amount.equals("1") || amount.equals("2") || amount.equals("5") || amount.equals("10")) {
            balance += Integer.parseInt(amount);
            return amount + " was accepted.";
        } else {
            return amount + " is not a valid amount";
        }
    }
}


    // User selects option 2 to purchase
    // Displays "Please insert cash (1's, 2's, 5's, 10's)" , also displays current value
    // returns to purchase menu after user feeds money


