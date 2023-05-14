package com.lab3.singleton;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OutputController implements Initializable {

    @FXML
    private Label account_name, balance;

    @FXML
    private TableView<Transaction> transactions_table;

    @FXML
    private TableColumn<Transaction, Double> amount;

    @FXML
    private TableColumn<Transaction, String> time;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amount.setCellValueFactory(new PropertyValueFactory<Transaction, Double>("amount"));
        time.setCellValueFactory(new PropertyValueFactory<Transaction, String>("time"));
    }

    public void transfer_data(CurrentAccount account) {
        process_data(account.getName(), account.getAmount(), account.getTransactions());
    }

    public void transfer_data(GroceriesAccount account) {
        process_data(account.getName(), account.getAmount(), account.getTransactions());

    }

    public void transfer_data(SavingsAccount account) {
        process_data(account.getName(), account.getAmount(), account.getTransactions());
    }

    public void process_data(String name, double amount, ObservableList<Transaction> transactions) {
        account_name.setText("Account: " + name);
        balance.setText("Balance: " + amount);
        transactions_table.setItems(transactions);
    }
}
