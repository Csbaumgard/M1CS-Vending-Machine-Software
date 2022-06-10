package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.PurchaseMenu;

public class VendingMachine {

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenu);
        cli.run();
    }
}
