package com.lab3.singleton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccountData {
    private double amount;
    private String name;
    private ObservableList<Transaction> transactions = FXCollections.observableArrayList();

    public AccountData(double amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public void withdraw(double sum) {
        if (sum > amount) {
            return;
        }
        amount -= sum;
    }

    public void insert(double sum) {
        amount += sum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ObservableList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}


