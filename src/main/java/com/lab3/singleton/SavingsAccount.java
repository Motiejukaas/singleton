package com.lab3.singleton;

public class SavingsAccount extends AccountData {

    private double withdraw_limit;

    public SavingsAccount(String name, double amount, String time) {
        super(name, amount, time);
        setWithdraw_limit(500);
    }

    @Override
    public void withdraw(double sum) {

        if (-sum > withdraw_limit) {
            return;
        }
        super.withdraw(sum);
    }

    public boolean isWithdrawable(double sum) {
        return -sum <= withdraw_limit;
    }

    public double getWithdraw_limit() {
        return withdraw_limit;
    }

    public void setWithdraw_limit(double withdraw_limit) {
        this.withdraw_limit = withdraw_limit;
    }
}
