package com.techelevator;

import com.techelevator.Money;
import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {
        // addMoney given 1 -> 1 was accepted
        // addMoney given 3 -> 3 is not a valid amount
        // addMoney given empty String -> null is not a valid amount
        //=============================================
        // dispenseChange given 3.40 -> 13 quarters, 1 dime, 1 nickel
        // dispenseChange given 0.00 -> nothing

    @Test
    public void addMoney_given_1_returns_1_was_accepted() {
        Money sut = new Money();

        String addMoney = sut.addMoney(1);

        Assert.assertEquals(1 + " was accepted.", addMoney);
    }
    @Test
    public void addMoney_given_3_returns_3_is_not_a_valid_amount() {
        Money sut = new Money();

        String addMoney = sut.addMoney(3);

        Assert.assertEquals(3 + " is not a valid amount.", addMoney);
    }
}