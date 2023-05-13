package com.lab3.singleton;

public class SavingsAccount extends AccountData {

    private double withdraw_limit;

    public SavingsAccount(double amount, String name) {
        super(amount, name);
    }

    @Override
    public void withdraw(double sum) {
        if (sum > withdraw_limit) {
            return;
        }
        super.withdraw(sum);
    }

    public double getWithdraw_limit() {
        return withdraw_limit;
    }

    public void setWithdraw_limit(double withdraw_limit) {
        this.withdraw_limit = withdraw_limit;
    }
}
