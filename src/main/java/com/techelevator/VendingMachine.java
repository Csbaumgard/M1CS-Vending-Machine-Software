package com.techelevator;

import com.techelevator.view.Menu;

import java.util.logging.Logger;

public class VendingMachine {

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
        Logger.getGlobal();
    }
}
