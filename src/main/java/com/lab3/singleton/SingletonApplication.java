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
        InputController input_controller = input_fxml_loader.getController();
        OutputController output_controller = output_fxml_loader.getController();
        input_controller.setOutput_controller(output_controller);

        if (data_transfer_type == DataTransferType.USER_DATA) {
            Stage stage11 = new Stage();
            stage11.setScene(input_scene);
            stage11.setTitle("ATM");
            AccountData account_data = new AccountData();
            stage11.setUserData(account_data);

            Stage stage12 = new Stage();
            stage12.setScene(output_scene);
            stage11.setTitle("Bank Account");
            stage11.setUserData(account_data);

            stage11.setScene(input_scene);
            input_controller.setNext_stage(stage12);
            stage11.show();
        } else if (data_transfer_type == DataTransferType.CONTROLLER) {
            Stage stage21 = new Stage();
            stage21.setScene(input_scene);
            stage21.setTitle("ATM");

            Stage stage22 = new Stage();
            stage22.setScene(output_scene);
            stage21.setTitle("Bank Account");

            stage21.setScene(input_scene);
            input_controller.setNext_stage(stage22);
            stage21.show();
        } else if (data_transfer_type == DataTransferType.SINGLETON) {
            Stage stage31 = new Stage();
            stage31.setScene(input_scene);
            stage31.setTitle("ATM");

            Stage stage32 = new Stage();
            stage32.setScene(output_scene);
            stage31.setTitle("Bank Account");

            stage31.setScene(input_scene);
            input_controller.setNext_stage(stage32);
            stage31.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}