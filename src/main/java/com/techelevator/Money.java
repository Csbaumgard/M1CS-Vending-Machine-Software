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

    public void dispenseChange(double balance) {
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        System.out.println("Your change is: ");
            while (balance >= 0) {
                if (balance >= 1.0) {
                    quarterCount += 4;
                    balance -= 1.0;
                } else if (balance >= 0.75) {
                        quarterCount += 3;
                        balance -= 0.75;
                        System.out.println(quarterCount + " quarters");
                    } else if (balance >= 0.50) {
                        quarterCount += 2;
                        balance -= 0.50;
                        System.out.println(quarterCount + " quarters");
                    } else if (balance >= 0.25) {
                        quarterCount += 1;
                        balance -= 0.25;
                        System.out.println(quarterCount + " quarter");
                    } else if (balance >= 0.20) {
                        dimeCount += 2;
                        balance -= 0.20;
                        System.out.println(dimeCount + " dimes");
                    } else if (balance >= 0.10) {
                        dimeCount += 1;
                        balance -= 0.10;
                        System.out.println(dimeCount + " dime");
                    } else if (balance >= 0.05) {
                        nickelCount += 1;
                        balance -= 0.05;
                        System.out.println(nickelCount + " nickel");
                    } else if (balance == 0) {
                        System.out.println(quarterCount + " quarters");
                        break;
                    } else {
                    break;
                }
                }
            }




    public void balanceClear() {
        balance = 0;
    }
}


    // User selects option 2 to purchase
    // Displays "Please insert cash (1's, 2's, 5's, 10's)" , also displays current value
    // returns to purchase menu after user feeds money


