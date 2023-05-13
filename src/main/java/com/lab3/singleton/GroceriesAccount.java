package com.lab3.singleton;

public class GroceriesAccount extends AccountData {
    private double insert_limit;

    public GroceriesAccount(double amount, String name) {
        super(amount, name);
    }

    @Override
    public void insert(double sum) {
        if (sum > insert_limit) {
            return;
        }
        super.insert(sum);
    }

    public double getWithdrawLimit() {
        return insert_limit;
    }

    public void setWithdrawLimit(double insert_limit) {
        this.insert_limit = insert_limit;
    }
}
