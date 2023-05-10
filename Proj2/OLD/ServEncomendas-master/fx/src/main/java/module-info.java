module com.example.fx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.example.bd;


    opens com.example.fx to javafx.fxml;
    exports com.example.fx;
    exports com.example.fx.controllerAdmin;
    opens com.example.fx.controllerAdmin to javafx.fxml;
    exports com.example.fx.controllerEstafeta;
    opens com.example.fx.controllerEstafeta to javafx.fxml;
    opens com.example.fx.controllerGestor to javafx.fxml;
    exports com.example.fx.controllerGestor;
    opens com.example.fx.controllerCozinheiro to javafx.fxml;
    exports com.example.fx.controllerCozinheiro;

     //requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.logging;
    requires java.persistence;
    requires java.sql;


}