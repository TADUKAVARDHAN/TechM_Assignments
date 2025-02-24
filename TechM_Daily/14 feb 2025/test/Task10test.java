package org.anurag.test;

import org.anurag.Task10_1;
import org.anurag.Task10_2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task10test {
    private Task10_2 transactionService;
    private Task10_1 account;

    @Before
    public void setup() {
        account = new Task10_1(1000); // Initial balance: 1000
        transactionService = new Task10_2(account);
    }

    @Test
    public void testDeposit() {
        transactionService.processTransaction("deposit", 500);
        Assert.assertEquals(1500, transactionService.getAccountBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        transactionService.processTransaction("withdraw", 300);
        Assert.assertEquals(700, transactionService.getAccountBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientBalance() {
        transactionService.processTransaction("withdraw", 2000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTransaction() {
        transactionService.processTransaction("transfer", 500);
    }
}
