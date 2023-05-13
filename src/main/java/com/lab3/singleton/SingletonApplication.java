package com.lab3.singleton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// @author Motiejus Šveikauskas

public class SingletonApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader input_fxml_loader = new FXMLLoader(SingletonApplication.class.getResource("input.fxml"));
        FXMLLoader output_fxml_loader = new FXMLLoader(SingletonApplication.class.getResource("output.fxml"));
        Scene input_scene = new Scene(input_fxml_loader.load());
        Scene output_scene = new Scene(output_fxml_loader.load());
        InputController input_controller = (InputController) input_fxml_loader.getController();
        OutputController output_controller = (OutputController) output_fxml_loader.getController();
        stage.setTitle("ATM");
        stage.setScene(input_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}