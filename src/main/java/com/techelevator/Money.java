package com.techelevator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Money {
    public int balance;


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String addMoney(int amount) {

            if (amount == 1 || amount == 2 || amount == 5 || amount == 10) {
                balance += amount;
                return amount + " was accepted.";
            } else {
                return amount + " is not a valid amount.";
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
                    if (balance == 0) {
                        System.out.println(quarterCount + " quarters");
                    }
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
                        System.out.println(quarterCount + " quarters");
                    } else if (balance >= 0.20) {
                        dimeCount += 2;
                        balance -= 0.20;
                        System.out.println(dimeCount + " dimes");
                    } else if (balance >= 0.10) {
                        dimeCount += 1;
                        balance -= 0.10;
                        System.out.println(dimeCount + " dimes");
                    } else if (balance >= 0.05) {
                        nickelCount += 1;
                        balance -= 0.05;
                        System.out.println(nickelCount + " nickels");
                    } else if (balance == 0) {
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



