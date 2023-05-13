module com.lab3.singleton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab3.singleton to javafx.fxml;
    exports com.lab3.singleton;
}