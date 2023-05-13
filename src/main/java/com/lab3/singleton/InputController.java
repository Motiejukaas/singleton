package com.lab3.singleton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InputController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}