package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.Money;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	// Purchase Menu Variables

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY= "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private final Menu menu;
	Scanner userInput = new Scanner(System.in);
	File inputFile = new File("vendingmachine.csv");
	FileReader fileReader = new FileReader();
	public double currentBalance;
	DecimalFormat df = new DecimalFormat("###.00");
	Money balance = new Money();


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		fileReader.fileReader();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
				fileReader.displayVendingItems();
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					runPurchase();
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.exit(0);
			}
		}
	}

	public void runPurchase() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			switch (choice) {
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					System.out.println("Current Balance: $" + df.format(currentBalance));
					balance.balanceClear();
					System.out.println("Please insert valid bills (1's, 2's, 5's, 10's) ");
					int nextBill = Integer.parseInt(userInput.nextLine());
					balance.addMoney(nextBill);
					currentBalance += balance.getBalance();
					System.out.println("Current Balance: $" + df.format(currentBalance));
					break;
				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					fileReader.displayVendingItems(); //run fileReader.displayVendingItems() again to  display,
					System.out.println("Current Balance: $" + df.format(currentBalance));
					System.out.println("Please enter item code for selection (Example: A1) ");
					String slot = userInput.nextLine().toUpperCase();

					if (currentBalance - fileReader.userProductPrice(slot) >= 0) {
						fileReader.userSelectProduct(slot);
						currentBalance -= fileReader.userProductPrice(slot);
					} else {
						System.out.println("Insufficient funds.");
					}
					System.out.println("Current Balance: $" + df.format(currentBalance));
					break;
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					System.out.println("Dispensing Change...");
					balance.dispenseChange(currentBalance);
					currentBalance = 0;
					run();
			}
		}
	}


}
