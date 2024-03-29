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
    exports com.example.javafx.InstrutorController;
    opens com.example.javafx.InstrutorController to javafx.fxml;
    exports com.example.javafx.RececionistaController;
    opens com.example.javafx.RececionistaController to javafx.fxml;
    exports com.example.javafx.AdministradorController;
    opens com.example.javafx.AdministradorController to javafx.fxml;
}