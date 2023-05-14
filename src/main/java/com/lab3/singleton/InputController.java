package com.lab3.singleton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

            if (isWithdraw ) {
                amount = -amount;
            }

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String time = currentDateTime.format(formatter);

            if (SingletonApplication.data_transfer_type == DataTransferType.USER_DATA) {

            } else if (SingletonApplication.data_transfer_type == DataTransferType.CONTROLLER) {
                if (account_type_value == "Regular account") {
                    output_controller.transfer_data(new CurrentAccount(account_name_value, amount, time));
                } else if (account_type_value == "Groceries account") {
                    output_controller.transfer_data(new GroceriesAccount(account_name_value, amount, time));
                } else if (account_type_value == "Savings account") {
                    output_controller.transfer_data(new SavingsAccount(account_name_value, amount, time));
                }
                next_stage.show();
            } else if (SingletonApplication.data_transfer_type == DataTransferType.SINGLETON) {

            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account_type.getItems().addAll("Regular account", "Groceries account", "Savings account");
        account_type.setValue("Regular account");
    }
}