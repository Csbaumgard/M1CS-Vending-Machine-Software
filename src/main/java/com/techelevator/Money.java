package com.techelevator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Money {
    public int balance;
    private Scanner userInput = new Scanner(System.in);

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBalanceInDollars(int givenBalance)
    {
        DecimalFormat df = new DecimalFormat("###.00");
        return "$" + df.format((double)givenBalance / 100);
    }

    public String addMoney(int amount) {
        if (amount == 1 || amount == 2 || amount == 5 || amount == 10) {
            balance += amount;
            return amount + " was accepted.";
        } else {
            return amount + " is not a valid amount";
        }
    }
}


    // User selects option 2 to purchase
    // Displays "Please insert cash (1's, 2's, 5's, 10's)" , also displays current value
    // returns to purchase menu after user feeds money


