module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires com.AcessoBD;

    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
    opens com.example.javafx.controller to javafx.fxml;
    exports com.example.javafx.controller;
    exports com.example.javafx.controller.Instrutor;
    exports com.example.javafx.controller.Rececionista;
}