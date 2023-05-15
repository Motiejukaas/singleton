package com.lab3.singleton;

public class GroceriesAccount extends AccountData {
    private double insert_limit;

    public GroceriesAccount(String name, double amount, String time) {
        super(name, amount, time);
        setInsert_limit(500);
    }

    @Override
    public void insert(double sum) {
        if (sum > insert_limit) {
            return;
        }
        super.insert(sum);
    }

    public boolean isInsertable(double sum) {
        return sum <= insert_limit;
    }

    public double getInsert_limit() {
        return insert_limit;
    }

    public void setInsert_limit(double insert_limit) {
        this.insert_limit = insert_limit;
    }
}
