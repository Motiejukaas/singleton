package com.lab3.singleton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.Clock;
import java.util.ResourceBundle;

public class OutputController implements Initializable {

    @FXML
    private Label account_name, balance;

    @FXML
    private TableView<?> transactions_table;

    @FXML
    private TableColumn<Transaction, Integer> amount;

    @FXML
    private TableColumn<Transaction, String> time;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amount.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("amount"));
        time.setCellValueFactory(new PropertyValueFactory<Transaction, String>("time"));
    }
}
