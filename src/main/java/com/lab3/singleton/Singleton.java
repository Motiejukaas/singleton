package com.lab3.singleton;


import java.util.Objects;

public class Singleton {
    private static volatile Singleton instance;

    CurrentAccount regular_account = null;
    GroceriesAccount groceries_account = null;
    SavingsAccount savings_account = null;

    private Singleton(String account_type, String account_name, double amount, String time) {
        if (Objects.equals(account_type, "Regular account")) {
            regular_account = new CurrentAccount(account_name, amount, time);
            System.out.println(regular_account.getName());
        } else if (Objects.equals(account_type, "Groceries account")) {
            groceries_account = new GroceriesAccount(account_name, amount, time);
        } else if (Objects.equals(account_type, "Savings account")) {
            savings_account = new SavingsAccount(account_name, amount, time);
        }
    }

    public static Singleton getInstance(String account_type, String account_name, double amount, String time) {
        Singleton result = instance;
        if (instance == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton(account_type, account_name, amount, time);
                }
            }
        }
        return result;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public AccountData getData() {
        if (regular_account != null) {
            return regular_account;
        } else if (groceries_account != null) {
            return groceries_account;
        } else if (savings_account != null) {
            return savings_account;
        }
        return null;
    }
}
