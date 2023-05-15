package com.lab3.singleton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class InputController implements Initializable {

    @FXML
    public Button proceed;

    @FXML
    private ChoiceBox<String> account_type;

    @FXML
    private TextField amount, account_name;

    @FXML
    private RadioButton insert, withdraw;

    private OutputController output_controller;

    private Stage next_stage;

    public Stage getNext_stage() {
        return next_stage;
    }

    public void setNext_stage(Stage next_stage) {
        this.next_stage = next_stage;
    }

    public OutputController getOutput_controller() {
        return output_controller;
    }

    public void setOutput_controller(OutputController output_controller) {
        this.output_controller = output_controller;
    }

    @FXML
    public void submitData(ActionEvent actionEvent) {
        try {
            String account_name_value = account_name.getText();
            String account_type_value = account_type.getValue();
            double amount = Double.parseDouble(this.amount.getText());
            boolean isInsert = insert.isSelected();
            boolean isWithdraw = withdraw.isSelected();

            if (amount <= 0) {
                throw new NumberFormatException();
            }

            if (isWithdraw) {
                amount = -amount;
            }

            if (Objects.equals(account_type_value, "Savings account")) {
                if (isWithdraw && !(new SavingsAccount(account_name_value, amount, "").isWithdrawable(amount))) {
                    throw new Exception("You cannot withdraw this amount from a savings account!");
                }
            } else if (Objects.equals(account_type_value, "Groceries account")) {
                if (isInsert && !(new GroceriesAccount(account_name_value, amount, "").isInsertable(amount))) {
                    throw new Exception("You cannot insert this amount into a groceries account!");
                }
            }

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String time = currentDateTime.format(formatter);

            if (SingletonApplication.data_transfer_type == DataTransferType.USER_DATA) {
                Node node = (Node) actionEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                /*
                if (Objects.equals(account_type_value, "Regular account")) {
                    CurrentAccount current_account = (CurrentAccount) stage.getUserData();
                    current_account.setName(account_name_value);
                    Random rand = new Random();
                    current_account.setAmount(rand.nextInt(1000));
                    current_account.setAmount(current_account.getAmount() + amount);
                    current_account.addTransaction(new Transaction(amount, time));
                } else if (Objects.equals(account_type_value, "Groceries account")) {
                    GroceriesAccount groceries_account = (GroceriesAccount) stage.getUserData();
                    groceries_account.setName(account_name_value);
                    Random rand = new Random();
                    groceries_account.setAmount(rand.nextInt(1000));
                    groceries_account.setAmount(groceries_account.getAmount() + amount);
                    groceries_account.addTransaction(new Transaction(amount, time));
                } else if (Objects.equals(account_type_value, "Savings account")) {
                    SavingsAccount savings_account = (SavingsAccount) stage.getUserData();
                    savings_account.setName(account_name_value);
                    Random rand = new Random();
                    savings_account.setAmount(rand.nextInt(1000));
                    savings_account.setAmount(savings_account.getAmount() + amount);
                    savings_account.addTransaction(new Transaction(amount, time));
                }*/

                AccountData current_account = (AccountData) stage.getUserData();
                current_account.setName(account_name_value);
                Random rand = new Random();
                current_account.setAmount(rand.nextInt(1000));
                current_account.setAmount(current_account.getAmount() + amount);
                current_account.addTransaction(new Transaction(amount, time));

                output_controller.transfer_data(actionEvent);
                next_stage.show();
            } else if (SingletonApplication.data_transfer_type == DataTransferType.CONTROLLER) {
                if (Objects.equals(account_type_value, "Regular account")) {
                    output_controller.transfer_data(new CurrentAccount(account_name_value, amount, time));
                } else if (Objects.equals(account_type_value, "Groceries account")) {
                    output_controller.transfer_data(new GroceriesAccount(account_name_value, amount, time));
                } else if (Objects.equals(account_type_value, "Savings account")) {
                    output_controller.transfer_data(new SavingsAccount(account_name_value, amount, time));
                }
                next_stage.show();
            } else if (SingletonApplication.data_transfer_type == DataTransferType.SINGLETON) {
                Singleton.getInstance(account_type_value, account_name_value, amount, time);
                output_controller.transfer_data();
                next_stage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account_type.getItems().addAll("Regular account", "Groceries account", "Savings account");
        account_type.setValue("Regular account");
    }
}