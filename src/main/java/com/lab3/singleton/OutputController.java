package com.lab3.singleton;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

    public void transfer_data() {
            process_data2();
    }

    public void transfer_data(ActionEvent actionEvent) {
        process_data1(actionEvent);
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

    public void process_data1(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        AccountData account_data = (AccountData) stage.getUserData();
        account_name.setText("Account: " + account_data.getName());
        balance.setText("Balance: " + account_data.getAmount());
        transactions_table.setItems(account_data.getTransactions());
    }

    public void process_data2() {
//        account_name.setText("Account: " + Singleton.getInstance().regular_account != null ? Singleton.getInstance().regular_account.getName() : Singleton.getInstance().groceries_account != null ? Singleton.getInstance().groceries_account.getName() : Singleton.getInstance().savings_account.getName());
//        balance.setText("Balance: " + Double.toString(Singleton.getInstance().regular_account != null ? Singleton.getInstance().regular_account.getAmount() : Singleton.getInstance().groceries_account != null ? Singleton.getInstance().groceries_account.getAmount() : Singleton.getInstance().savings_account.getAmount()));
//        transactions_table.setItems(Singleton.getInstance().regular_account != null ? Singleton.getInstance().regular_account.getTransactions() : Singleton.getInstance().groceries_account != null ? Singleton.getInstance().groceries_account.getTransactions() : Singleton.getInstance().savings_account.getTransactions());
        account_name.setText("Account: " + Singleton.getInstance().getData().getName());
        balance.setText("Balance: " + Singleton.getInstance().getData().getAmount());
        transactions_table.setItems(Singleton.getInstance().getData().getTransactions());
    }
}
