package org.anurag;

public class Task10_2 {
    private Task10_1 account;

    public Task10_2(Task10_1 account) {
        this.account = account;
    }

    public void processTransaction(String type, double amount) {
        if ("deposit".equalsIgnoreCase(type)) {
            account.deposit(amount);
        } else if ("withdraw".equalsIgnoreCase(type)) {
            account.withdraw(amount);
        } else {
            throw new IllegalArgumentException("Invalid transaction type");
        }
    }

    public double getAccountBalance() {
        return account.getBalance();
    }
}
