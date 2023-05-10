module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;

    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
    opens controller to javafx.fxml;
    exports controller;
}