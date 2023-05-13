package com.lab3.singleton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

    @FXML
    private ToggleGroup money_direction;

    @FXML
    public void submitData(ActionEvent actionEvent) {
        try {
            String account_name_value = account_name.getText();
            String account_type_value = account_type.getValue();
            double amount = Double.parseDouble(this.amount.getText());
            boolean isInsert = insert.isSelected();
            boolean isWithdraw = withdraw.isSelected();

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String time = currentDateTime.format(formatter);

            if (amount <= 0 && account_type_value == null && account_type_value.isEmpty()) {
                throw new NumberFormatException();
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