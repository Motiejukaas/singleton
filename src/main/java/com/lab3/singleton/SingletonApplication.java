package com.lab3.singleton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// @author Motiejus Šveikauskas

public class SingletonApplication extends Application {

    static DataTransferType data_transfer_type = DataTransferType.CONTROLLER;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader input_fxml_loader = new FXMLLoader(SingletonApplication.class.getResource("input.fxml"));
        FXMLLoader output_fxml_loader = new FXMLLoader(SingletonApplication.class.getResource("output.fxml"));
        Scene input_scene = new Scene(input_fxml_loader.load());
        Scene output_scene = new Scene(output_fxml_loader.load());
        InputController input_controller = (InputController) input_fxml_loader.getController();
        OutputController output_controller = (OutputController) output_fxml_loader.getController();

        if (data_transfer_type == DataTransferType.USER_DATA) {

        } else if (data_transfer_type == DataTransferType.CONTROLLER) {
            Stage stage21 = new Stage();
            stage21.setScene(input_scene);
            stage21.setTitle("ATM");
            input_controller.setOutput_controller(output_controller);

            Stage stage22 = new Stage();
            stage22.setScene(output_scene);
            stage21.setTitle("Bank Account");

            stage21.setScene(input_scene);
            stage21.show();

            input_controller.setNext_stage(stage22);
        } else if (data_transfer_type == DataTransferType.SINGLETON) {

        }
    }

    public static void main(String[] args) {
        launch();
    }
}